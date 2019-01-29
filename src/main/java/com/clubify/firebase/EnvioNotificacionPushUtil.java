package com.clubify.firebase;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.clubify.persistence.modelo.NotificacionEnvio;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Gux Lozada
 */
public final class EnvioNotificacionPushUtil {
    final static Logger LOG = Logger.getLogger(EnvioNotificacionPushUtil.class.getName());
    final static String FCM_URL = "https://fcm.googleapis.com/fcm/send";
    final static String FIREBASE_SERVER_KEY = "AIzaSyCZTT-4mYYCF8mmEvr0bVF5342xDFXQ3pc";

    /**
     * Envio masivo.
     * @param ntfPush
     * @return
     */
    public static List<Long> envioMasivo(List<NotificacionEnvio> ntfsPorEnviar) {
        List<Long> res = new ArrayList<>();
        if (ntfsPorEnviar == null || ntfsPorEnviar.isEmpty()) {
            return res;
        }
        //// HttpHost proxy = new HttpHost("192.9.200.3", 3128);
        HttpClient httpClient = new DefaultHttpClient();
        //// httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
        try {
            final Gson gson = new Gson();
            final Type type = new TypeToken<NotificacionPayload>() {
            }.getType();
            ntfsPorEnviar.forEach(ntfPush -> {
                try {
                    if (!StringUtils.isBlank(ntfPush.getIdTelefono())) {
                        LOG.log(Level.FINE, "++++ Notificacion push: " + ntfPush.toString());
                        NotificacionPayload notificacionPayload = new NotificacionPayload(ntfPush.getIdTelefono(),
                                ntfPush.getTitulo(), ntfPush.getDetalle());
                        // notificacionPayload.setData(new DataDTO(ntfPush.getDetalle()));
                        String json = gson.toJson(notificacionPayload, type);
                        LOG.log(Level.FINE, "++++ Notificacion payload: " + json);
                        HttpPost postRequest = new HttpPost(FCM_URL);
                        postRequest.addHeader("Authorization", "key=" + FIREBASE_SERVER_KEY);
                        StringEntity input = new StringEntity(json);
                        input.setContentType("application/json");
                        postRequest.setEntity(input);
                        HttpResponse response = httpClient.execute(postRequest);
                        // Opciones 1=Pendiente, 2=Enviado
                        if (response.getStatusLine().getStatusCode() == 200) {
                            res.add(ntfPush.getCodNotificacion());
                            LOG.log(Level.FINE, "Envio correcto: response=" + EntityUtils.toString(response.getEntity()));
                        } else {
                            LOG.log(Level.WARNING,
                                    "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \n"
                                            + "WWWWW Envio fallido: Codigo HTTP=" + response.getStatusLine().getStatusCode()
                                            + ", Response=" + EntityUtils.toString(response.getEntity()));
                        }
                    }
                } catch (Exception e) {
                    LOG.log(Level.SEVERE,
                            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXX " + e.getMessage(), e);
                }
            });
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return res;
    }

    /**
     * Envio individual
     * @param ntfPush
     * @return Verdadero si se envio sin problemas.
     */
    public static boolean envioIndividual(NotificacionEnvio ntfPush) {
        LOG.log(Level.FINE, "++++ Enviar: " + ntfPush.toString());
        NotificacionPayload notificacionPayload = new NotificacionPayload(ntfPush.getIdTelefono(), ntfPush.getTitulo(),
                ntfPush.getDetalle());
        // notificacionPayload.setData(new DataDTO(ntfPush.getDetalle()));
        Gson gson = new Gson();
        Type type = new TypeToken<NotificacionPayload>() {
        }.getType();
        return envioFirebase(gson.toJson(notificacionPayload, type));
    }

    private static boolean envioFirebase(String json) {
        LOG.log(Level.FINE, "++++ payload: " + json);
        boolean res = false;
        HttpClient httpClient = null;
        try {
            //// HttpHost proxy = new HttpHost("192.9.200.3", 3128);
            httpClient = new DefaultHttpClient();
            //// httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
            HttpPost postRequest = new HttpPost(FCM_URL);
            StringEntity input = new StringEntity(json);
            input.setContentType("application/json");
            postRequest.addHeader("Authorization", "key=" + FIREBASE_SERVER_KEY);
            postRequest.setEntity(input);
            HttpResponse response = httpClient.execute(postRequest);
            // Opciones 1=Pendiente, 2=Enviado
            if (response.getStatusLine().getStatusCode() == 200) {
                res = true;
                LOG.log(Level.FINE, "Envio correcto: response=" + EntityUtils.toString(response.getEntity()));
            } else {
                LOG.log(Level.WARNING,
                        "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \n"
                                + "WWWWW Envio fallido: Codigo HTTP=" + response.getStatusLine().getStatusCode() + ", Response="
                                + EntityUtils.toString(response.getEntity()));
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXX " + e.getMessage(),
                    e);
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return res;
    }
}
