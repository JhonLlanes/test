package com.test.springdeply;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Value("${app.menssaje}")
    private String mensaje;

    @GetMapping("/hola")
    public String holaMundo(){
        System.out.println(mensaje);

        return "test deploy ";
    }

}
