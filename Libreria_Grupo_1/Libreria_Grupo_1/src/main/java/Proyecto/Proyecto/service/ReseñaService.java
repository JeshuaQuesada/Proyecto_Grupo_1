/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proyecto.Proyecto.service;

import Proyecto.Proyecto.domain.Reseña;
import java.util.List;

/**
 *
 * @author jeshu
 */
public interface ReseñaService {

    
    public Reseña getReseña(Reseña resena);

    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Reseña resena);

    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Reseña resena);
}
