package ec.baustro.geoip;

import java.nio.charset.StandardCharsets;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@Service
public class GeoIp {


    public String getPais(String _ip,String url) {

        String jResp = "";//

        RestTemplate restTemplate = new RestTemplate();

        try {
            log.info("SOLICITANDO PETICION API EXTERNA A "+url);
            log.info("CUERPO PETICION "+_ip);


            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(new MediaType("text", "plain", StandardCharsets.UTF_8));

            jResp = restTemplate.postForObject(url, _ip, String.class);

            log.info("RESPUESTA PETICION "+jResp);
            log.info("FIN PETICION API EXTERNA DE " + url);
        }catch (Exception e) {
            log.error("ERROR AL CONSULTAR LA IP "+e.toString());
        }

        return jResp;

    }
}
