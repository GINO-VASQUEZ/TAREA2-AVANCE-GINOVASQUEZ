package codementor.mentoriasapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Time;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity

public class Sesion {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSesion;


    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String horaDeInicio;


    @Column(length = 150, nullable = false)
    private String horaDeFinalizacion;

    @Column(length = 50, nullable = false)
    private String link;

    @Column(length = 150, nullable = false)
    private String anotaciones;

    @Column(length = 150, nullable = false)
    private String calificacion;


    @ManyToOne
    @JoinColumn(name = "id_Horario", nullable = false, foreignKey = @ForeignKey(name = "FK_Sesion_Horario"))
    private Horario Horario;
}
