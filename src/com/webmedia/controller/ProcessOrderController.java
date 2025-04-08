/**
 * 
 */
package com.webmedia.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.webmedia.domain.PorfolioItem;
import com.webmedia.domain.PortfolioItemTransaction;
import com.webmedia.domain.User;
import com.webmedia.service.PortfolioItemManager;

/**
 * A controller class responsible for processing the transaction either selling or
 * buying and making calculation extending AbstractController
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 * 
 **/
public class ProcessOrderController extends AbstractController {

	protected final Log logger = LogFactory.getLog(getClass());
	private PortfolioItemManager portfolioItemManager;
	private PortfolioItemTransaction portfolioItemTransaction;
	/**
	 * @param HttpServletRequest
	 *            , HttpServletResponse.
	 * @return ModelAndView. Returning the ProcessOrderView with portfolio Item
	 *         object to be sold or bought and the amount. 
	 * @throws Exception
	 *             
	 **/
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		int quantity = (int) (Math.random() * 10);
		HttpSession session = request.getSession(false);
		PorfolioItem pItem;
		pItem = this.portfolioItemManager.getPortfolioItemById(id);
		portfolioItemTransaction = new PortfolioItemTransaction();
		portfolioItemTransaction.setPortfolioItemId(id);
		portfolioItemTransaction.setQuantity(quantity==0?5:quantity);
		portfolioItemTransaction.setTransactionDate(new Date());
		portfolioItemTransaction.setSubtotal(portfolioItemManager.getSubtotal(pItem.getBuying(), quantity));
		portfolioItemTransaction.setBrokarage(portfolioItemManager.getBrokrage(pItem.getBuying(), quantity));
		portfolioItemTransaction.setTotal(portfolioItemManager.getTotal(portfolioItemManager.getSubtotal(pItem.getBuying(), quantity),
				portfolioItemManager.getBrokrage(pItem.getBuying(), quantity)));
		User user = (User)session.getAttribute("user");
		portfolioItemTransaction.setPortfolioUserId(user.getId());
		portfolioItemTransaction.setTransactionType((String) session.getAttribute("transactionType"));

		Map<String, Object> portfolioTransactionDetails = new HashMap<String, Object>();
		portfolioTransactionDetails.put("portfolioItem", pItem);
		portfolioTransactionDetails.put("portfolioItemTransaction",portfolioItemTransaction);

		session.setAttribute("portfolioTransactionDetails",portfolioTransactionDetails);

		return new ModelAndView("processOrder", "itemDetailMap",portfolioTransactionDetails);
	}

	
	/**
	 * getter method for PortfolioItemManager
	 * 
	 **/
	public PortfolioItemManager getPortfolioItemManager() {
		return portfolioItemManager;
	}

	/**
	 * setter method for injecting PortfolioItemManager object
	 * @param PortfolioItemManager
	 * @return None
	 **/
	public void setPortfolioItemManager(
			PortfolioItemManager portfolioItemManager) {
		this.portfolioItemManager = portfolioItemManager;
	}

}
