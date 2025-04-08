/**
 * 
 */
package com.webmedia.dao;

import com.webmedia.domain.User;

/**
 * Interface for item DAO
 * 
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 * 
 **/
public interface UserDAO {
	
	public User verifyUser(User user);

	public User getUserById(int id);

	public void executeUpdate(User user);

	public User getUserByName(User user);

}
