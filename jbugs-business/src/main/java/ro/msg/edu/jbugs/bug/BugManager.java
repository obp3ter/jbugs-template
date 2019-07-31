package ro.msg.edu.jbugs.bug;


import ro.msg.edu.jbugs.dto.BugDTO;
import ro.msg.edu.jbugs.dto.BugDTOEntityMapper;
import ro.msg.edu.jbugs.model.dao.BugDao;
import ro.msg.edu.jbugs.model.entity.Bug;
import ro.msg.edu.jbugs.model.interceptors.LoggingInterceptor;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless
@Interceptors(LoggingInterceptor.class)
public class BugManager {

    @EJB
    private BugDao bugDao;

    @EJB
    private BugDTOEntityMapper bugMapper;

    public void insertBug(BugDTO bugDTO)
    {
        Bug bug = bugMapper.getEntityFromDTO(bugDTO);
        bugDao.insertBug(bug);
    }
    public BugDTO find(Integer Id)
    {
        return bugMapper.getDTOFromEntity(bugDao.findBug(Id));
    }
    public List<BugDTO> findAll()
    {
        List<Bug> bugList = bugDao.findALL();
        return bugMapper.getDTOsFromEntities(bugList);
    }
    public List<BugDTO> getByCreatedId(Integer Id)
    {

        return bugMapper.getDTOsFromEntities(bugDao.getByCreatedId(Id));
    }
    public List<BugDTO> getByAssignedId(Integer Id)
    {
        return bugMapper.getDTOsFromEntities(bugDao.getByAssignedId(Id));
    }
    public Integer removeold()
    {
        return bugDao.removeOld();
    }

}
