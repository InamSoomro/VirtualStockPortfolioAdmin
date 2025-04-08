/**
 * 
 */
package com.webmedia.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.webmedia.domain.PortfolioItemTransaction;
import com.webmedia.domain.PortfolioTransactionAndItemBean;
import com.webmedia.service.PortfolioTransactionManager;

/**
 * @author Inam Soomro
 *
 */
public class PortfolioTransactionController  extends AbstractController  {

	private PortfolioTransactionManager portfolioTransactionManager;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		List<PortfolioTransactionAndItemBean> bean;
		bean = this.portfolioTransactionManager.getTransactionList();
		
		
		
		return new ModelAndView("viewtransactions","transactionbean",bean);
	}

	public PortfolioTransactionManager getPortfolioTransactionManagerImp() {
		return portfolioTransactionManager;
	}

	public void setPortfolioTransactionManager(
			PortfolioTransactionManager portfolioTransactionManager) {
		this.portfolioTransactionManager = portfolioTransactionManager;
	}

	
	
	
	
}
