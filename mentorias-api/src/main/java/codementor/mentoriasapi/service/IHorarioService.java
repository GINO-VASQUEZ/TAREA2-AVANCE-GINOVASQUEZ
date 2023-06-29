package codementor.mentoriasapi.service;

import codementor.mentoriasapi.model.Horario;

import java.util.Date;

public interface IHorarioService extends ICRUD<Horario, Integer>{
    public boolean isHorarioDuplicate(String fecha);


}
