package com.zuntech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zuntech.bean.Customer;
import com.zuntech.dbConnection.DbConnection;

public class CrmDao {

	private static CrmDao crmDao = null;

	private Connection con = null;
	
	

	private CrmDao() {
		con = DbConnection.getConnection();
	}

	public static synchronized CrmDao getCrmDao() {

		if (crmDao == null) {
			crmDao = new CrmDao();
		}

		return crmDao;
	}

	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<>();
		String sql = "select * from crmdb.customer";
		try (Statement statement = con.createStatement(); ResultSet rSet = statement.executeQuery(sql))
		{
			
			while (rSet.next()) {
				Customer c1 = new Customer();
				c1.setId(rSet.getInt(1));
				c1.setFirstName(rSet.getString(2));
				c1.setLastName(rSet.getString(3));
				c1.setEmail(rSet.getString(4));

				customers.add(c1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

	public Customer getCustomer(int id) {
		String sql = "select * from crmdb.customer where id=" + id;
		Customer c1 = null;
		try (Statement statement = con.createStatement(); ResultSet rSet = statement.executeQuery(sql))
		{
			
			if (rSet.next()) {
				c1 = new Customer();
				c1.setFirstName(rSet.getString(2));
				c1.setLastName(rSet.getString(3));
				c1.setEmail(rSet.getString(4));
				c1.setId(rSet.getInt(1));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c1;

	}

	public boolean create(Customer c1) {
		String sql = "insert into crmdb.customer(id,First_Name,Last_Name,Email) values (?,?,?,?)";
		try  (PreparedStatement pStatement = con.prepareStatement(sql))
		{

			pStatement.setInt(1, c1.getId());
			pStatement.setString(2, c1.getFirstName());
			pStatement.setString(3, c1.getLastName());
			pStatement.setString(4, c1.getEmail());

			int rowsAffected = pStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("1 row created");
				return true; // Return true for successful insertion
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeCustomer(int id) {
		String sql = "delete from crmdb.customer where id=?";
		try(PreparedStatement pStatement = con.prepareStatement(sql)) 
		{
			
			pStatement.setInt(1, id);

			int rowDelete = pStatement.executeUpdate();
			if (rowDelete > 0) {

				System.out.println("1 row deleted");
				return true; // Return true for successful insertion
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateCustomer(Customer c1) {
		String sql = "update crmdb.customer set First_Name=?,Last_Name=?,Email=? where id=?";
		try (PreparedStatement pStatement = con.prepareStatement(sql))
		{
			

			pStatement.setString(1, c1.getFirstName());
			pStatement.setString(2, c1.getLastName());
			pStatement.setString(3, c1.getEmail());
			pStatement.setInt(4, c1.getId());

			int rowUpdated = pStatement.executeUpdate();

			if (rowUpdated > 0) {

				System.out.println("1 row updated");
				return true; // Return true for successful insertion
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
//		finally {
//			if(con!=null) 
//			{
//				try {
//					con.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if(statement!=null) 
//			{
//				try {
//					statement.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if(pStatement!=null) 
//			{
//				try {
//					pStatement.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if(rSet!=null) 
//			{
//				try {
//					rSet.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}


		
		  
		 
	}
}
