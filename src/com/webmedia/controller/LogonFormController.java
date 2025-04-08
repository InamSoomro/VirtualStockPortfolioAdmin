/**
 * 
 */
package com.webmedia.controller;

import org.springframework.validation.BindException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.webmedia.domain.User;


/**
 * A controller class deals with verifying the user credentials
 * @author      Inam Soomro
 * @version     1.0                                    
 * @since       2011-12          
 * 
 **/
@SuppressWarnings("deprecation")
public class LogonFormController extends SimpleFormController {

	// @Override
	// public ModelAndView onSubmit(Object command) throws ServletException {
	// return new ModelAndView(new RedirectView(getSuccessView()));
	// }
   /**
	* Overriden method onsubmit 
	* @param  HttpServletRequest,HttpServletResponse,Object,BindException.
	* @return ModelAndView. Returning the SuccessView after verifying user 
	**/
	@Override
	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws ServletException {
		User user = (User) command;
		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		return new ModelAndView("portfolio","message","message");
	}

	/**
	* @param  HttpServletRequest.
	* @return Object of the form backing bean 
	**/
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		
		User user = new User();
		return user;
	}

}
