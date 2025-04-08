/**
 * 
 */
package com.webmedia.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.webmedia.domain.User;
import com.webmedia.service.UserManager;
import com.webmedia.service.UserManagerImp;

/**
 * A Validator class deals with validating user inputs and verifying the user credentials
 * @author      Inam Soomro
 * @version     1.0                                    
 * @since       2011-12          
 * 
 **/
public class LogonValidator implements Validator {
	
	 private final Log logger = LogFactory.getLog(getClass());
	 private UserManager userManager;
	 
  /**
 	* Method is called to see if the validator supports a given object type
 	* @param  Class.
	* @return boolean: a true if Object type is supported or false if it is not 
	*
	**/
	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(User.class);
	}

	/**
 	* Method is called for validation of given object type and input filteration
 	* if the validation is successful, it will call the LogonFormController
 	* @param  Object, Errors.
	* @return None 
	*
	**/
	@Override
	 public void validate(Object obj, Errors errors) {
		/**
		 * User Object to be validated.
		 */
		User user = (User) obj;
		logger.info(this.userManager);
		        if (user == null) {
		            errors.rejectValue("userName", "error.login.not-specified", null,
		                    "Value required.");
		        } else {
		            logger.info("Validating user credentials for: "+ user.getUserName());
		            User usr = this.userManager.verifyUser(user);
		            if (user.getUserName().equals(usr.getUserName()) == false) {
		                errors.rejectValue("userName", "error.login.invalid-user",
		                        null, "Incorrect Username.");
		            } else {
		                if (user.getPassword().equals(usr.getPassword()) == false) {
		                    errors.rejectValue("password", "error.login.invalid-pass",
		                            null, "Incorrect Password.");
		                }
		            }

		        }
		    }

	/**
 	* getter Method for userManager Object
 	* @param  None
	* @return UserManager 
	*
	**/
	public UserManager getUserManager() {
		return userManager;
	}

	/**
 	* setter Method for injecting the userManager Object
 	* @param  UserManager
	* @return None 
	*
	**/
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	
	
	
}
