package edu.deakin.sit218.examgeneration.entity;

import java.util.List;

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
		// TODO Auto-generated method stub
		
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
	public User retrieveUser(String username) {
		//SECURE SQL QUERY
		//return (User) entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
		return null;
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
			User users = query.getSingleResult();
			return users;
		}
		finally {
			session.close();
		}
	}

}
