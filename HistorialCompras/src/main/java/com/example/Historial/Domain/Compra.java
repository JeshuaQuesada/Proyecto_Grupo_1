

package com.example.Historial.Domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
@Data
@Entity
@Table(name="compra")

public class Compra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
     private Long id;
    private String libro;
    private String fecha;
    private double precio;
    
    
    

}
