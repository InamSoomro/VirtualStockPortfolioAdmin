package com.webmedia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import com.webmedia.domain.PortfolioItemTransaction;
import com.webmedia.domain.PortfolioTransactionAndItemBean;

/**
 *
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 *
 **/
public class PortfolioTransactionDAOImp extends SimpleJdbcDaoSupport implements PortfolioTransactionDAO {

	@Override
	public List<PortfolioTransactionAndItemBean> getTransactionList() {
	
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT portfolioitemtransaction.Id, portfolioitemtransaction.PortfolioItemId, portfolioitemtransaction.PortfolioUserId,");
		sql.append(" portfolioitemtransaction.Quantity, portfolioitemtransaction.Subtotal, portfolioitemtransaction.Brokerage,");
		sql.append(" portfolioitemtransaction.Total, portfolioitemtransaction.TransactionDate, portfolioitemtransaction.TransactionType");
		sql.append(", portfolioitem.CompanyName, portfolioitem.Symbol FROM  portfolioitemtransaction INNER JOIN portfolioitem");
		sql.append(" ON  portfolioitem.Id = portfolioitemtransaction.PortfolioItemId");
		sql.append(" WHERE portfolioitemtransaction.PortfolioUserId = 2 LIMIT 0, 15");
		
		
		
		List<PortfolioTransactionAndItemBean> PortfolioItemTransactions= getJdbcTemplate().query(sql.toString(),
				new RowMapper<PortfolioTransactionAndItemBean>() {
					public PortfolioTransactionAndItemBean mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						PortfolioTransactionAndItemBean bean = new PortfolioTransactionAndItemBean();
						bean.setId(rs.getInt("Id"));
						bean.setId(rs.getInt("Id"));
						bean.setPortfolioUserId(rs.getInt("PortfolioUserId"));
						bean.setPortfolioItemId(rs.getInt("PortfolioItemId"));
						bean.setQuantity(rs.getInt("Quantity"));
						bean.setSubtotal(rs.getDouble("Subtotal"));
						bean.setTransactionDate(rs.getDate("TransactionDate").toString());
						bean.setTransactionType(rs.getString("TransactionType"));
						bean.setBrokarage(rs.getDouble("Brokerage"));
						bean.setTotal(rs.getDouble("Total"));
						bean.setCompanyName(rs.getString("CompanyName"));
						bean.setSymbol(rs.getString("Symbol"));
						return bean;
					}
				});
		return PortfolioItemTransactions;
	}
	
	
	
	
}
