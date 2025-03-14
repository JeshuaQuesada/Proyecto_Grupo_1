
package Resennas.ServiceImplR;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
public class PersonaImpl {
    
    @Autowired
    private Ipersona data;
    
       @Override
    public List<Persona> listar() {
        return (List<Persona>)data.findAll();
    }

    @Override
    public Optional<Persona> listarId(int id) {
        return personaRepositorio.findById(id);
    }

    @Override
    public int save(Persona p) {
        Persona personaGuardada = personaRepositorio.save(p);
        return personaGuardada.getId(); // Suponiendo que Persona tiene un campo 'id'
    }

    @Override
    public void delete(int id) {
        personaRepositorio.deleteById(id);
    }
}
