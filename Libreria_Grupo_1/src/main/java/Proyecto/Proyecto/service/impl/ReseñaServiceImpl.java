///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Proyecto.Proyecto.service.impl;
//
//import Proyecto.Proyecto.dao.ReseñaDao;
//import Proyecto.Proyecto.domain.Reseña;
//import Proyecto.Proyecto.service.ReseñaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class ReseñaServiceImpl implements ReseñaService {
//
//    @Autowired
//    private ReseñaDao reseñaDao;
//
//    @Override
//    @Transactional(readOnly = true)
//    public Reseña getReseña(Reseña resena) {
//        return resena;
//    }
//
//    @Override
//    @Transactional
//    public void save(Reseña resena) {
//        reseñaDao.save(resena);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Reseña resena) {
//        reseñaDao.delete(resena);
//    }
//
//}
