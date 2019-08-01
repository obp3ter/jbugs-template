package ro.msg.edu.jbugs.model.dao;

import ro.msg.edu.jbugs.model.entity.Comment;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CommentDao extends BaseDao<Comment>{
    Integer removeOld();
}
