/**
 * 
 */
package com.webmedia.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.webmedia.domain.PorfolioItem;
import com.webmedia.service.PortfolioItemManager;
import com.webmedia.service.PortfolioItemManagerImp;

/**
 * A controller class responsible for making a transaction either selling or
 * buying extending AbstractController
 * 
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 * 
 **/
public class TransactionController extends AbstractController {

	private PortfolioItemManager portfolioItemManager;

	public TransactionController() {

	}

	/**
	 * @param HttpServletRequest
	 *            , HttpServletResponse.
	 * @return ModelAndView. Returning the transactioView with portfolio Item
	 *         object to be sold or bought
	 * @throws ServletException
	 *             , IOException
	 **/
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String transactionType = request.getParameter("TransactionType");
		logger.info("Portfolio Item By ID : " + id);
		PorfolioItem pItem;
		pItem = this.portfolioItemManager.getPortfolioItemById(id);
		HttpSession session = request.getSession();
		session.setAttribute("transactionType", transactionType);

		return new ModelAndView("transaction", "pItem", pItem);
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
	public void setPortfolioItemManager(
			PortfolioItemManager portfolioItemManager) {
		this.portfolioItemManager = portfolioItemManager;
	}

}
