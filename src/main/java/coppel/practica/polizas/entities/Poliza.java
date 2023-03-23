package coppel.practica.polizas.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "polizas")
public class Poliza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Integer id;
    @Column(name = "Cantidad", nullable = false)
    public Integer Cantidad;
    @Column(name = "Fecha", nullable = false)
    public Date Fecha;
    @Column(name = "empleado_id")
    public Integer empleado_id;
    @Column(name = "inventario_id")
    public Integer inventario_id;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "empleado_id", referencedColumnName = "id")
    //public Empleado Empleado;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "inventario_id", referencedColumnName = "id")
    //public Inventario Inventario;
    public Poliza() {
    }

    public Poliza(Integer id, Integer cantidad, Date fecha, Integer empleado_id, Integer inventario_id) {
        this.id = id;
        Cantidad = cantidad;
        Fecha = fecha;
        this.empleado_id = empleado_id;
        this.inventario_id = inventario_id;
    }
}
