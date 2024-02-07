package com.hibernatedemo004;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AllMethods {
	
	
	Configuration con;
	SessionFactory sf;
	Session ss;
	
	public void connection()
	{
		con = new Configuration();
    	con.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
    	sf = con.buildSessionFactory();
    	ss = sf.openSession();
    	System.out.println("Connection Established Successfully");
	}
	
	public void insert()
	{
		Employee emp = new Employee();
		emp.setName("Salman ");
		emp.setAddress("Bandra");
		emp.setDesignation("C");
		emp.setSalary(10000);
		ss.beginTransaction();
		ss.persist(emp);
		ss.getTransaction().commit();
		System.out.println("data added successfully");
		
	}
	
	public void updatedata()
	{
		ss.beginTransaction();
		Employee upd = ss.get(Employee.class, 4);
		upd.setName("shahrukh khan");
 		ss.update(upd);
		ss.getTransaction().commit();
		System.out.println("data updated successfully");
			
;	}
	
	public void deletedata()
	{
		ss.beginTransaction();
		Employee del = ss.get(Employee.class, 5);
		ss.delete(del);
		ss.getTransaction().commit();
		System.out.println("Data Deleted Successfully");
	}
	
	public void showdata()
	{
		ss.beginTransaction();

        String hql = "FROM Employee";
        Query<Employee> query = ss.createQuery(hql, Employee.class);

        List<Employee> employees = query.getResultList();

        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId() +
                    ", Name: " + employee.getName() +
                    ", Address: " + employee.getAddress() +
                    ", Designation: " + employee.getDesignation() +
                    ", Salary: " + employee.getSalary());
        }

        ss.getTransaction().commit();
	}

}
