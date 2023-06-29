package codementor.mentoriasapi.config;


import codementor.mentoriasapi.dto.HorarioDTO;
import codementor.mentoriasapi.dto.OcupacionDTO;
import codementor.mentoriasapi.dto.SesionDTO;
import codementor.mentoriasapi.model.Horario;
import codementor.mentoriasapi.model.Ocupacion;
import codementor.mentoriasapi.model.Sesion;
import codementor.mentoriasapi.model.Usuario;
import codementor.mentoriasapi.dto.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class MapperConfig {

    @Primary
    @Bean("ocupacionMapper")
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        TypeMap<OcupacionDTO, Ocupacion> typeMap1 = mapper.createTypeMap(OcupacionDTO.class, Ocupacion.class);
        TypeMap<Ocupacion, OcupacionDTO> typeMap2 = mapper.createTypeMap(Ocupacion.class, OcupacionDTO.class);

        typeMap1.addMapping(OcupacionDTO::getName, (dest, v) -> dest.setName((String) v));
        typeMap2.addMapping(Ocupacion::getName, (dest, v) -> dest.setName((String) v));

        typeMap1.addMapping(OcupacionDTO::getDescription, (dest, v) -> dest.setDescription((String) v));
        typeMap2.addMapping(Ocupacion::getDescription, (dest, v) -> dest.setDescription((String) v));



        return mapper;
    }



    @Bean("usuarioMapper")
    public ModelMapper usuarioMapper(){
        ModelMapper mapper = new ModelMapper();

        TypeMap<UsuarioDTO, Usuario> typeMap1 = mapper.createTypeMap(UsuarioDTO.class, Usuario.class);
        TypeMap<Usuario, UsuarioDTO> typeMap2 = mapper.createTypeMap(Usuario.class, UsuarioDTO.class);

        typeMap1.addMapping(UsuarioDTO::getIdOcupacion, (dest, v) -> dest.getOcupacion().setIdOcupacion((Integer) v));
        typeMap2.addMapping(b -> b.getOcupacion().getIdOcupacion(), (dest, v) -> dest.setIdOcupacion((Integer) v));

        return mapper;
    }



    @Bean("sesionMapper")
    public ModelMapper sesionMapper(){

        ModelMapper mapper = new ModelMapper();

        TypeMap<SesionDTO, Sesion> typeMap1 = mapper.createTypeMap(SesionDTO.class, Sesion.class);
        TypeMap<Sesion, SesionDTO> typeMap2 = mapper.createTypeMap(Sesion.class, SesionDTO.class);

        typeMap1.addMapping(SesionDTO::getNombre, (dest, v) -> dest.setNombre((String) v));
        typeMap2.addMapping(Sesion::getNombre, (dest, v) -> dest.setNombre((String) v));

        typeMap1.addMapping(SesionDTO::getHoraDeInicio, (dest, v) -> dest.setHoraDeInicio((String) v));
        typeMap2.addMapping(Sesion::getHoraDeInicio, (dest, v) -> dest.setHoraDeInicio((String) v));

        typeMap1.addMapping(SesionDTO::getHoraDeFinalizacion, (dest, v) -> dest.setHoraDeFinalizacion((String) v));
        typeMap2.addMapping(Sesion::getHoraDeFinalizacion, (dest, v) -> dest.setHoraDeFinalizacion((String) v));

        typeMap1.addMapping(SesionDTO::getLink, (dest, v) -> dest.setLink((String) v));
        typeMap2.addMapping(Sesion::getLink, (dest, v) -> dest.setLink((String) v));

        typeMap1.addMapping(SesionDTO::getAnotaciones, (dest, v) -> dest.setAnotaciones((String) v));
        typeMap2.addMapping(Sesion::getAnotaciones, (dest, v) -> dest.setAnotaciones((String) v));

        typeMap1.addMapping(SesionDTO::getCalificacion, (dest, v) -> dest.setCalificacion((String) v));
        typeMap2.addMapping(Sesion::getCalificacion, (dest, v) -> dest.setCalificacion((String) v));

        typeMap1.addMapping(SesionDTO::getIdHorario, (dest, v) -> dest.getHorario().setIdHorario((Integer) v));
        typeMap2.addMapping(b -> b.getHorario().getIdHorario(), (dest, v) -> dest.setIdHorario((Integer) v));




        return mapper;
    }
        @Bean("horarioMapper")
        public ModelMapper horarioMapper(){

            ModelMapper mapper = new ModelMapper();
            TypeMap<HorarioDTO, Horario> typeMap1 = mapper.createTypeMap(HorarioDTO.class, Horario.class);
            TypeMap<Horario, HorarioDTO> typeMap2 = mapper.createTypeMap(Horario.class, HorarioDTO.class);

            typeMap1.addMapping(HorarioDTO::getFecha, (dest, v) -> dest.setFecha((String) v));
            typeMap2.addMapping(Horario::getFecha, (dest, v) -> dest.setFecha((String) v));

            typeMap1.addMapping(HorarioDTO::getHora, (dest, v) -> dest.setHora((String) v));
            typeMap2.addMapping(Horario::getHora, (dest, v) -> dest.setHora((String) v));


        return mapper;
    }




}
