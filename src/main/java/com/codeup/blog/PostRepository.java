package com.codeup.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
////p = alias for table name
//    @Query("from Post p where p.id like ?1")
//    Post getPostById(long id);
//
//    // The following method shows you how to use named parameters in a HQL custom query:
//    @Query("from Post p where p.title like %:term%")
//    List<Post> searchByTitleLike(@Param("term") String term);

}
