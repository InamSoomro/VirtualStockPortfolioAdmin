/**
 * 
 */
package com.webmedia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.webmedia.domain.PorfolioItem;
import com.webmedia.domain.User;

/**
 * Class responsible for User Specific stuff
 * 
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 * 
 **/
public class UserDAOImp extends SimpleJdbcDaoSupport implements UserDAO {

	/**
	 * Method will verify the user credentials
	 * 
	 * @param User
	 * @return a single object of User
	 * @throws SQLException
	 **/
	@Override
	public User verifyUser(User user) {

		User usr = getJdbcTemplate().queryForObject(
				"select * from user where UserName =\'"+user.getUserName()+"\' and Password = \'"+user.getPassword()+"\'",
				new RowMapper<User>() {
					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();
						user.setId(rs.getInt("Id"));
						user.setUserName(rs.getString("UserName"));
						user.setPassword(rs.getString("Password"));
						user.setCurrentCapital(rs.getDouble("CurrentCapital"));
						user.setStartupCapital(rs.getDouble("StartupCapital"));
						
						return user;

					}
				});

		return usr;
	}

	/**
	 * Method will return user based on ID
	 * 
	 * @param Id
	 * @return a single object of User
	 * @throws SQLException
	 **/
	@Override
	public User getUserById(int id) {

		User usr = getJdbcTemplate().queryForObject(
				"select * from user where Id = ?",
				new Object[] { new Integer(id) }, new RowMapper<User>() {
					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();
						user.setId(rs.getInt("Id"));
						user.setUserName(rs.getString("UserName"));
						user.setPassword(rs.getString("Password"));
						user.setStartupCapital(rs.getDouble("StartupCapital"));
						user.setCurrentCapital(rs.getDouble("CurrentCapital"));
						return user;

					}
				});

		return usr;

	}

	/**
	 * Method will update the state of a database table
	 * 
	 * @param User
	 * @return None
	 * 
	 **/

	@Override
	public void executeUpdate(User user) {
		getJdbcTemplate().update(
				"update user set CurrentCapital = ? where Id = ?",
				new Object[] { new Double(user.getCurrentCapital()),
						new Integer(user.getId()) });

	}

	@Override
	public User getUserByName(User user) {
		// TODO Auto-generated method stub
		User usr = getJdbcTemplate().queryForObject(
				"select Id, UserName, Password, StartupCapital, CurrentCapital from user where UserName = ?",
				new Object[] { user.getUserName() },
				new RowMapper<User>() {
					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();
						user.setId(rs.getInt("Id"));
						user.setUserName(rs.getString("UserName"));
						user.setPassword(rs.getString("Password"));
						user.setCurrentCapital(rs.getDouble("CurrentCapital"));
						user.setStartupCapital(rs.getDouble("StartupCapital"));
						
						return user;

					}
				});

		return usr;
	}

}
