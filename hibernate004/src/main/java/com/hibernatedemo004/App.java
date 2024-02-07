package com.hibernatedemo004;

import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	AllMethods am = new AllMethods();
    	am.connection();
    	//am.insert();
    	//am.updatedata();
    	//am.deletedata();
    	am.showdata();

    }
}
