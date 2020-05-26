/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Customers;

/**
 *
 * @author Sambit
 */
public class CustomersDao {
    public static boolean insertCustomer(Customers c)
    {
        boolean status = false;
        try
		{
		
		Connection con = Provider.getOracleConnection();
		String sql = "insert into customer values(?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
	    pst.setString(1, c.getName());
	    pst.setString(2, c.getPhone());
	    pst.setString(3, c.getEmail());
	    pst.setString(4, c.getAddress());
	    pst.setString(5, c.getBalance());
	    pst.setString(6, c.getLastAdded());
	    pst.setString(7,c.getLastSubtracted());
	    
	    int val = pst.executeUpdate();
	    if(val > 0)
	    {
	    	status =true;
	    }
	    else
	    {
	    	status = false;
	    }
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        return status;
        
        
    }
    public static boolean search(Customers ob)
    {
        boolean status = false;
        
        try
		{
		
		Connection con = Provider.getOracleConnection();
		String sql = "select * from customer where name=? ";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, ob.getName());
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next())
		{
			ob.setPhone(rs.getString("phone"));
                        ob.setEmail(rs.getString("email"));
                        ob.setAddress(rs.getString("address"));
                        ob.setBalance(rs.getString("balance"));
                        ob.setLastAdded(rs.getString("lastadded"));
                        ob.setLastSubtracted(rs.getString("lastdeducted"));
                        retailerproject.SearchResult.receiveData(ob);
                        
                        
			status = true;
		}
		else
		{
			status = false;
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        return status;
    }

     public static boolean searchMod(Customers ob)
    {
        boolean status = false;
        
        try
		{
		
		Connection con = Provider.getOracleConnection();
		String sql = "select * from customer where name=? ";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, ob.getName());
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next())
		{
			ob.setPhone(rs.getString("phone"));
                        ob.setEmail(rs.getString("email"));
                        ob.setAddress(rs.getString("address"));
                        ob.setBalance(rs.getString("balance"));
                        ob.setLastAdded(rs.getString("lastadded"));
                        ob.setLastSubtracted(rs.getString("lastdeducted"));
                             
                        
			status = true;
		}
		else
		{
			status = false;
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        return status;
    }
     public static boolean updateCustomer(Customers ob)
     {
         boolean status = false;
         int cnt = 0;
		try
		{
		
		Connection con = Provider.getOracleConnection();
		String sql = "update customer set balance=?,lastadded=?,lastdeducted=? where name=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1,ob.getBalance());
		pst.setString(2, ob.getLastAdded());
		pst.setString(3, ob.getLastSubtracted());
		pst.setString(4, ob.getName());
	
		int val = pst.executeUpdate();
		if(val > 0)
		{
			cnt = 1;
		}
		else
		{
			cnt = -1;
		}
		}
		catch(Exception f)
		{
			f.printStackTrace();
		}
                if(cnt > 0)
                {
                    status = true;
                }
         
         return status;
     }
     public static boolean getAllRecords()
     {
         boolean status = false;
                 ArrayList<Customers>  samp =new ArrayList<Customers>();
		try
		{
			
		   samp.clear();
		   Connection con = Provider.getOracleConnection();
		   String sql = "select * from customer";
		   PreparedStatement pst = con.prepareStatement(sql);
		   
		   ResultSet rs = pst.executeQuery(sql);
		   while(rs.next())
		   {
			  Customers s = new Customers();
			   s.setName(rs.getString(1));
			  s.setPhone(rs.getString(2));
			  s.setEmail(rs.getString(3));
                          s.setAddress(rs.getString(4));
                          s.setBalance(rs.getString(5));
                          s.setLastAdded(rs.getString(6));
                          s.setLastSubtracted(rs.getString(7));
			   samp.add(s);
			 status= true;
			  
			   
		   }
                   retailerproject.TotalRecord.receiveArrayList(samp);
		                 
                    
                

		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}

         return status;
     }

    
}
