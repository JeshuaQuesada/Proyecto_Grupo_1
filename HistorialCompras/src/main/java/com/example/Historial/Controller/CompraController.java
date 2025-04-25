
package com.example.Historial.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.Historial.Dao;
import com.example.Historial.Service;

@Controller
public class CompraController {
     @GetMapping("/historial")
    public String mostrarHistorial(Model model) {
        model.addAttribute("compras", compraService.obtenerHistorial());
        return "historial";
    }

}
