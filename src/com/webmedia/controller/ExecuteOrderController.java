/**
 * 
 */
package com.webmedia.controller;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.webmedia.domain.PorfolioItem;
import com.webmedia.domain.PortfolioItemTransaction;
import com.webmedia.domain.User;
import com.webmedia.service.PortfolioItemManager;
import com.webmedia.service.UserManager;

/**
 * A controller class responsible for Executing the transaction either selling
 * or buying and and confirming the success of transaction extending
 * AbstractController
 * 
 * @author Inam
 * @version 1.0
 * @since 2011-12
 * 
 **/
public class ExecuteOrderController extends AbstractController {

	private PortfolioItemManager portfolioItemManager;
	private UserManager userManager;

	/**
	 * @param HttpServletRequest
	 *            , HttpServletResponse.
	 * @return ModelAndView. Returning the transactioView with portfolio Item
	 *         object to be sold or bought
	 * @throws Exception
	 *             
	 **/
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		Map<String, Object> sessionMap = (Map<String, Object>) session.getAttribute("portfolioTransactionDetails");
		PorfolioItem portfolioItem = (PorfolioItem) sessionMap.get("portfolioItem");
		PortfolioItemTransaction portfolioItemTransactionBean = (PortfolioItemTransaction) sessionMap.get("portfolioItemTransaction");
		int i = this.portfolioItemManager.completeTransaction(portfolioItemTransactionBean);
		logger.info(i);
		if (i == 1) { // if successful, deduct the amount from totalCapital from  user
			User user = (User) session.getAttribute("user");
			this.portfolioItemManager.updateCapital(portfolioItemTransactionBean, user);
			this.portfolioItemManager.updateShares(portfolioItemTransactionBean, user, portfolioItem);
			return new ModelAndView("executeOrder", "message","Transaction completed successfully");
		} else {
			return new ModelAndView("executeOrder", "message","Transaction was not successful");
		}
	}
   
	/**
	 * getter Method for  PortfolioItemManager Object
	 * @return PortfolioItemManager
	 **/
	public PortfolioItemManager getPortfolioItemManager() {
		return portfolioItemManager;
	}
    
	/**
	 * setter Method for injecting the PortfolioItemManager Object
	 * @param PortfolioItemManager
	 * @return None
	 **/
	public void setPortfolioItemManager(PortfolioItemManager portfolioItemManager) {
		this.portfolioItemManager = portfolioItemManager;
	}
	/**
	 * getter Method for  userManager Object
	 * @return userManager
	 **/
	public UserManager getUserManager() {
		return userManager;
	}
	/**
	 * setter Method for injecting the UserManager Object
	 * @param UserManager
	 * @return None
	 **/
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

}
