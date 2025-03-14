
package Calificaciones.ServiceImplC;

public class IPersonaServiceImplC {
    
    public List<Persona>listar();
    public Optional<Persona>listarId(int id);
    public int save(Persona p);
    public void delete(int id);

}
