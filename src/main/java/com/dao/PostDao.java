package com.dao;

import com.entity.Post;
import com.entity.User;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PostDao {

    //create post
    public void createPost(int userId, Post post) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get user
            User user = session.get(User.class, userId);
            // link post to user
            post.setUser(user);
            //save post
            session.persist(post);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    //get post by id
    public Post getPostById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Post.class, id);
        }
    }

    // get all posts from user
    public List<Post> getPostsByUser(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Post p WHERE p.user.id = :userId";
            return session.createQuery(hql, Post.class)
                    .setParameter("userId", userId)
                    .getResultList();
        }
    }
}