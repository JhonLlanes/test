package ec.llanes.objrestdatajpa.controller;


import ec.llanes.objrestdatajpa.modelo.Laptop;
import ec.llanes.objrestdatajpa.repository.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {

    private LaptopRepository repository;

    public LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/findlaptop")
    public List<Laptop> findall(){
        return repository.findAll();
    }


    @PostMapping("/laptopSave")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders handler){
        try {
            System.out.println("HEADER: "+handler.get("User-Agent"));
            System.out.println("IP: "+handler.getOrigin());
            return repository.save(laptop);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
}
