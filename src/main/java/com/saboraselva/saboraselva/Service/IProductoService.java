package com.saboraselva.saboraselva.Service;

import com.saboraselva.saboraselva.Dto.ProductoDto;
import com.saboraselva.saboraselva.commons.IBaseInterfaceService;
import com.saboraselva.saboraselva.model.Producto;

public interface IProductoService extends IBaseInterfaceService <Producto, Long> {
    
    Producto update(Producto entidad, Long id); // este es la firma del metodo update que se implementa en la clase ProductoServiceImpl
  
    Producto createCustom (ProductoDto entidad); // este es la firma del metodo createCustom que se implementa en la clase ProductoServiceImpl
    
}
