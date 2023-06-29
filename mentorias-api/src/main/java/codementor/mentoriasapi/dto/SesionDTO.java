package codementor.mentoriasapi.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SesionDTO {

    private Integer idSesion;

    @NotNull
    private Integer idHorario;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nombre;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String horaDeInicio;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String horaDeFinalizacion;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 150)
    private String link;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 20)
    private String calificacion;


    @NotNull
    @NotEmpty
    @Size(min = 3, max = 150)
    private String anotaciones;
}

