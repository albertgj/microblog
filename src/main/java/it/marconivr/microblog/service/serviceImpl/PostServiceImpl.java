package it.marconivr.microblog.service.serviceImpl;

import it.marconivr.microblog.entity.dao.PostDao;
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
    public List<Post> findAll()
    {
        return postDao.findAll();
    }

    @Override
    public Optional<Post> findById(Long id)
    {
        return postDao.findById(id);
    }

    @Override
    public Post savePost(Post p)
    {
        return postDao.saveAndFlush(p);
    }
}
