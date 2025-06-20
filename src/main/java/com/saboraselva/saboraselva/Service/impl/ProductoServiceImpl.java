package com.saboraselva.saboraselva.Service.impl;

import org.springframework.stereotype.Service;

import com.saboraselva.saboraselva.Service.IProductoService;
import com.saboraselva.saboraselva.model.Producto;

@Service
public class ProductoServiceImpl extends CRUDimpl <Producto, Long> implements IProductoService {

    // Implement any additional methods specific to ProductoService here
    // For example, you can override methods from IBaseInterfaceService if needed

    // Example: 
    // @Override
    // public List<Producto> findByCategory(String category) {
    //     // Implementation logic here
    // }    
    
}   
