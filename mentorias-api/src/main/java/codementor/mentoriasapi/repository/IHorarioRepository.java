package codementor.mentoriasapi.repository;

import codementor.mentoriasapi.model.Horario;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHorarioRepository extends IGenericRepository<Horario, Integer> {

    boolean existsByFecha(String fecha);
    boolean existsByIdHorario(Integer idHorario);
    @Query("FROM Sesion c WHERE c.nombre = ?1 ")
    List<Horario> getByFecha(String fecha);
}
