
import jakarta.persistence.*; 
import java.io.Serializable; 

package Calificaciones.DomainC;

@Entity
@Table(name = "personas")
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String comentario;

    // Constructor vacío
    public Persona() {
    }

    // Constructor con parámetros
    public Persona(String name, String comentario) {
        this.name = name;
        this.comentario = comentario;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
