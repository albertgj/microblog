package it.marconivr.microblog.service.serviceImpl;

import it.marconivr.microblog.dao.PostDao;
import it.marconivr.microblog.entity.Comment;
import it.marconivr.microblog.entity.Post;
import it.marconivr.microblog.service.PostService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author albert
 */
@Service
public class PostServiceImpl implements PostService
{

    @Autowired
    private PostDao postDao;

    @Override
    public Post save(Post p)
    {
        return postDao.saveAndFlush(p);
    }

    @Override
    public void deleteById(Long id)
    {
        postDao.deleteById(id);
    }

    @Override
    public List<Post> findAll()
    {
        return postDao.findAll();
    }

    @Override
    public List<Comment> getCommentsOfPost(Long id)
    {
        return postDao.findCommentsOfPost(id);
    }
}