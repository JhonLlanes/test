package ec.llanes.objrestdatajpa.controller;

import ec.llanes.objrestdatajpa.utils.FileHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloController {

    protected static final String DIRECTION_HTML = "static/index.txt";


    @GetMapping("/hola")
    public String holaMundo(){
        return "123";
    }

    @GetMapping("/bootstrap")
    public String bottstrap(){

        String message;
        try {
             message = FileHelper.readFile(DIRECTION_HTML);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return message;
    }
}
