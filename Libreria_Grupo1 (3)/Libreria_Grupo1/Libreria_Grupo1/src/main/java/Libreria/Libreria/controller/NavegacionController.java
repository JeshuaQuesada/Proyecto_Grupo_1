
package Libreria.Libreria.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;






@Controller
public class NavegacionController {
    
    @GetMapping("/index")
    public String mostrarIndex() {
        return "index"; // Página de inicio
    }
    
    @GetMapping("/Categoria_Libros")
    public String mostrarCategoriaLibros() {
        return "Categoria_Libros";
    }
    
    @GetMapping("/Nosotros")
    public String mostrarNosotros() {
        return "Nosotros";
    }
    
    @GetMapping("/Reserva")
    public String mostrarReservas() {
        return "Reserva";
    }
    
    }
    @GetMapping("/inicio_Sesion")
    public String mostrarInicioSesion() {
        return "inicio_Sesion";
    }
    
    @GetMapping("/Usuarios")
    public String usuarios() {
        return "Usuarios";
    }
  
}