/**
 * 
 */
package com.webmedia.service;

import com.webmedia.dao.UserDAO;
import com.webmedia.domain.PorfolioItem;
import com.webmedia.domain.PortfolioItemTransaction;
import com.webmedia.domain.User;

/**
 * @author Inam Soomro
 *
 */
public class UserManagerImp implements UserManager {

	private UserDAO userDAO;
	
	
	
	public User verifyUser(User user){
		
		return userDAO.verifyUser(user);
		
	}
	
	@Override
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}



	
	public UserDAO getUserDAO() {
		return userDAO;
	}



	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void updateCurrentCapital(User user) {
		this.userDAO.executeUpdate(user);
	}

	@Override
	public User getUserByName(User user) {
		// TODO Auto-generated method stub
		return this.userDAO.getUserByName(user);
	}





	
	
	
	
	
	
}
