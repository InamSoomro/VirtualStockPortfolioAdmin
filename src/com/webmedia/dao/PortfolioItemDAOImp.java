package com.webmedia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import com.webmedia.domain.PorfolioItem;
import com.webmedia.domain.PortfolioItemTransaction;

/**
 * A class responsible for establishing a connection and communicating with the
 * database and persisting the data
 * 
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 * 
 **/
public class PortfolioItemDAOImp extends SimpleJdbcDaoSupport implements
		PortfolioItemDAO {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * The method is responsible for retrieving the list of item for portfolio
	 * Normally all the transaction establish a connection through SpringJDBC
	 * but in case of JavaQuartz autoshceduler the dependency injections are not
	 * working, hence establishing a connection through DataSourceManager class
	 * 
	 * @return List of Portfolio Items
	 * @throws SQLException
	 * 
	 **/
	@Override
	public List<PorfolioItem> getPortfolioItemList() {

		if (getJdbcTemplate() == null) {
			Connection connection = null;

			String userName = "root";
			String password = "mysql";
			String uri = "jdbc:mysql:///portfolio";
			// getting a singleton instance of DataSourceManager and getting a
			// connection a connection from datasource
			DataSourceManager manager = DataSourceManager
					.getDataSourceManagerInstance(userName, password, uri);

			try {
				connection = manager.getConnection();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}

			Statement st = null;
			ResultSet rs = null;
			try {
				st = connection.createStatement();
				rs = st.executeQuery("select * from PortfolioItem");
				List<PorfolioItem> portfolio = new ArrayList<PorfolioItem>();
				while (rs.next()) {
					PorfolioItem pItem = new PorfolioItem();
					pItem.setId(rs.getInt("Id"));
					pItem.setCompany(rs.getString("CompanyName"));
					pItem.setShares(rs.getInt("Shares"));
					pItem.setSymbol(rs.getString("Symbol"));
					pItem.setBuying(rs.getDouble("Buying"));
					pItem.setSelling(rs.getDouble("Selling"));

					portfolio.add(pItem);
				}
				connection.close();
				return portfolio;
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {

			List<PorfolioItem> pItems = getJdbcTemplate().query(
					"select * from PortfolioItem",
					new RowMapper<PorfolioItem>() {
						public PorfolioItem mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							PorfolioItem pItem = new PorfolioItem();
							pItem.setId(rs.getInt("Id"));
							pItem.setCompany(rs.getString("CompanyName"));
							pItem.setShares(rs.getInt("Shares"));
							pItem.setSymbol(rs.getString("Symbol"));
							pItem.setBuying(rs.getDouble("Buying"));
							pItem.setSelling(rs.getDouble("Selling"));

							return pItem;
						}
					});
			return pItems;
		}
		return null;

	}
	/**
	 * Method will return tPortfolioItem Object based on the ID
	 * @param Id
	 * @return a single object of ItemPortfolio
	 * @throws SQLException            
	 **/
	@Override
	public PorfolioItem getPortfolioItemById(int id) {
		PorfolioItem portfolioItem = getJdbcTemplate().queryForObject(
				"select * from PortfolioItem where Id =" + id,
				new RowMapper<PorfolioItem>() {
					public PorfolioItem mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						PorfolioItem pItem = new PorfolioItem();
						pItem.setId(rs.getInt("Id"));
						pItem.setCompany(rs.getString("CompanyName"));
						pItem.setShares(rs.getInt("Shares"));
						pItem.setSymbol(rs.getString("Symbol"));
						pItem.setBuying(rs.getDouble("Buying"));
						pItem.setSelling(rs.getDouble("Selling"));

						return pItem;

					}
				});
		return portfolioItem;

	}

	/**
	 * Method will insert a transaction data into a database table
	 * @param PortfolioItemTransaction
	 * @return int
	 *             
	 **/
	@Override
	public int save(PortfolioItemTransaction portfolioItemTransactionBean) {
		return getJdbcTemplate()
				.update("insert into portfolioItemTransaction (PortfolioUserId, PortfolioItemId,Quantity, Brokerage, Tax, Subtotal, Total, TransactionType, TransactionDate) values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
						new Object[] {
								portfolioItemTransactionBean.getPortfolioUserId(),
								portfolioItemTransactionBean.getPortfolioItemId(),
								portfolioItemTransactionBean.getQuantity(),
								portfolioItemTransactionBean.getBrokarage(),
								portfolioItemTransactionBean.getTax(),
								portfolioItemTransactionBean.getSubtotal(),
								portfolioItemTransactionBean.getTotal(),
								portfolioItemTransactionBean.getTransactionType(),
								portfolioItemTransactionBean.getTransactionDate() });

	}

	/**
	 * Method is responsible of update the state of a database table
	 * Normally all the transaction establish a connection through SpringJDBC
	 * but in case of JavaQuartz autoshceduler the dependency injections are not
	 * working, hence establishing a connection through DataSourceManager class
	 * 
	 * @param PortfolioItem
	 * @return None
	 * @throws SQLException
	 *             
	 **/
	@Override
	public void executeUpdate(PorfolioItem portfolioItem) {

		if (portfolioItem.getBuying() != null
				&& portfolioItem.getSelling() != null) {

			if (getJdbcTemplate() == null) {
				Connection connection = null;

				String userName = "root";
				String password = "mysql";
				String uri = "jdbc:mysql:///portfolio";
				// getting a singleton instance of DataSourceManager and getting
				// a connection a connection from datasource
				DataSourceManager manager = DataSourceManager
						.getDataSourceManagerInstance(userName, password, uri);

				try {
					connection = manager.getConnection();
				} catch (SQLException exception) {
					exception.printStackTrace();
				}

				Statement st = null;
				try {
					st = connection.createStatement();
					st.executeUpdate("UPDATE portfolioitem SET Buying = "
							+ portfolioItem.getBuying() + ", Selling = "
							+ portfolioItem.getSelling() + " where Id ="
							+ portfolioItem.getId());
					connection.close();
				} catch (Exception e) {
					// TODO: handle exception
				}

			} else
				getJdbcTemplate()
						.update("UPDATE portfolioitem SET Buying = ?, Selling = ? where Id = ?",
								new Object[] { portfolioItem.getBuying(),
										portfolioItem.getSelling(),
										portfolioItem.getId() });
		} else if (portfolioItem.getShares() != null) {

			getJdbcTemplate().update(
					"UPDATE portfolioitem SET Shares = ? where Id = ? ",
					new Object[] { new Integer(portfolioItem.getShares()),
							new Integer(portfolioItem.getId()) });

		}

	}
	/**
	 * Method is responsible of update the state of a database table and updates the shares
	 * if someone has bought them or sold them
	 * @param PortfolioItem
	 * @return None
	 *             
	 **/
	public void updateShares(PorfolioItem portfolioItem) {
		getJdbcTemplate().update(
				"UPDATE portfolioitem SET Shares = ? where Id = ? ",
				new Object[] { new Integer(portfolioItem.getShares()),
						new Integer(portfolioItem.getId()) });

	}

}
