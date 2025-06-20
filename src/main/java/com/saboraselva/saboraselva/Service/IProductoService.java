package com.saboraselva.saboraselva.Service;

import com.saboraselva.saboraselva.commons.IBaseInterfaceService;
import com.saboraselva.saboraselva.model.Producto;

public interface IProductoService extends IBaseInterfaceService <Producto, Long> {
    
    // Additional methods specific to Producto can be defined here if needed

    // Example: List<Producto> findByCategory(String category);
    // Example: List<Producto> findByPriceRange(Double minPrice, Double maxPrice);
    
}
