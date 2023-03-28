package com.techpalle.dao;

import java.sql.*;
import java.util.ArrayList;

import com.techpalle.model.Customer;

public class CustomerDao 
{
    private static final String classname="com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/customer_management";
    private static final String user="root";
    private static final String pw="admin";
    
    private static  Connection con=null;
    private static  PreparedStatement ps=null;
    private static   Statement st=null;
    private static ResultSet rs=null;
    
    private static  final String customerListQuery="select * from customer";
    private static final String customerInsert="insert into customer(name,email,mobile) values(?,?,?)";
    private static final String customerEdit="select * from customer where id=?";
    private static final String customerUpdate="update customer set name=?,email=?,mobile=? where id=?";
    private static final String customerDelete="delete from customer where id=?";
    
    
   
    public static Connection getConnectionDef()
    {
    	try 
    	{
			Class.forName(classname);
			con=DriverManager.getConnection(url, user, pw);
		} 
    	catch (ClassNotFoundException e)
    	{
			e.printStackTrace();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
		return con;
    }
    
    public static ArrayList<Customer> getAllCustomers()
    {
    	ArrayList<Customer> al=new ArrayList<Customer>();
    	try 
    	{
    		con=getConnectionDef();
			st=con.createStatement();
			rs=st.executeQuery(customerListQuery);
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				Long mobile=rs.getLong(4);
				Customer c=new Customer(id, name, email, mobile);
				al.add(c);
			}
			
		} 
    	catch (SQLException e)
    	{
			e.printStackTrace();
		}
    	finally
    	{
    		try 
    		{
    			if (st!=null)
				st.close();
    			if(con!=null)
    				con.close();
			}
    		catch (SQLException e)
    		{
				e.printStackTrace();
			}
    	}
		return al;
    }
    
    public static void insertCustomer(Customer c)
    {
    	
    	try 
    	{
    		con=getConnectionDef();
			ps=con.prepareStatement(customerInsert);
			ps.setString(1,c.getName());
			ps.setString(2,c.getEmail());
			ps.setLong(3,c.getMobile() );
			ps.executeUpdate();
			
		} 
    	catch (SQLException e)
    	{
			e.printStackTrace();
		}
    	finally
    	{
    		try 
    		{
    			if (ps!=null)
				ps.close();
    			if(con!=null)
    				con.close();
			}
    		catch (SQLException e)
    		{
				e.printStackTrace();
			}
    	}
		
    }
    
    public static Customer getOneCustomer(int id)
    {
    	Customer c=null;
    	try 
    	{
    		con=getConnectionDef();
			ps=con.prepareStatement(customerEdit);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			rs.next();
			int i=rs.getInt(1);
			String n=rs.getString(2);
			String e=rs.getString(3);
			long m=rs.getLong(4);
			 c=new Customer(i, n, e, m);
			
			
		} 
    	catch (SQLException e)
    	{
			e.printStackTrace();
		}
    	finally
    	{
    		try 
    		{
    			if (ps!=null)
				ps.close();
    			if(con!=null)
    				con.close();
			}
    		catch (SQLException e)
    		{
				e.printStackTrace();
			}
    	}
		return c;
		
    }
    
    
    public static void updateCustomer(Customer c)
    {
    	try 
    	{
    		con=getConnectionDef();
			ps=con.prepareStatement(customerUpdate);
			ps.setString(1,c.getName());
			ps.setString(2,c.getEmail());
			ps.setLong(3,c.getMobile());
			ps.setInt(4,c.getId());
			ps.executeUpdate();
			
		} 
    	catch (SQLException e)
    	{
			e.printStackTrace();
		}
    	finally
    	{
    		try 
    		{
    			if (ps!=null)
				ps.close();
    			if(con!=null)
    				con.close();
			}
    		catch (SQLException e)
    		{
				e.printStackTrace();
			}
    	}
		
    }
    public static void deleteCustomer(int id)
    {
    	try 
    	{
    		con=getConnectionDef();
			ps=con.prepareStatement(customerDelete);
			ps.setInt(1,id);
			ps.executeUpdate();			
			
		} 
    	catch (SQLException e)
    	{
			e.printStackTrace();
		}
    	finally
    	{
    		try 
    		{
    			if (ps!=null)
				ps.close();
    			if(con!=null)
    				con.close();
			}
    		catch (SQLException e)
    		{
				e.printStackTrace();
			}
    	}
    }
}
