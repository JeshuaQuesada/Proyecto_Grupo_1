/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria.Libreria.domain;

    
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data 
@Entity 
@Table(name = "reservas") 
public class Reservas implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public static final String TIPO_FICCION = "Ficcion";
    public static final String TIPO_DRAMA = "Drama";
    public static final String TIPO_FANTASIA = "Fantasia";
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id") 
    private Long id;
    
    //Atributos
    private String nombre;
    private String apellido;
    private int cedula;
    private int telefono;
    private String correo;
    private String tipoGenero; 
    private boolean activo;
    
    public Reservas() {
    }
    
    public Reservas(String nombre, String tipoGenero, boolean activo) {
        this.nombre = nombre;
        this.tipoGenero = tipoGenero;
        this.activo = activo;
    }
}