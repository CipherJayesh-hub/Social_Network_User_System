📱 Social Network User System (Hibernate)
🚀 Project Overview

This is a backend social network application built using Java, Hibernate ORM, and MySQL.
It demonstrates real-world backend concepts like entity relationships, ORM mapping, and DAO design pattern.

🛠️ Tech Stack

Java

Hibernate ORM

MySQL

Maven

✨ Features

👤 User Management

📝 Post Creation

💬 Comment System

🤝 Friend Relationships (Many-to-Many)

🔄 Hibernate Session & Transaction Handling

🧠 Concepts Covered

Entity Mapping using Hibernate

One-to-Many Relationship (User → Posts, Post → Comments)

Many-to-Many Relationship (User ↔ Friends)

DAO (Data Access Object) Pattern

Lazy Fetching & Database Optimization

📂 Project Structure
src/
 ├── entity/        # User, Post, Comment classes
 ├── dao/           # UserDao, PostDao, CommentDao
 ├── util/          # HibernateUtil (SessionFactory)
 ├── app/           # Main class (execution)
 └── resources/     # hibernate.cfg.xml

⚙️ How to Run

Clone the repository

git clone https://github.com/your-username/social-network-user-system-hibernate.git

Open in IntelliJ / Eclipse

Configure MySQL in hibernate.cfg.xml

<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/social_network</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">your_password</property>

Run Main.java

📊 Database Tables

users

posts

comments

user_friends

🎯 Output

Users can create posts

Users can add friends

Posts can have multiple comments

All data is stored and managed using Hibernate ORM

📌 Learning Outcome

This project helped me understand:

Real-world backend architecture

ORM and database relationships

Clean code structure using DAO pattern
