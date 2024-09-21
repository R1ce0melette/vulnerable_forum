package edu.deakin.sit218.examgeneration.entity;

import java.util.List;

public interface UserDAO {
	public void updateUser(User user);

	public void insertUser(User user);

	public boolean areCredentialsCorrect(String username, String password);

	public boolean existsUser(String username, String password);
	
	public List<User> retrieveUser(String username);

	public User retrieveUserByID(int userId);
}
