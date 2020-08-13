package io.github.monthalcantara.estudoapicdc.shared.configuration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerTest {

    @GetMapping("/test")
    public String init(){
        return "Está Funcionando";
    }
}
