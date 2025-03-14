
package Resennas.ServiceR;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


public class PersonaService implements PersonaImpl {
    
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
    
    public List<Persona>listar();
    public Optional<Persona>listarId(int id);
    public int save(Persona p);
    public void delete(int id);

}
