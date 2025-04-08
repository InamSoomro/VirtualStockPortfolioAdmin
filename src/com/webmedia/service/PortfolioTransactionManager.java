package com.webmedia.service;

import java.util.List;

import com.webmedia.domain.PortfolioItemTransaction;
import com.webmedia.domain.PortfolioTransactionAndItemBean;

public interface PortfolioTransactionManager {

	List<PortfolioTransactionAndItemBean> getTransactionList();

}
