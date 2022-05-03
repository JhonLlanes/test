package ec.test.objspringsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class HelloController {

    protected static final String DIRECTION_HTML = "static/index.txt";


    @GetMapping("/hola")
    public String holaMundo(){
        log.info("HOLA MUNDO : >>>>>>> ");

        return "123";
    }


    @GetMapping("/denegado")
    public String denegado(){
        return "DENEGADO";
    }


}
