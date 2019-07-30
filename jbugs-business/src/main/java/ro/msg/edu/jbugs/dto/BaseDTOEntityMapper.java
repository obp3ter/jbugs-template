package ro.msg.edu.jbugs.dto;

import ro.msg.edu.jbugs.model.entity.BaseEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseDTOEntityMapper<T extends BaseEntity, X extends BaseDTO> {
    public abstract T getEntityFromDTO(X dto);
    public abstract X getDTOFromEntity(T entity);


    public List<T> getEntitiesFromDTO(Collection<X> dtos){
       return dtos.stream().map(this::getEntityFromDTO).collect(Collectors.toList());
    }

    public  List<X> getDTOsFromEntities(Collection<T> entities){
        return entities.stream().map(this::getDTOFromEntity).collect(Collectors.toList());
    }

}
