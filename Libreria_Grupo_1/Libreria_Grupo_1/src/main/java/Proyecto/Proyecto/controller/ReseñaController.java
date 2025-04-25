/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.Proyecto.controller;

import Proyecto.Proyecto.domain.Categoria;
import Proyecto.Proyecto.domain.Reseña;
import Proyecto.Proyecto.service.ReseñaService;
import Proyecto.Proyecto.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class ReseñaController {
    
    @Autowired
    private ReseñaService reseñaService;
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/reseña")
    public String agregarReseña(Reseña resena, Model model) {
        resena = reseñaService.getReseña(resena);
        model.addAttribute("Reseña", resena);
        return "/reseña";
    }
}
