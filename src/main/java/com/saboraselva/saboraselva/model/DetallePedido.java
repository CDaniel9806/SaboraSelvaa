package com.saboraselva.saboraselva.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Detallepedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class DetallePedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    
    @Column (name = "id_detalle_pedido")
    private Long idDetallePedido;

    private long cantidad; // Cantidad de productos en el detalle
    private String subtotal;  // Subtotal del detalle de pedido

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)/* Un pedido puede tener muchos productos (a través de los detalles): */
    private Pedido pedido; // Relación con Pedido

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false) /* Un producto puede estar en muchos detalles de pedido: */
    private Producto producto; // Relación con Producto

    /* pruebaa */
    
}   
