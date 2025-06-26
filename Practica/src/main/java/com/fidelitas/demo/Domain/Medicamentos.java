package com.fidelitas.demo.Domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name="medicamentos")
public class Medicamentos implements Serializable {
    
    private static final long serialVersionUID = 1L;
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long ID;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;
    private int idCategoria;
    
    public Medicamentos() {
        
    }
    
    public Medicamentos(String nombre, String descripcion, double precio, 
            int cantidad, int idCategoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idCategoria = idCategoria;
    }

}
