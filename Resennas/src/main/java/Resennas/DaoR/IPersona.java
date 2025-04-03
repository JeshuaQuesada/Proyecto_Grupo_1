

package Resennas.DaoR;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import Calificaciones.DomainC.Persona;

public class IPersona extends JpaRepository<Persona, Long>{
}
