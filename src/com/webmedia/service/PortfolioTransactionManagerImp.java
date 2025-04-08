/**
 * 
 */
package com.webmedia.service;

import java.util.List;

import com.webmedia.dao.PortfolioTransactionDAO;
import com.webmedia.domain.PortfolioItemTransaction;
import com.webmedia.domain.PortfolioTransactionAndItemBean;

/**
 * @author Inam Soomro
 *
 */
public class PortfolioTransactionManagerImp implements PortfolioTransactionManager {

	
	private PortfolioTransactionDAO portfolioTransactionDAO;
	


	@Override
	public List<PortfolioTransactionAndItemBean> getTransactionList() {
		// TODO Auto-generated method stub
		return portfolioTransactionDAO.getTransactionList();
	}



	public PortfolioTransactionDAO getPortfolioTransactionDAO() {
		return portfolioTransactionDAO;
	}



	public void setPortfolioTransactionDAO(
			PortfolioTransactionDAO portfolioTransactionDAO) {
		this.portfolioTransactionDAO = portfolioTransactionDAO;
	}

	
	
	
}
