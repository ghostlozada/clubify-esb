package com.clubify.firebase;

import java.net.URLEncoder;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public final class FirebaseTestUtil {
    final static Logger LOG = Logger.getLogger(FirebaseTestUtil.class.getName());
    final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    final static String URL_BD = "https://fir-gux-push.firebaseio.com/";

    public static String uno(String alias) {
        if (StringUtils.isBlank(alias)) {
            return "ERROR: nombre es nulo";
        }
        StringBuilder res = new StringBuilder();
        HttpClient httpClient = null;
        String horaEjecucion = LocalDateTime.now().format(formatter);
        try {
            // HttpHost proxy = new HttpHost("192.9.200.3", 3128);
            httpClient = new DefaultHttpClient();
            String uriString = StringUtils.join(URL_BD, "users/", alias, "/alias.json");
            LOG.severe(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            LOG.severe(">>>> uno URI=" + uriString);
            HttpGet getRequest = new HttpGet(uriString);
            HttpResponse response = httpClient.execute(getRequest);
            res.append(response.getStatusLine().getStatusCode()).append(":");
            String responseEntity = "nulo";
            if (response.getEntity() != null) {
                responseEntity = EntityUtils.toString(response.getEntity());
                res.append(responseEntity);
            }
            if (response.getStatusLine().getStatusCode() == 200) {
                LOG.log(Level.FINE, MessageFormat.format("LLamada correcta uno: Hora={0}; response={1}", horaEjecucion, res));
            } else {
                LOG.log(Level.WARNING,
                        "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \nWWWWW "
                                + MessageFormat.format("LLamada fallida uno: Hora={0}; Codigo HTTP={1}; response={2}",
                                        horaEjecucion, response.getStatusLine().getStatusCode(), responseEntity));
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING,
                    "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXX"
                            + MessageFormat.format("Error en la llamada uno: Hora={0}; error={1}", horaEjecucion, e.getMessage()),
                    e);
            res.append("ERROR:").append(e.getMessage());
        } finally {
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
        return res.toString();
    }

    public static String dos(String alias) {
        if (StringUtils.isBlank(alias)) {
            return "ERROR: nombre es nulo";
        }
        StringBuilder res = new StringBuilder();
        HttpClient httpClient = null;
        String horaEjecucion = LocalDateTime.now().format(formatter);
        try {
            /////////////////////////////////////////////////////////////////////////////
            // // Load the service account key JSON file
            // FileInputStream serviceAccount = new FileInputStream(
            // "C:/glassfish4/privatekey/fir-gux-push-firebase-adminsdk-fxc82-0d35306ee7.json");
            // // Authenticate a Google credential with the service account
            // GoogleCredential googleCred = GoogleCredential.fromStream(serviceAccount);
            // // Add the required scopes to the Google credential
            // GoogleCredential scoped =
            // googleCred.createScoped(Arrays.asList("https://www.googleapis.com/auth/firebase.database",
            // "https://www.googleapis.com/auth/userinfo.email"));
            // // Use the Google credential to generate an access token
            // scoped.refreshToken();
            // String token = scoped.getAccessToken();
            // String uriString = StringUtils.join(URL_BD, "users/", alias, "/alias.json?access_token=", token);
            //////////////////////////////////////////////////////////////////////////////
            // HttpHost proxy = new HttpHost("192.9.200.3", 3128);
            httpClient = new DefaultHttpClient();
            String uriString = StringUtils.join(URL_BD, "users/", alias, "/alias.json");
            LOG.severe(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            LOG.severe(">>>> dos URI=" + uriString);
            HttpGet getRequest = new HttpGet(uriString);
            HttpResponse response = httpClient.execute(getRequest);
            res.append(response.getStatusLine().getStatusCode()).append(":");
            String responseEntity = "nulo";
            if (response.getEntity() != null) {
                responseEntity = EntityUtils.toString(response.getEntity());
                res.append(responseEntity);
            }
            if (response.getStatusLine().getStatusCode() == 200) {
                LOG.log(Level.FINE, MessageFormat.format("LLamada correcta dos: Hora={0}; response={1}", horaEjecucion, res));
            } else {
                LOG.log(Level.WARNING,
                        "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \nWWWWW "
                                + MessageFormat.format("LLamada fallida dos: Hora={0}; Codigo HTTP={1}; response={2}",
                                        horaEjecucion, response.getStatusLine().getStatusCode(), responseEntity));
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING,
                    "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXX"
                            + MessageFormat.format("Error en la llamada dos: Hora={0}; error={1}", horaEjecucion, e.getMessage()),
                    e);
            res.append("ERROR:").append(e.getMessage());
        } finally {
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
        return res.toString();
    }

    public static String tres() {
        StringBuilder res = new StringBuilder();
        HttpClient httpClient = null;
        String horaEjecucion = LocalDateTime.now().format(formatter);
        try {
            // HttpHost proxy = new HttpHost("192.9.200.3", 3128);
            httpClient = new DefaultHttpClient();
            String uriString = StringUtils.join(URL_BD, "users.json?orderBy=", URLEncoder.encode("alias", "UTF-8"), "&equalTo=",
                    URLEncoder.encode("uno", "UTF-8"));
            LOG.severe(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            LOG.severe(">>>> tres URI=" + uriString);
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
                LOG.log(Level.FINE, MessageFormat.format("LLamada correcta tres: Hora={0}; response={1}", horaEjecucion, res));
            } else {
                LOG.log(Level.WARNING,
                        "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \nWWWWW "
                                + MessageFormat.format("LLamada fallida tres: Hora={0}; Codigo HTTP={1}; response={2}",
                                        horaEjecucion, response.getStatusLine().getStatusCode(), responseEntity));
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXX"
                    + MessageFormat.format("Error en la llamada tres: Hora={0}; error={2}", horaEjecucion, e.getMessage()), e);
            res.append("ERROR:").append(e.getMessage());
        } finally {
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
        return res.toString();
    }

    public static String cuatro() {
        StringBuilder res = new StringBuilder();
        HttpClient httpClient = null;
        String horaEjecucion = LocalDateTime.now().format(formatter);
        try {
            /////////////////////////////////////////////////////////////////////////////
            // // Load the service account key JSON file
            // FileInputStream serviceAccount = new FileInputStream(
            // "C:/glassfish4/privatekey/fir-gux-push-firebase-adminsdk-fxc82-0d35306ee7.json");
            // // Authenticate a Google credential with the service account
            // GoogleCredential googleCred = GoogleCredential.fromStream(serviceAccount);
            // // Add the required scopes to the Google credential
            // GoogleCredential scoped =
            // googleCred.createScoped(Arrays.asList("https://www.googleapis.com/auth/firebase.database",
            // "https://www.googleapis.com/auth/userinfo.email"));
            // // Use the Google credential to generate an access token
            // scoped.refreshToken();
            // String token = scoped.getAccessToken();
            // String uriString = StringUtils.join(URL_BD, "users.json?orderBy=%22alias%22&equalTo=%22uno%22&access_token=%22",
            // token, "%22");
            //////////////////////////////////////////////////////////////////////////////
            // HttpHost proxy = new HttpHost("192.9.200.3", 3128);
            httpClient = new DefaultHttpClient();
            String uriString = StringUtils.join(URL_BD, "users.json?orderBy=%22alias%22&equalTo=%22uno%22");
            LOG.severe(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            LOG.severe(">>>> cuatro URI=" + uriString);
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
                LOG.log(Level.FINE, MessageFormat.format("LLamada correcta cuatro: Hora={0}; response={1}", horaEjecucion, res));
            } else {
                LOG.log(Level.WARNING,
                        "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \nWWWWW "
                                + MessageFormat.format("LLamada fallida cuatro: Hora={0}; Codigo HTTP={1}; response={2}",
                                        horaEjecucion, response.getStatusLine().getStatusCode(), responseEntity));
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXX"
                    + MessageFormat.format("Error en la llamada cuatro: Hora={0}; error={2}", horaEjecucion, e.getMessage()), e);
            res.append("ERROR:").append(e.getMessage());
        } finally {
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
        return res.toString();
    }

    public static String consultar(String consulta) {
        if (StringUtils.isBlank(consulta)) {
            return "ERROR: consulta es nulo";
        }
        StringBuilder res = new StringBuilder();
        HttpClient httpClient = null;
        String horaEjecucion = LocalDateTime.now().format(formatter);
        try {
            // HttpHost proxy = new HttpHost("192.9.200.3", 3128);
            httpClient = new DefaultHttpClient();
            String uriString = StringUtils.join(URL_BD, consulta);
            LOG.severe(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            LOG.severe(">>>> consultar URI=" + uriString);
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
                LOG.log(Level.FINE,
                        MessageFormat.format("LLamada correcta consultar: Hora={0}; response={1}", horaEjecucion, res));
            } else {
                LOG.log(Level.WARNING,
                        "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \nWWWWW "
                                + MessageFormat.format("LLamada fallida consultar: Hora={0}; Codigo HTTP={1}; response={2}",
                                        horaEjecucion, response.getStatusLine().getStatusCode(), responseEntity));
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXX"
                    + MessageFormat.format("Error en la llamada consultar: Hora={0}; error={2}", horaEjecucion, e.getMessage()),
                    e);
            res.append("ERROR:").append(e.getMessage());
        } finally {
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
        return res.toString();
    }

    public static String consultar2(String consulta) {
        if (StringUtils.isBlank(consulta)) {
            return "ERROR: consulta es nulo";
        }
        StringBuilder res = new StringBuilder();
        HttpClient httpClient = null;
        String horaEjecucion = LocalDateTime.now().format(formatter);
        try {
            /////////////////////////////////////////////////////////////////////////////
            // // Load the service account key JSON file
            // FileInputStream serviceAccount = new FileInputStream(
            // "C:/glassfish4/privatekey/fir-gux-push-firebase-adminsdk-fxc82-0d35306ee7.json");
            // // Authenticate a Google credential with the service account
            // GoogleCredential googleCred = GoogleCredential.fromStream(serviceAccount);
            // // Add the required scopes to the Google credential
            // GoogleCredential scoped =
            // googleCred.createScoped(Arrays.asList("https://www.googleapis.com/auth/firebase.database",
            // "https://www.googleapis.com/auth/userinfo.email"));
            // // Use the Google credential to generate an access token
            // scoped.refreshToken();
            // String token = scoped.getAccessToken();
            // String uriString = StringUtils.join(URL_BD, consulta, "&access_token=\"", token, "\"");
            //////////////////////////////////////////////////////////////////////////////
            // HttpHost proxy = new HttpHost("192.9.200.3", 3128);
            httpClient = new DefaultHttpClient();
            String uriString = StringUtils.join(URL_BD, consulta);
            LOG.severe(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            LOG.severe(">>>> consultar2 URI=" + uriString);
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
                LOG.log(Level.FINE,
                        MessageFormat.format("LLamada correcta consultar2: Hora={0}; response={1}", horaEjecucion, res));
            } else {
                LOG.log(Level.WARNING,
                        "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \nWWWWW "
                                + MessageFormat.format("LLamada fallida consultar2: Hora={0}; Codigo HTTP={1}; response={2}",
                                        horaEjecucion, response.getStatusLine().getStatusCode(), responseEntity));
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXX"
                    + MessageFormat.format("Error en la llamada consultar2: Hora={0}; error={2}", horaEjecucion, e.getMessage()),
                    e);
            res.append("ERROR:").append(e.getMessage());
        } finally {
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
        return res.toString();
    }
    ///////////////////////////////////////////////////////////////////////////////////////

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
        String horaEjecucion = LocalDateTime.now().format(formatter);
        try {
            String uriString = StringUtils.join(URL_BD, "users.json?orderBy=%22email%22&equalTo=%22", correo, "%22");
            LOG.severe(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            LOG.severe(">>>> consultarPorCorreo URI=" + uriString);
            HttpGet getRequest = new HttpGet(uriString);
            getRequest.addHeader("X-Firebase-Decoding", "1");
            // HttpHost proxy = new HttpHost("192.9.200.3", 3128);
            httpClient = new DefaultHttpClient();
            HttpResponse response = httpClient.execute(getRequest);
            statusCode = response.getStatusLine().getStatusCode();
            if (response.getEntity() != null) {
                responseEntity = EntityUtils.toString(response.getEntity());
            }
            if (statusCode != 200) {
                LOG.log(Level.SEVERE,
                        "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \nWWWWW "
                                + MessageFormat.format("LLamada fallida consultar: Hora={0}; Codigo HTTP={1}; response={2}",
                                        horaEjecucion, statusCode, responseEntity));
                throw new ValidationException("ERROR: Codigo HTTP=" + statusCode + ";  respuesta=" + responseEntity);
            }
            // Http Response 200 OK
            int count = StringUtils.countMatches(responseEntity, correo);
            LOG.log(Level.SEVERE,
                    MessageFormat.format("LLamada correcta consultar: Hora={0}; response={1}", horaEjecucion, responseEntity));
            if (count == 0) {
                throw new ValidationException("ERROR: No existe un usuario registrado con el correo: " + correo);
            } else if (count > 1) {
                throw new ValidationException("ERROR: Existe " + count + " usuarios registrados con el mismo correo: " + correo);
            }
            return responseEntity;
        } catch (Exception e) {
            LOG.log(Level.WARNING, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXX"
                    + MessageFormat.format("Error en la llamada consultar: Hora={0}; error={2}", horaEjecucion, e.getMessage()),
                    e);
            throw new ValidationException(
                    "ERROR: Error en la ejecucion de la consulta a Firebase. error=" + ExceptionUtils.getRootCauseMessage(e));
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
        String horaEjecucion = LocalDateTime.now().format(formatter);
        try {
            String[] partes = StringUtils.split(userJson, ":", 2);
            if (partes == null || partes.length != 2) {
                throw new ValidationException("ERROR: No se puede obtener el identificador del usuario.");
            }
            LOG.severe(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            LOG.severe(">>>> partes[0]=" + partes[0]);
            LOG.severe(">>>> partes[1]=" + partes[1]);
            String idUsuario = StringUtils.substringBetween(partes[0], "\"");
            String uriString = StringUtils.join(URL_BD, "users/", idUsuario, "/password.json");
            LOG.severe(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            LOG.severe(">>>> actualizarClave URI=" + uriString);
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
                LOG.log(Level.SEVERE,
                        "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \nWWWWW "
                                + MessageFormat.format("LLamada fallida actualizarClave: Hora={0}; Codigo HTTP={1}; response={2}",
                                        horaEjecucion, statusCode, responseEntity));
                throw new ValidationException("ERROR: Codigo HTTP=" + statusCode + ";  respuesta=" + responseEntity);
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING,
                    "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nXXXXX" + MessageFormat
                            .format("Error en la llamada actualizarClave: Hora={0}; error={2}", horaEjecucion, e.getMessage()),
                    e);
            throw new ValidationException("ERROR: Error en la ejecucion de la actualizacion en Firebase. error="
                    + ExceptionUtils.getRootCauseMessage(e));
        } finally {
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
    }
}
