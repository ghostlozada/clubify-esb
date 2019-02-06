package com.clubify.firebase;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.ValidationException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * @author Gux Lozada
 */
public final class ActualizacionClaveUsuarioUtil {
    final static Logger LOG = Logger.getLogger(ActualizacionClaveUsuarioUtil.class.getName());
    final static String URL_BD = "https://clubifyec-b714e.firebaseio.com/";

    public static String consultar(String consulta) {
        if (StringUtils.isBlank(consulta)) {
            return "ERROR: consulta es nulo";
        }
        StringBuilder res = new StringBuilder();
        HttpClient httpClient = null;
        try {
            // HttpHost proxy = new HttpHost("192.9.200.3", 3128);
            httpClient = new DefaultHttpClient();
            String uriString = StringUtils.join(URL_BD, consulta);
            LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            LOG.info(">>>> consultar URI=" + uriString);
            HttpGet getRequest = new HttpGet(uriString);
            getRequest.addHeader("X-Firebase-Decoding", "1");
            HttpResponse response = httpClient.execute(getRequest);
            res.append(response.getStatusLine().getStatusCode()).append(":");
            String responseEntity = "nulo";
            if (response.getEntity() != null) {
                responseEntity = EntityUtils.toString(response.getEntity());
                res.append(responseEntity);
            }
            if (response.getStatusLine().getStatusCode() == 200) {
                LOG.info(MessageFormat.format("LLamada correcta consultar: response={0}", res));
            } else {
                LOG.warning("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \nWWWWW "
                        + MessageFormat.format("LLamada fallida consultar: Codigo HTTP={0}; response={1}",
                                response.getStatusLine().getStatusCode(), responseEntity));
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXX"
                    + MessageFormat.format("Error en la llamada consultar: error={0}", e.getMessage()), e);
            res.append("ERROR:").append(e.getMessage());
        } finally {
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
        return res.toString();
    }

    /**
     * Obtener el registro relacionado al correo
     * @param correo
     * @return
     * @throws ValidationException Causas:
     *             <ul>
     *             <li>ERROR: El correo no puede ser nulo.</li>
     *             <li>ERROR: Error en la ejecucion de la consulta a Firebase.</li>
     *             <li>ERROR: No existe un usuario registrado con el correo.</li>
     *             <li>ERROR: Existe multiples usuarios registrados con el mismo correo. "</li>
     *             </ul>
     */
    public static String consultarPorCorreo(String correo) throws ValidationException {
        if (StringUtils.isBlank(correo)) {
            throw new ValidationException("ERROR: El correo no puede ser nulo.");
        }
        HttpClient httpClient = null;
        String responseEntity = null;
        int statusCode = -1;
        try {
            String uriString = StringUtils.join(URL_BD, "users.json?orderBy=%22email%22&equalTo=%22", correo, "%22");
            LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            LOG.info(">>>> consultarPorCorreo URI=" + uriString);
            HttpGet getRequest = new HttpGet(uriString);
            getRequest.addHeader("X-Firebase-Decoding", "1");
            httpClient = new DefaultHttpClient();
            HttpResponse response = httpClient.execute(getRequest);
            statusCode = response.getStatusLine().getStatusCode();
            if (response.getEntity() != null) {
                responseEntity = EntityUtils.toString(response.getEntity());
            }
            if (statusCode != 200) {
                LOG.info("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \nWWWWW "
                        + MessageFormat.format("LLamada fallida consultarPorCorreo: Codigo HTTP={0}; response={1}", statusCode,
                                responseEntity));
                throw new ValidationException("ERROR: Codigo HTTP=" + statusCode + ";  respuesta=" + responseEntity);
            }
            // Http Response 200 OK
            int count = StringUtils.countMatches(responseEntity, correo);
            LOG.log(Level.SEVERE, MessageFormat.format("LLamada correcta consultarPorCorreo: response={0}", responseEntity));
            if (count == 0) {
                throw new ValidationException("ERROR: No existe un usuario registrado con el correo: " + correo);
            } else if (count > 1) {
                throw new ValidationException("ERROR: Existe " + count + " usuarios registrados con el mismo correo: " + correo);
            }
            return responseEntity;
        } catch (Exception e) {
            LOG.log(Level.WARNING, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXX"
                    + MessageFormat.format("Error en la llamada consultarPorCorreo. mensaje={0}", e.getMessage()), e);
            throw new ValidationException(
                    "ERROR: En la ejecucion de la consulta a Firebase. mensaje=" + ExceptionUtils.getRootCauseMessage(e));
        } finally {
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
    }

    public static void actualizarClave(String userJson, String nuevaClave) throws ValidationException {
        if (StringUtils.isBlank(userJson)) {
            throw new ValidationException("ERROR: Se requiere la informacion del usuario en formato JSON.");
        }
        if (StringUtils.isBlank(nuevaClave)) {
            throw new ValidationException("ERROR: La nueva clave no puede ser nula.");
        }
        HttpClient httpClient = null;
        String responseEntity = null;
        int statusCode = -1;
        try {
            String[] partes = StringUtils.split(userJson, ":", 2);
            if (partes == null || partes.length != 2) {
                throw new ValidationException("ERROR: No se puede obtener el identificador del usuario.");
            }
            LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            LOG.info(">>>> partes[0]=" + partes[0]);
            LOG.info(">>>> partes[1]=" + partes[1]);
            String idUsuario = StringUtils.substringBetween(partes[0], "\"");
            String uriString = StringUtils.join(URL_BD, "users/", idUsuario, "/password.json");
            LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            LOG.info(">>>> actualizarClave URI=" + uriString);
            HttpPut putRequest = new HttpPut(uriString);
            StringEntity input = new StringEntity(StringUtils.join("\"", nuevaClave, "\""));
            input.setContentType("application/json");
            putRequest.setEntity(input);
            httpClient = new DefaultHttpClient();
            HttpResponse response = httpClient.execute(putRequest);
            statusCode = response.getStatusLine().getStatusCode();
            if (response.getEntity() != null) {
                responseEntity = EntityUtils.toString(response.getEntity());
            }
            if (statusCode != 200) {
                LOG.info("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \nWWWWW "
                        + MessageFormat.format("LLamada fallida actualizarClave: Codigo HTTP={0}; response={1}", statusCode,
                                responseEntity));
                throw new ValidationException("ERROR: Codigo HTTP=" + statusCode + ";  respuesta=" + responseEntity);
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXX"
                    + MessageFormat.format("Error en la llamada actualizarClave. mensaje={0}", e.getMessage()), e);
            throw new ValidationException(
                    "ERROR: En la ejecucion de la actualizacion a Firebase. mensaje=" + ExceptionUtils.getRootCauseMessage(e));
        } finally {
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
    }
}
