package codementor.mentoriasapi.service;


import codementor.mentoriasapi.model.Sesion;


public interface ISesionService extends ICRUD<Sesion, Integer>{
    public boolean isSesionDuplicate(String nombre);


}
