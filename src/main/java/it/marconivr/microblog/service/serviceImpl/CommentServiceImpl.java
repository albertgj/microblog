package it.marconivr.microblog.service.serviceImpl;

import it.marconivr.microblog.dao.CommentDao;
import it.marconivr.microblog.dao.PostDao;
import it.marconivr.microblog.entity.Comment;
import it.marconivr.microblog.entity.Post;
import it.marconivr.microblog.service.CommentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author albert
 */
@Service
public class CommentServiceImpl implements CommentService
{

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private PostDao postDao;

    @Override
    public Long count()
    {
        return commentDao.count();
    }

    @Override
    public List<Comment> findAll()
    {
        return commentDao.findAll();
    }

    @Override
    public Comment save(Comment c)
    {
        return commentDao.saveAndFlush(c);
    }


}