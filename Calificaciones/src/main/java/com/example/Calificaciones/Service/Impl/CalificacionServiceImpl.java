

package com.example.Calificaciones.Service.Impl;

import com.example.Calificaciones.Dao;
import com.example.Calificaciones.Domain;
import com.example.Calificaciones.Service;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CalificacionServiceImpl implements CalificacionService {
    
     private final CalificacionDao calificacionDao;
     
     public CalificacionServiceImpl(CalificacionDao calificacionDao) {
        this.calificacionDao = calificacionDao;
    }

    @Override
    public List<Calificacion> obtenerCalificaciones() {
        return calificacionDao.findAll();
    }


}
