package com.saboraselva.saboraselva.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(nullable = false, length = 70)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String descripcion;
    
    @Column(nullable = false)
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "producto")
    private List<Imagen> imagenes;

    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detalles; // Relación con DetallePedido, asumiendo que un producto puede estar en varios detalles de pedido

   /* Registro de Fechas enla base de Datos */

   @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;  

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;   

   @PrePersist
    public void prePersisten(){
        this.createdAt = new Date();
        
    }   
    

    /* id_categoria */
    /* id_usuario */
}
