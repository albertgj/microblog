package it.marconivr.microblog.service.serviceImpl;

import it.marconivr.microblog.dao.UserDao;
import it.marconivr.microblog.entity.User;
import it.marconivr.microblog.entity.Post;
import it.marconivr.microblog.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author albert
 */
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public User save(User p)
    {
        User user = new User();
        user.setUsername(p.getUsername());
        user.setPassword(encoder.encode(p.getPassword()));
        user.setRoles(p.getRoles());
        
        return userDao.saveAndFlush(user);
    }

    @Override
    public void deleteById(Long id)
    {
        userDao.deleteById(id);
    }

    @Override
    public List<Post> getPostsOfUser(Long id)
    {
        return userDao.findPostsOfUser(id);
    }

    @Override
    public Optional<User> findByUsername(String username)
    {
        return userDao.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) { return userDao.existsByUsername(username); }
}
