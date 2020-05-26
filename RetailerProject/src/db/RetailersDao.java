/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Retailers;

/**
 *
 * @author Sambit
 */
public class RetailersDao {
    public static boolean doRegister( Retailers r)
    {
        boolean status = false;
        int count = 0;
        try
		{
		
		Connection con = Provider.getOracleConnection();
		String sql = "insert into retailer values(?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, r.getUsername());
		pst.setString(2, r.getPassword());
		 count = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        if(count > 0)
        {
            status = true;
        }
        return status;
    }
    
    public static boolean doValidate(Retailers ad) {
		// TODO Auto-generated method stub
		boolean status = false;
		try
		{
		
		Connection con = Provider.getOracleConnection();
		String sql = "select * from retailer where username=? and password=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, ad.getUsername());
		pst.setString(2, ad.getPassword());
		ResultSet rs = pst.executeQuery();
		if(rs.next())
		{
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
    public static boolean updatePassword(Retailers r)
    {
        boolean status = false;
		try
		{
		
		Connection con = Provider.getOracleConnection();
                con.setAutoCommit(false);
               
               
		String sql = "update retailer set password=? where username=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1,r.getPassword());
		pst.setString(2, r.getUsername());
	
		int val = pst.executeUpdate();
                
                
		if(val > 0)
		{
			status = true;
                        con.setAutoCommit(true);
                        con.commit();
                        
		}
		else
		{
			status = false;
                        System.out.println("hii"+val);
		}
		}
		catch(Exception f)
		{
			 System.out.println(f);
			f.printStackTrace();
		}
                
		
	    
		return status;
    }

    
}
