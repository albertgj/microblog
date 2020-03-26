package it.marconivr.microblog.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.marconivr.microblog.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>
{

}
