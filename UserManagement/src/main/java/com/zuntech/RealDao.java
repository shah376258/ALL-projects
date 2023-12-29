package com.zuntech;

import java.sql.*;
import java.util.*;

public class RealDao 
{
	
	private static RealDao realDao=null; // The private static instance variable that will hold the single instance of RealDao
	
	
	private Connection con = null;
    private Statement statement = null;
    private ResultSet rSet = null;
    private PreparedStatement pStatement = null;

	private RealDao() // here I keep the constructor as private so that no one can create the object except in getRealDao()
	{
		String url = "jdbc:mysql://localhost:3306/restDB";
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
	public static RealDao getRealDao() {  //method to get the instance of RealDao
        if (realDao == null) {
            synchronized (RealDao.class) { //synchronized block for thread safety
                if (realDao == null) {
                	realDao = new RealDao();
                }
            }
        }
        return realDao;
    }
	
	public List<User> getUsers()
	{
		List<User> users= new ArrayList<>();
		String sql="select * from restdb.user";
		try {
			statement=con.createStatement();
			rSet=statement.executeQuery(sql);
			while(rSet.next()) 
			{
				User u1=new User();
				u1.setId(rSet.getInt(1));
				u1.setName(rSet.getString(2));
				u1.setAddress(rSet.getString(3));
				
				users.add(u1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	}
	
	public User getUser(int id)
	{
		String sql="select * from restdb.user where id="+id;
		User u1=null;
		try {
			statement=con.createStatement();
			rSet=statement.executeQuery(sql);
					if(rSet.next()) 
					{
						u1=new User();
						u1.setAddress(rSet.getString(3));
						u1.setName(rSet.getString(2));
						u1.setId(rSet.getInt(1));
						
						
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u1;
		
	}
	
	public void create(User u1) {
		String sql="insert into restdb.user(id,name,address) values (?,?,?)";
		try {
			pStatement= con.prepareStatement(sql);
			pStatement.setInt(1, u1.getId());
			pStatement.setString(2, u1.getName());
			pStatement.setString(3, u1.getAddress());
			
			pStatement.executeUpdate();
			
			System.out.println("1 row created");
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void removeUser(int id) {
		String sql="delete from restdb.user where id=?";
		try {
			pStatement= con.prepareStatement(sql);
			pStatement.setInt(1, id);
			
			
			pStatement.executeUpdate();
			
			System.out.println("1 row deleted");
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateUser(User u1) {
		String sql="update restdb.user set name=?,address=? where id=?";
		try {
			pStatement=con.prepareStatement(sql);
			
			pStatement.setString(2,u1.getName());
			pStatement.setString(1,u1.getAddress());
			pStatement.setInt(3,u1.getId());
			
			pStatement.executeUpdate();
			
			System.out.println("1 row updated");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rSet!=null) {
				try {
					rSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pStatement!=null) {
				try {
					pStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	

}
