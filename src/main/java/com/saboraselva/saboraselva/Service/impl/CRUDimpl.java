package com.saboraselva.saboraselva.Service.impl;

import java.util.List;

import org.springframework.data.domain.Page;

import com.saboraselva.saboraselva.Repo.IGenericRepository;
import com.saboraselva.saboraselva.commons.Filter;
import com.saboraselva.saboraselva.commons.IBaseInterfaceService;
import com.saboraselva.saboraselva.commons.SortModel;
import com.saboraselva.saboraselva.exception.ModelNotFoundException;
import com.saboraselva.saboraselva.exception.RepositoryException;



public abstract class CRUDimpl <T,ID> implements IBaseInterfaceService <T,ID> {

    protected abstract IGenericRepository<T,ID> getRepo();

     @Override
    public Long count() {
        return getRepo().count();
    }

    @Override
    public T create(T entidad) {

        return getRepo().save(entidad);
    }

    @Override
    public void delete(T entidad) {
        getRepo().delete(entidad);
        
    }

    @Override
    public void deleteById(ID id) {
        getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID NOT FOUND " + id ));
        try {
            getRepo().deleteById(id) ;
            
        } catch (Exception e) {
            throw new RepositoryException("ERROR DE ELIMINACION, EL ID TIPO VIA ESTA SIENDO UTILIZAD EN OTROS REGISTROS");
        }
        
    }

    @Override
    public Boolean exists(ID id) {
        return getRepo().existsById(id);
    }

    @Override
    public List<T> getAll() {
        return getRepo().findAll();
    }

    @Override
    public Page<?> pagination(Integer pagenumber, Integer rows, List<SortModel> sortModel, Filter filter) {
        return null;
    }

    @Override
    public T readById(ID id) {
        T rtn = getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("No se encontro el ID " + id));
        return  rtn;
    }

    @Override
    public T update(T entidad, ID id) {
        return getRepo().save(entidad);
    }
 
}
    

