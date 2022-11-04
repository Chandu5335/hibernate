package com.klef.jfsd;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class ProductCRUDOperations 
{
   public static void main(String args[])
   {
	   ProductCRUDOperations crudOperations = new ProductCRUDOperations();
	 //  crudOperations.insertProduct();
	   //crudOperations.viewProduct();
	  // crudOperations.deleteProduct();
	  // crudOperations.updateProduct();
	   //crudOperations.updateProductRecord();
	    crudOperations.saveorupdateProduct();
   }
   public void insertProduct() // Insert Product
   {
	   Configuration configuration = new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory = configuration.buildSessionFactory();
	   Session session = sessionFactory.openSession(); 
	  
	   
	   Transaction transaction = session.beginTransaction();
	   
	   //transient state
	   
	   Product product = new Product();
	  
	   
	   
	   
	   product.setId(103);
	   product.setCategory("Sweets");
	   product.setName("Soan Papad");
	   product.setDescription("It is a Sweet");
	   product.setPrice(100.00);
	   product.setManufactureddate("03/09/2022");
	   product.setExpiry(true);
	   
	   
	   session.save(product);  //persistent state
	   
	   transaction.commit(); // which will save the results into database
	   
	   System.out.println("Product Object Saved Successfully");
	   
	   session.close(); //detached state
	   sessionFactory.close();
	   
   }
   
   public void viewProduct()
   {
	   Configuration configuration = new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory = configuration.buildSessionFactory();
	   Session session = sessionFactory.openSession();
	   
	   Object obj=session.load(Product.class, 103);
	  // Object obj=session.load(Product.class, 105);
	 //  Object obj=session.get(Product.class, 102);
	   //Object obj=session.get(Product.class, 105);
	   Product product=(Product)obj;
	   
	   if(product!=null)
	   { 
	   System.out.println(product.getId());
	   System.out.println(product.getCategory());
	   System.out.println(product.getName());
	   System.out.println(product.getDescription());
	   System.out.println(product.getPrice());
	   System.out.println(product.getManufactureddate());
	   System.out.println(product.isExpiry());
	   }
	   else
	   {
		   System.out.println("Product Object Not Found");
	   }
	 
	   session.close(); //detached state
	   sessionFactory.close();
   }
   public void deleteProduct()
   {
	   Configuration configuration = new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory = configuration.buildSessionFactory();
	   Session session = sessionFactory.openSession(); 
	  
	   
	   Transaction transaction = session.beginTransaction();
	   
	  
	   Object obj = session.load(Product.class,101);
	   //Object obj = session.load(Product.class,110);
	  // Object obj = session.get(Product.class,102);
	   //Object obj = session.get(Product.class,100);
	   Product product = (Product)obj;
	   
	   if(product!=null)
	   {
	   session.delete(product);
	   System.out.println("Product Object Deleted Successfully");
	   }	   
	   else
	   {
		   System.out.println("Product Object Not Found to Delete");
	   }
	   transaction.commit(); // which will save the results into database
	   
	   
	   
	   session.close(); //detached state
	   sessionFactory.close();
   }
   public void updateProduct() //Actual Update Operation using load() or get() method
   {
	   Configuration configuration = new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory = configuration.buildSessionFactory();
	   Session session = sessionFactory.openSession(); 
	  
	   
	   Transaction transaction = session.beginTransaction();
	   
	  
	   Object obj = session.load(Product.class, 103);
	   Product product = (Product)obj;
	   
	   product.setCategory("HeavySeewt");
	   product.setPrice(105.49);
	   product.setExpiry(true);
	   
	   
	   transaction.commit(); // which will save the results into database
	   
	   System.out.println("Product Object Updated Successfully");
	   
	   session.close(); //detached state
	   sessionFactory.close();
   }
   public void updateProductRecord() //using update() method
   {
	   Configuration configuration = new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory = configuration.buildSessionFactory();
	   Session session = sessionFactory.openSession(); 
	  
	   
	   Transaction transaction = session.beginTransaction();
	   
	   // if you don't set values for all properties then NULL will taken for properties. 
	   // That means if you want update using this way, you need to update values for all properties.
	
	  
	   Product product = new Product();
	   product.setId(103); // This id must be there in the table
	   product.setName("Brinjal");
	   product.setManufactureddate("25/10/1993");
	   product.setExpiry(false);
	   
	   session.update(product);
	   
	   transaction.commit(); // which will save the results into database
	   
	   System.out.println("Product Object Updated Successfully");
	   
	   session.close(); //detached state
	   sessionFactory.close();
   }
   public void saveorupdateProduct()
   {
	   Configuration configuration = new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory = configuration.buildSessionFactory();
	   Session session = sessionFactory.openSession(); 
	  
	   
	   Transaction transaction = session.beginTransaction();
	   
	   //if id is there, values will be updated for ID row otherwise new record will be inserted
	  
	   Product product = new Product();
	   product.setId(102); // This id must be there in the table
	   product.setName("Brinjal");
	   product.setExpiry(true);
	   
	   session.saveOrUpdate(product);
	   
	   transaction.commit(); // which will save the results into database
	   
	   System.out.println("Product Object Updated Successfully");
	   
	   session.close(); //detached state
	   sessionFactory.close();
   }
}
