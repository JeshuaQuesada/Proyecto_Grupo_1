package Resennas.ControllerR;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import Resennas.ServiceImplR.PersonaImpl;
import Resennas.Model.Persona;

@Controller
@RequestMapping("/personas")
public class Controlador {

    @Autowired
    private PersonaImpl service;
    
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Persona> personas = service.listar();
        model.addAttribute("personas", personas);
        return "index";
    }
}
