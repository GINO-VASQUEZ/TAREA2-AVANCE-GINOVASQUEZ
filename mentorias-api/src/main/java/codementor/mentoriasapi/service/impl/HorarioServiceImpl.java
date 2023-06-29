package codementor.mentoriasapi.service.impl;

import codementor.mentoriasapi.model.Horario;
import codementor.mentoriasapi.repository.IGenericRepository;
import codementor.mentoriasapi.exception.DataAlreadyExistsException;
import codementor.mentoriasapi.exception.ModelNotFoundException;
import codementor.mentoriasapi.repository.IHorarioRepository;

import codementor.mentoriasapi.service.IHorarioService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;

@Service
@RequiredArgsConstructor

public class HorarioServiceImpl extends CRUDImpl<Horario, Integer> implements IHorarioService {

    private final IHorarioRepository repo;


    @Override
    protected IGenericRepository<Horario, Integer> getRepo() {
        return repo;
    }

    @Override
    public Horario save(Horario horario) throws Exception {

        String fecha =horario.getFecha();

        if (isHorarioDuplicate(fecha)) {
            throw new DataAlreadyExistsException("El horario ya existe con el nombre y/o descripcion que has ingresado.");
        }

        return super.save(horario);
    }

    @Override
    public Horario update(Horario horario, Integer id) throws Exception {

        String fecha =horario.getFecha();


        getRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("La sesion con id " + id + " no existe."));

        if (isHorarioDuplicateUpdate(fecha)) {
            throw new DataAlreadyExistsException("El horario ya existe con el nombre y/o descripción que has ingresado.");
        }

        return super.update(horario,id);
    }


    public boolean isHorarioDuplicate(String fecha) {return repo.existsByFecha(fecha);
    }

    public boolean isHorarioDuplicateUpdate(String fecha ) {
        return repo.existsByFecha(fecha);
    }


}
