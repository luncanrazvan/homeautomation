package service.base;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import repository.entity.BaseEntity;
import repository.repositories.BaseRepository;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable> implements BaseService<T, ID> {

    private BaseRepository<T, ID> baseRepository;
    private final Class<T> persistentClass;

    public BaseServiceImpl(){
        List<ResolvedType> typeParameters = new TypeResolver().resolve(this.getClass()).typeParametersFor(BaseServiceImpl.class);
        this.persistentClass = (Class<T>) typeParameters.get(0).getErasedType();
    }

    @Autowired
    public void setBaseRepository(BaseRepository<T, ID> baseRepository){
        this.baseRepository = baseRepository;
    }

    @Override
    public T getById(final ID id){
        return baseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(persistentClass.getSimpleName() + " was not found with the id:" + id));
    }

    @Override
    public List<T> getAll(){
        return baseRepository.findAll();
    }

    @Override
    public void deleteById(final ID id){
        baseRepository.deleteById(id);
    }

    @Override
    public void deleteAll(){
        baseRepository.deleteAll();
    }

    @Override
    public T create(T entity){
        return baseRepository.save(entity);
    }
}
