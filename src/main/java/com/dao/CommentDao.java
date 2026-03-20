package com.dao;

import com.entity.Comment;
import com.entity.Post;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CommentDao {
    //add comment to post
    public void addComment(int postId, Comment comment){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            //get post
            Post post = session.get(Post.class,postId);
            //link comment to post
            comment.setPost(post);
            //save comment
            session.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    //get comment by id
    public Comment getCommentById (int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Comment.class,id);
        }
    }
    // get all comments of a post
    public List<Comment> getCommentsByPost(int postId){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String hql = "FROM Comment c WHERE c.post.id = :postId";

            return session.createQuery(hql, Comment.class).setParameter("postId",postId).getResultList();
        }
    }
}
