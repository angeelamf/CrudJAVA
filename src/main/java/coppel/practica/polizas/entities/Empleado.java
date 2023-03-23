package coppel.practica.polizas.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer id;
    @Column(name = "Nombre", nullable = false)
    public String Nombre;
    @Column(name = "Apellido", nullable = false)
    public String Apellido;
    @Column(name = "Puesto", nullable = false)
    public String Puesto;

    /*
        @OneToOne(mappedBy = "Empleado")
        @JsonIgnore
        private Poliza poliza;
    */
    public Empleado() {
    }

    public Empleado(Integer id, String nombre, String apellido, String puesto, Poliza poliza) {
        this.id = id;
        Nombre = nombre;
        Apellido = apellido;
        Puesto = puesto;
    }
}