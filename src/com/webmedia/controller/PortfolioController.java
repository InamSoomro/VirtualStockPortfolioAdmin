package com.webmedia.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import com.webmedia.domain.PorfolioItem;
import com.webmedia.domain.User;
import com.webmedia.quartzscheduler.PortfolioScheduler;
import com.webmedia.service.PortfolioItemManager;
import com.webmedia.service.PortfolioItemManagerImp;
import com.webmedia.service.UserManager;
import com.webmedia.service.UserManagerImp;

/**
 * A controller class responsible for retrieving and managing the PortfolioItem
 * extending AbstractController
 * 
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 * 
 **/
public class PortfolioController extends AbstractController {

	/**
	 * Logger for the class
	 **/
	protected final Log logger = LogFactory.getLog(getClass());
	private User user;
	private UserManager userManager;
	private PortfolioItemManager portfolioItemManager;

	/**
	 * @param HttpServletRequest
	 *            , HttpServletResponse.
	 * @return ModelAndView. Returning the portfolioView with portfolio Items
	 *         object
	 * @throws ServletException
	 *             , IOException
	 **/
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		logger.info("RETURNING THE MAIN VIEW: ");
		logger.info("Portfolio Item Manager: Injection "
				+ (this.portfolioItemManager != null));
		List<PorfolioItem> pItem = null;
		String now = (new Date()).toString();
		HttpSession session = request.getSession(false);
		user = (User)session.getAttribute("user");
		user = userManager.getUserByName(user);
		pItem = this.portfolioItemManager.getPortfolioItems();
		Map<String, Object> pItemModel = new HashMap<String, Object>();
		if (pItem != null) {
			pItemModel.put("pItems", pItem);
			pItemModel.put("startupcapital", user.getCurrentCapital());
			pItemModel.put("now", now);
		}
		// getting the session for the user
		session.setAttribute("user", user);

		return new ModelAndView("portfolio", "pItem", pItemModel);

	}

	/**
	 * setter Method for injecting the PortfolioItemManager Object
	 * @param PortfolioItemManager
	 * @return None
	 **/
	public void setPortfolioItemManager(PortfolioItemManager portfolioItemManager) {
		this.portfolioItemManager = portfolioItemManager;
	}

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
