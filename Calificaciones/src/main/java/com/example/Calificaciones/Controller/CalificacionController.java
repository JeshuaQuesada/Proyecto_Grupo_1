

package com.example.Calificaciones.Controller;


import com.example.Calificaciones.Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalificacionController {
    
    private final CalificacionService calificacionService;

    public CalificacionController(CalificacionService calificacionService) {
        this.calificacionService = calificacionService;
    }

    @GetMapping("/calificaciones")
    public String listarCalificaciones(Model model) {
        model.addAttribute("calificaciones", calificacionService.obtenerCalificaciones());
        return "calificaciones";
    }

}
