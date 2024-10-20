package org.sda.services;

import org.sda.daos.GenericDao;

import java.io.Serializable;

public class GenericService <T, ID extends Serializable> {
    private final GenericDao<T, ID> genericDao;

    public GenericService(GenericDao<T, ID> genericDao) {
        this.genericDao = genericDao;
    }

    public void save(T entiny){
        genericDao.save(entiny);
    }

    public T getById(ID id){
        return genericDao.getById(id);
    }

    public void update(T entity){
        genericDao.update(entity);
    }

    public void delete(T entity){
        genericDao.delete(entity);
    }
}
