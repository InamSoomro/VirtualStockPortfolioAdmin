package com.webmedia.dao;

import java.util.List;

import com.webmedia.domain.PortfolioItemTransaction;
import com.webmedia.domain.PortfolioTransactionAndItemBean;

public interface PortfolioTransactionDAO {

	List<PortfolioTransactionAndItemBean> getTransactionList();

}
