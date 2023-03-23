package coppel.practica.polizas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "inventarios")
public class Inventario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "Sku", unique = true, nullable = false)
    public Integer Sku;
    @Column(name = "Nombre", nullable = false)
    public String Nombre;
    @Column(name = "Cantidad", nullable = false)
    public Integer Cantidad;
    @Column(name = "Campo", nullable = false)
    public Integer Campo;

    /*
        @OneToOne(mappedBy = "Inventario")
        @JsonIgnore
        private Poliza poliza;
    */

    public Inventario() {
    }

    public Inventario(Integer id, String nombre, Integer cantidad) {
        this.Sku = id;
        this.Nombre = nombre;
        this.Cantidad = cantidad;
    }
}
