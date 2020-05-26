/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import retailerproject.AllFrames;

/**
 *
 * @author Sambit
 */
public class ExitControl {
    public static boolean mymainv ;
    public static boolean custregstv;
    public static boolean custupdatev;
    public static boolean forgotv;
    public static boolean retailloginv;
    public static boolean retailregisterv;
    public static boolean searchcustv;
    public static boolean totalv ;
    public static boolean retailpanelv;
    public static boolean searchresv;
    public static void check()
    {
        mymainv = AllFrames.mymain.isVisible();
        custregstv =  AllFrames.custregst.isVisible();
       custupdatev = AllFrames.custupdate.isVisible();
                forgotv =  AllFrames.forgot.isVisible();
                retailloginv= AllFrames.retaillogin.isVisible();
                retailpanelv= AllFrames.retailpanel.isVisible();
                retailregisterv= AllFrames.retailregister.isVisible();
                searchcustv= AllFrames.searchcust.isVisible();
                searchresv = AllFrames.searchres.isVisible();
                totalv= AllFrames.total.isVisible();
                
                if((mymainv == false &&  custregstv == false  && custupdatev == false && forgotv ==false && retailloginv==false && retailpanelv==false && retailregisterv==false && searchcustv==false && searchresv==false && totalv==false))
                {
                    System.exit(0);
                    
                }
                
                
    }
    
}
