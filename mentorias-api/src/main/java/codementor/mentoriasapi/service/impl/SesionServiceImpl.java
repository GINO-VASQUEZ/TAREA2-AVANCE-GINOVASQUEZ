package codementor.mentoriasapi.service.impl;


import codementor.mentoriasapi.model.Sesion;
import codementor.mentoriasapi.repository.IGenericRepository;
import codementor.mentoriasapi.exception.DataAlreadyExistsException;
import codementor.mentoriasapi.exception.ModelNotFoundException;
import codementor.mentoriasapi.repository.ISesionRepository;
import codementor.mentoriasapi.service.ISesionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class SesionServiceImpl extends CRUDImpl<Sesion, Integer> implements ISesionService {

    private final ISesionRepository repo;


    @Override
    protected IGenericRepository<Sesion, Integer> getRepo() {
        return repo;
    }

    @Override
    public Sesion save(Sesion sesion) throws Exception {

        String nombre=sesion.getNombre();

        if (isSesionDuplicate(nombre)) {
            throw new DataAlreadyExistsException("La sesion ya existe con el nombre y/o descripcion que has ingresado.");
        }

        return super.save(sesion);
    }

    @Override
    public Sesion update(Sesion sesion, Integer id) throws Exception {

        String nombre=sesion.getNombre();


        getRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("La sesion con id " + id + " no existe."));

        if (isSesionDuplicateUpdate(nombre)) {
            throw new DataAlreadyExistsException("La sesion ya existe con el nombre y/o descripción que has ingresado.");
        }

        return super.update(sesion,id);
    }


    public boolean isSesionDuplicate(String nombre) {
        return repo.existsByNombre(nombre);
    }

    public boolean isSesionDuplicateUpdate(String nombre) {
        return repo.existsByNombre(nombre);
    }


}
