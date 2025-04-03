

package com.example.Historial.Service.Impl;
import java.util.List;
import com.example.Historial.Dao;
import com.example.Historial.Service;
import com.example.Historial.Domain;

public class CompraServiceImpl implements CompraService{
    
     @Override
    public List<Compra> obtenerHistorial() {
        return compraDao.obtenerHistorialCompras();
    }

}
