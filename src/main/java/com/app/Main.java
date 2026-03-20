package com.app;

import com.dao.UserDao;
import com.dao.PostDao;
import com.dao.CommentDao;
import com.entity.User;
import com.entity.Post;
import com.entity.Comment;

public class Main {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        PostDao postDao = new PostDao();
        CommentDao commentDao = new CommentDao();

        User user1 = new User();
        user1.setName("Jayesh");
        user1.setEmail("jayesh@gmail.com");

        User user2 = new User();
        user2.setName("Rahul");
        user2.setEmail("rahul@gmail.com");

        User user3 = new User();
        user3.setName("Priya");
        user3.setEmail("priya@gmail.com");

        userDao.saveUser(user1);
        userDao.saveUser(user2);
        userDao.saveUser(user3);

        userDao.addFriend(user1.getId(), user2.getId());
        userDao.addFriend(user1.getId(), user3.getId());

        Post post1 = new Post();
        post1.setContent("Just started learning Hibernate. Feeling excited!");

        postDao.createPost(user1.getId(), post1);

        Post post2 = new Post();
        post2.setContent("Working on backend development. Any suggestions?");

        postDao.createPost(user2.getId(), post2);

        Comment c1 = new Comment();
        c1.setText("Great! Hibernate is powerful.");

        commentDao.addComment(post1.getId(), c1);

        Comment c2 = new Comment();
        c2.setText("Keep going, you're doing awesome!");

        commentDao.addComment(post1.getId(), c2);

        Comment c3 = new Comment();
        c3.setText("Try Spring Boot next.");

        commentDao.addComment(post2.getId(), c3);

        Comment c4 = new Comment();
        c4.setText("Backend is fun once you understand it.");

        commentDao.addComment(post2.getId(), c4);

        System.out.println("Application executed successfully");
    }
}









//package com.app;
//
//import com.dao.CommentDao;
//import com.dao.PostDao;
//import com.dao.UserDao;
//import com.entity.Comment;
//import com.entity.Post;
//import com.entity.User;
//import com.util.HibernateUtil;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
//public class Main {
//    public static void main(String[] args) {
//        // 1 get session factory
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//
//        // 2 open session
//        Session session = sessionFactory.openSession();
//
//        // transection
//        Transaction transaction = session.beginTransaction();
//        // Creating the DAO Object
//        UserDao ud = new UserDao();
//        PostDao pd = new PostDao();
//        CommentDao cd = new CommentDao();
//
//        // 1. create object
//        User user1 = new User();//        User user1 = new User();
//        user1.setName("Jayesh");
//        user1.setEmail("jayesh.test@gmail.c");
//        User user2 = new User();
//        user2.setName("Rahul");
//        user2.setEmail("rahul.test@gmail.c");
//
//        // save user
//        ud.saveUser(user1);
//        ud.saveUser(user2);
//
//        // 3. Add Friendship
//        ud.addFriend(user1.getId(), user2.getId());
//
//        // 4. Create Post
//        Post post = new Post();
//        post.setContent("Hello everyone, this is my first post!");
//
//        pd.createPost(user1.getId(), post);
//
//        // 5. Add Comment
//        Comment comment = new Comment();
//        comment.setText("Nice post bro!");
//
//        cd.addComment(post.getId(), comment);
//
//        System.out.println("✅ Project executed successfully!");
//
//        // save object
//        session.persist(user1);
//        session.persist(user2);
//        transaction.commit();
//
//        //close
//        session.close();
//        sessionFactory.close();
//
//        System.out.println("User saved successfully!");
//    }
//}
