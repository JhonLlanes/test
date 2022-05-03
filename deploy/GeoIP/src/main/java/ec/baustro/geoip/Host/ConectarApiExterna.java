package ec.baustro.geoip.Host;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ConectarApiExterna {



    Gson gson;

    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);
    final static Properties props = System.getProperties();

    private static HttpRequest llamarMetodo(String url, String body, String tipoConsulta) {
        if (tipoConsulta.equals("POST")){
            return postMethod(url, body,"application/json");
        }else{
            return getMethod(url, body,"application/json");
        }
    }


    private static HttpRequest llamarMetodo(String url, String body, String tipoConsulta, String tipoContent) {
        if (tipoConsulta.equals("POST")){
            return postMethod(url, body,tipoContent);
        }else{
            return getMethod(url, body,tipoContent);
        }
    }

    private static HttpRequest getMethod(String url, String body, String tipoContent) {
        return HttpRequest.newBuilder().GET()
                .uri(URI.create(url))
                .header("Accept", tipoContent)
                .header("Content-type", tipoContent)
                .build();
    }

    private static HttpRequest postMethod(String url, String body, String tipoContent) {
        return HttpRequest.newBuilder().POST(BodyPublishers.ofString(body))
                .uri(URI.create(url))
                .header("Accept", tipoContent)
                .header("Content-type", tipoContent)
                .build();
    }

    public ConectarApiExterna() {
        this.gson = new Gson();
    }



    /**
     * 
     * @param cuerpoPeticion es el cuerpo Json que se debe enviar con la peticion
     * @param url            es la direccion de donde se enviara la peticion
     * @param tipoConsulta   el tipo de consulta que se debe realizar
     * @return retorna un string de la solicitud si es correcto o un null si falla.
     */
    public String solicitarDatosApiExternaTextPlain( String cuerpoPeticion, String url, String tipoConsulta) {
        props.setProperty("jdk.internal.httpclient.disableHostnameVerification", Boolean.TRUE.toString());

        try {
            log.info("SOLICITANDO PETICION API EXTERNA A "+url);
            log.info("CUERPO PETICION "+cuerpoPeticion);

            HttpResponse<String> httpRespuesta = cliente().send(llamarMetodo(url, cuerpoPeticion, tipoConsulta,"text/plain"),
                    BodyHandlers.ofString());
            String respuesta =  httpRespuesta.body().toString();
            log.info("RESPUESTA PETICION "+respuesta);
            log.info("FIN PETICION API EXTERNA DE " + url);
            return respuesta;
        } catch (Exception e) {
            log.error("ERROR EL CONECTAR API EXTERNA " + url , e);
            return null;
        }
    }



    private static HttpClient cliente() {
        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };

        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());

            return HttpClient.newBuilder()
                    .executor(executorService)
                    .version(HttpClient.Version.HTTP_2)
                    .sslContext(sc)
                    // .connectTimeout(3000) //3 segundos
                    .build();
        } catch (Exception e) {
            log.error("Error al crear Cliente HTTP" , e);
            return null;
        }
    }

}
