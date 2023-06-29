package codementor.mentoriasapi.controller;

import codementor.mentoriasapi.dto.HorarioDTO;
import codementor.mentoriasapi.dto.OcupacionDTO;
import codementor.mentoriasapi.model.Horario;
import codementor.mentoriasapi.model.Ocupacion;
import codementor.mentoriasapi.service.IHorarioService;
import codementor.mentoriasapi.service.IOcupacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/horarios")
@RequiredArgsConstructor
public class HorarioController {


    private final IHorarioService service;

    @Qualifier("horarioMapper")
    private final ModelMapper mapper;


    @PostMapping
    public ResponseEntity<HorarioDTO> create(@Valid @RequestBody HorarioDTO dto) throws Exception {
        Horario obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<HorarioDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody HorarioDTO dto) throws Exception {
        dto.setIdHorario(id);
        Horario obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HorarioDTO>>  readAll() throws Exception{
        List<HorarioDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Horario obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /////////////////////convert mapper//////////////////

    private HorarioDTO convertToDto(Horario obj){
        return mapper.map(obj, HorarioDTO.class);
    }

    private Horario convertToEntity(HorarioDTO dto){
        return mapper.map(dto, Horario.class);
    }

}
