package ro.msg.edu.jbugs.manager;

import javafx.util.Pair;
import ro.msg.edu.jbugs.dto.BugDTO;
import ro.msg.edu.jbugs.dto.UserDTO;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserManager extends BaseManager<UserDTO> {
    Pair<UserDTO,List<BugDTO>> getCreatedBugs(Integer Id);

    List<Pair<UserDTO,List<BugDTO>>> getCreatedBugsForAll();

    void getUAB();
}
