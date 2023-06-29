package codementor.mentoriasapi.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class HorarioDTO {

    private Integer idHorario;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String fecha;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String hora;

}

