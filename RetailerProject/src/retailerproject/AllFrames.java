/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retailerproject;

import javax.swing.JFrame;

/**
 *
 * @author Sambit
 */
public class AllFrames {
    public static JFrame mymain ;
    public static JFrame custregst;
    public static JFrame custupdate;
    public static JFrame forgot;
    public static JFrame retaillogin;
    public static JFrame retailregister;
    public static JFrame searchcust;
    public static JFrame total ;
    public static JFrame retailpanel;
    public static JFrame searchres;
    public AllFrames()
    {
        searchres = new SearchResult();
        mymain = new Main();
        custregst = new CustomerRegistration();
        custupdate = new CutomerUpdate();
        forgot = new ForgotPassword();
        retaillogin = new RetailerLogin();
        retailpanel = new RetailerPanel();
        retailregister = new RetailerRegistration();
        searchcust = new SearchCustomer();
        total = new TotalRecord();
       
    }

    
    

    
}
