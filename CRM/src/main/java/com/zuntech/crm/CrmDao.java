package com.zuntech.crm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class CrmDao   
{
	
	private static CrmDao crmDao=null; // The private static instance variable that will hold the single instance of RealDao
	
	
	private Connection con = null;
    private Statement statement = null;
    private ResultSet rSet = null;
    private PreparedStatement pStatement = null;

	private CrmDao() // here I keep the constructor as private so that no one can create the object except in getRealDao()
	{
		String url = "jdbc:mysql://localhost:3306/crmdb";
		String username = "root";
		String pass = "Shah@123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class updated");

			con = DriverManager.getConnection(url, username, pass);    
			System.out.println("connection etablished");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static CrmDao getCrmDao() {  //method to get the instance of RealDao
        if (crmDao == null) {
            synchronized (CrmDao.class) { //synchronized block for thread safety
                if (crmDao == null) {
                	crmDao = new CrmDao();
                }
            }
        }
        return crmDao;
    }
	
	public List<Customer> getCustomers()
	{
		List<Customer> customers= new ArrayList<>();
		String sql="select * from crmdb.customer";
		try {
			statement=con.createStatement();
			rSet=statement.executeQuery(sql);
			while(rSet.next()) 
			{
				Customer u1=new Customer();
				u1.setId(rSet.getInt(1));
				u1.setFirstName(rSet.getString(2));
				u1.setLastName(rSet.getString(3));
				u1.setEmail(rSet.getString(4));
				
				customers.add(u1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
		
	}
	
	public Customer getCustomer(int id)
	{
		String sql="select * from crmdb.customer where id="+id;
		Customer u1=null;
		try {
			statement=con.createStatement();
			rSet=statement.executeQuery(sql);
					if(rSet.next()) 
					{
						u1=new Customer();
						u1.setFirstName(rSet.getString(2));
						u1.setLastName(rSet.getString(3));
						u1.setEmail(rSet.getString(4));
						u1.setId(rSet.getInt(1));
						
						
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u1;
		
	}
	
	public boolean create(Customer u1) {
		String sql="insert into crmdb.customer(id,First_Name,Last_Name,Email) values (?,?,?,?)";
		try {
			pStatement= con.prepareStatement(sql);
			pStatement.setInt(1, u1.getId());
			pStatement.setString(2, u1.getFirstName());
			pStatement.setString(3, u1.getLastName());
			pStatement.setString(4, u1.getEmail());
			
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
		String sql="delete from crmdb.customer where id=?";
		try {
			pStatement= con.prepareStatement(sql);
			pStatement.setInt(1, id);
			
			
			int rowDelete=pStatement.executeUpdate();
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

	public boolean updateCustomer(Customer u1) {
		String sql="update crmdb.customer set First_Name=?,Last_Name=?,Email=? where id=?";
		try {
			pStatement=con.prepareStatement(sql);
			
			pStatement.setString(1,u1.getFirstName());
			pStatement.setString(2,u1.getLastName());
			pStatement.setString(3,u1.getEmail());
			pStatement.setInt(4,u1.getId());
			
			int rowUpdated=pStatement.executeUpdate();
			
			if (rowUpdated > 0) {
	            
				System.out.println("1 row updated");
	            return true; // Return true for successful insertion
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
		/*
		 * finally { if(con!=null) { try { con.close(); } catch (SQLException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } } if(statement!=null)
		 * { try { statement.close(); } catch (SQLException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } } if(rSet!=null) { try { rSet.close(); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } if(pStatement!=null) { try { pStatement.close(); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * } }
		 */
	}
	
	

}
