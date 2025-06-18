package com.saboraselva.saboraselva.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    
    @Column(name = "id_pedido")
    private Long idPedido; 
    @Column(name = "fecha_pedido")
    private String fechaPedido;
    
    private String estado; // Ejemplo: "Pendiente", "Enviado", "Entregado"
    private Double total; // Total del pedido

    @OneToMany(mappedBy = "pedido")
    private List<Producto> productos; // Relación con Producto, asumiendo que un pedido puede tener varios productos
}   
