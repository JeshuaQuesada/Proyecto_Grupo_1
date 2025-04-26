/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria.Libreria.service.impl;

import Libreria.Libreria.dao.ReservasDao;
import Libreria.Libreria.domain.Reservas;
import Libreria.Libreria.service.ReservasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservasServiceImpl implements ReservasService{

     @Autowired
    private ReservasDao reservasDao;

    @Override
    @Transactional(readOnly=true)
    public List<Reservas> getReservas(boolean activo) {
        var lista=reservasDao.findAll();
        if (activo) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Reservas getReservas(Reservas reservas) {
        return reservasDao.findById(reservas.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reservas reservas) {
        reservasDao.save(reservas);
    }

    @Override
    @Transactional
    public void delete(Reservas reservas) {
        reservasDao.delete(reservas);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Reservas> findByIdBetweenOrderByNombre(Long idInicio, Long idFin) {
        return reservasDao.findByIdBetweenOrderByNombre(idInicio, idFin);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Reservas> findByIdIs(Long idIs) {
        return reservasDao.findByIdIs(idIs);
    }
    
}