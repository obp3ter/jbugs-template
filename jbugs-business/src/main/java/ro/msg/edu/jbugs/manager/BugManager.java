package ro.msg.edu.jbugs.manager;

import ro.msg.edu.jbugs.dto.dto.BugDTO;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface BugManager extends BaseManager<BugDTO>{
    List<BugDTO> getByCreatedId(Integer Id);

    List<BugDTO> getByAssignedId(Integer Id);

    Integer removeold();
}
