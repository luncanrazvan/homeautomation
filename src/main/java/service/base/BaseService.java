package service.base;

import repository.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable> {

    T getById(ID id);
    List<T> getAll();
    void deleteById(ID id);
    T create(T entity);
    void deleteAll();

}
