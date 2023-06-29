package codementor.mentoriasapi.controller;

import codementor.mentoriasapi.dto.SesionDTO;
import codementor.mentoriasapi.model.Sesion;
import codementor.mentoriasapi.service.ISesionService;
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
@RequestMapping("/sesiones")
@RequiredArgsConstructor
public class SesionController {

    private final ISesionService service;

    @Qualifier("sesionMapper")
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<SesionDTO> create(@Valid @RequestBody SesionDTO dto) throws Exception {
        Sesion obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SesionDTO> update(@Valid @PathVariable("id") Integer idSesion, @RequestBody SesionDTO dto) throws Exception {
        dto.setIdSesion(idSesion);
        Sesion obj = service.update(convertToEntity(dto), idSesion);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SesionDTO>>  readAll() throws Exception{
        List<SesionDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SesionDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Sesion obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private SesionDTO convertToDto(Sesion obj){
        return mapper.map(obj, SesionDTO.class);
    }

    private Sesion convertToEntity(SesionDTO dto){
        return mapper.map(dto, Sesion.class);
    }
}
