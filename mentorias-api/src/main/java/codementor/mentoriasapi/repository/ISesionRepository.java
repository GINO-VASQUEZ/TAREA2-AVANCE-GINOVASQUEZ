package codementor.mentoriasapi.repository;


import codementor.mentoriasapi.model.Sesion;

import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ISesionRepository extends IGenericRepository<Sesion, Integer> {

    boolean existsByNombre(String nombre);



    boolean existsByIdSesion(Integer idSesion);

    @Query("FROM Sesion c WHERE c.nombre = ?1 ")
    List<Sesion> getByNombre(String name);
}
