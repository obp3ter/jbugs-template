package ro.msg.edu.jbugs.dto.mapper;

import ro.msg.edu.jbugs.dto.dto.BaseDTOComplete;
import ro.msg.edu.jbugs.dto.dto.BugDTO;
import ro.msg.edu.jbugs.model.entity.Bug;

import javax.ejb.Singleton;

@Singleton
public class BugDTOEntityMapper extends BaseDTOEntityMapper<Bug, BugDTO, BaseDTOComplete> {

    @Override
    public Bug getEntityFromDTO(BugDTO dto) {
        Bug bug = new Bug();
        bug.setID(dto.getID());
        bug.setTitle(dto.getTitle());
        bug.setDescription(dto.getDescription());
        bug.setVersion(dto.getVersion());
        bug.setTargetDate(dto.getTargetDate());
        bug.setStatus(dto.getStatus());
        bug.setFixedVersion(dto.getFixedVersion());
        bug.setSeverity(dto.getSeverity());
        
        return bug;
    }

    @Override
    public BugDTO getDTOFromEntity(Bug entity) {
        BugDTO bugDTO = new BugDTO();
        bugDTO.setID(entity.getID());
        bugDTO.setTitle(entity.getTitle());
        bugDTO.setDescription(entity.getDescription());
        bugDTO.setVersion(entity.getVersion());
        bugDTO.setTargetDate(entity.getTargetDate());
        bugDTO.setStatus(entity.getStatus());
        bugDTO.setFixedVersion(entity.getFixedVersion());
        bugDTO.setSeverity(entity.getSeverity());
        return bugDTO;
    }
}
