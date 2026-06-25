package edu.utvt.alumnos.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Representa un alumno registrado en el sistema.
 * <p>
 * Esta entidad se mapea a la tabla <code>alumnos</code> y almacena
 * información personal, académica y de contacto del alumno.
 */
@Data
@Entity
@Table(name = "alumnos", indexes = {
        @Index(name = "idx_matricula", columnList = "matricula"),
        @Index(name = "idx_correo_electronico", columnList = "correo_electronico"),
        @Index(name = "idx_activo", columnList = "activo")
})
public class Alumno {

    /** Identificador único generado automáticamente. */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String matricula;

    /** Nombre del alumno. */
    @Column(length = 100, nullable = false)
    private String nombre;

    /** Primer apellido del alumno. */
    @Column(name = "apellido_paterno", length = 100, nullable = false)
    private String apellidoPaterno;

    /** Segundo apellido del alumno. Puede dejarse vacío. */
    @Column(name = "apellido_materno", length = 100)
    private String apellidoMaterno;

    /** Correo electrónico único del alumno. */
    @Column(name = "correo_electronico", length = 255, nullable = false, unique = true)
    private String correoElectronico;

    /** Teléfono de contacto del alumno. */
    @Column(length = 10)
    private String telefono;

    /** Fecha de nacimiento del alumno. */
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    /** Carrera o programa académico del alumno. */
    @Column(length = 100, nullable = false)
    private String carrera;

    /** Semestre actual en el que se encuentra el alumno. */
    @Column(nullable = false)
    private Integer semestre;

    /** Indica si el alumno está activo en el sistema. */
    @Column(nullable = false)
    private boolean activo = true;

    /** Fecha y hora en que se registró el alumno en el sistema. */
    @CreationTimestamp
    @Column(name = "fecha_registro", nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;
}
