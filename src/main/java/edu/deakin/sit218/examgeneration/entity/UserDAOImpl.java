package edu.deakin.sit218.examgeneration.entity;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@Transactional
public class UserDAOImpl implements UserDAO{
//UNCOMMENT THIS SECTION FOR SECURE SQL QUERY
//	@PersistenceContext
//    private EntityManager entityManager;
	
	SessionFactory factory;

	public UserDAOImpl() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory();
	}
	
	@Override
	public void updateUser(User user) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
		}
		finally {
			session.close();
		}	
		
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean areCredentialsCorrect(String username, String password) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			//create the query
			String hql = "from users where username = '"+ username + "'"+
					" and password = '" + password + "'";
			Query<User> query = session.createQuery(hql);
			List users = query.list();
			return !users.isEmpty();
		}
		finally {
			session.close();
		}
	}

	@Override
	public boolean existsUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> retrieveUser(String username) {
		//SECURE SQL QUERY
		//return (User) entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
		Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        User user = null;

        String url = "jdbc:mariadb://localhost:3306/forum_db";  // Replace with your database URL
        String dbUser = "coachdbadmin";  // Replace with your database username
        String dbPassword = "coachdbadmin";  // Replace with your database password
        List<User> users = new ArrayList<User>();
        try {
            // Load the MariaDB driver
            Class.forName("org.mariadb.jdbc.Driver");
            
            // Establish a connection to the database
            connection = DriverManager.getConnection(url, dbUser, dbPassword);
            
            // Create the SQL query by directly concatenating the 'username' (unsafe)
            //String sql = "select * from users where username like '%" + username + "%'";
            String sql = "select * from users where username like '%" + username + "%'";
            // Create a statement object to execute the query
            statement = connection.createStatement();
            System.out.print(sql);
            // Execute the query
            resultSet = statement.executeQuery(sql);
            
            // Process the result set
            while (resultSet.next()) {
                user = new User();
                user.setUser_id(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setSecret(resultSet.getString(4));  // Handle address accordingly
                users.add(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  // Handle driver class not found error
        } catch (SQLException e) {
            e.printStackTrace();  // Handle SQL exceptions
        } finally {
            // Close resources in the correct order
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return users;
	}

	@Override
	public User retrieveUserByID(int userId) {
		//SECURE SQL QUERY
//		return (User) entityManager.createQuery("SELECT u FROM User u", User.class).getSingleResult();
		Session session = factory.getCurrentSession();		
		try {
			session.beginTransaction();
			//create the query
			String hql = "from users where user_id = '"+ userId + "'";
			Query<User> query = session.createQuery(hql);
			User user = query.getSingleResult();
			return user;
		}
		finally {
			session.close();
		}
	}

}
