package ec.baustro.geoip;

import ec.baustro.geoip.Host.ConectarApiExterna;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class GeoIpController {

     @Autowired
     private GeoIp geoIp;

     @Autowired
     private ConectarApiExterna apiExterna;
     private String url = "http://10.1.115.73:8080/GeoIP/austroWS/ipINFO/consultaIP";

    @PostMapping("/geoIP")
    public String getGeoIP(@RequestBody ModeloIp ip){
         log.info("IP: " +ip.getIp());
         String pais = geoIp.getPais(ip.getIp(), url );
        return pais;
    }

    @PostMapping("/geoIP2")
    public String getip2(@RequestBody ModeloIp ip){
        log.info("IP: " +ip.getIp());
        String pais = apiExterna.solicitarDatosApiExternaTextPlain("","","");
        return pais;
    }

}
