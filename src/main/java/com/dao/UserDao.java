package com.dao;

import com.entity.User;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDao {
    // Save User
    public void saveUser(User user){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    // get user by id
    public User getUserById(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return  session.get(User.class,id);
        }
    }
    // Add friend (Many to Many)
    public  void addFriend(int userId1,int userId2){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            User user1 = session.get(User.class,userId1);
            User user2 = session.get(User.class,userId2);

            // add both side
            user1.getFriends().add(user1);
            user2.getFriends().add(user2);

            session.merge(user1);
            session.merge(user2);

            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
