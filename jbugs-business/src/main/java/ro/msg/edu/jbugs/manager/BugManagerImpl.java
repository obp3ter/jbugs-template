package ro.msg.edu.jbugs.manager;


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
public class BugManagerImpl implements BugManager {

    @EJB
    private BugDao bugDao;

    @EJB
    private BugDTOEntityMapper bugMapper;

    @Override
    public void insert(BugDTO bugDTO)
    {
        Bug bug = bugMapper.getEntityFromDTO(bugDTO);
        bugDao.insert(bug);
    }
    @Override
    public BugDTO find(Integer Id)
    {
        return bugMapper.getDTOFromEntity(bugDao.findById(Id));
    }
    @Override
    public List<BugDTO> findAll()
    {
        List<Bug> bugList = bugDao.findAll();
        return bugMapper.getDTOsFromEntities(bugList);
    }
    @Override
    public List<BugDTO> getByCreatedId(Integer Id)
    {

        return bugMapper.getDTOsFromEntities(bugDao.getByCreatedId(Id));
    }
    @Override
    public List<BugDTO> getByAssignedId(Integer Id)
    {
        return bugMapper.getDTOsFromEntities(bugDao.getByAssignedId(Id));
    }
    @Override
    public Integer removeold()
    {
        return bugDao.removeOld();
    }

}
