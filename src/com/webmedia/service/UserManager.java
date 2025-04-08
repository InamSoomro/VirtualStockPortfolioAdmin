/**
 * 
 */
package com.webmedia.service;

import com.webmedia.domain.User;

/**
 * @author Inam Soomro
 *
 */
public interface UserManager {
	
	
	public User verifyUser(User user);

	public User getUserById(int id);

	public void updateCurrentCapital(User user);

	public User getUserByName(User user);
}
