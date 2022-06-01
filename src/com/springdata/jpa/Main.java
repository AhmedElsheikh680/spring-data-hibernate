package com.springdata.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdata.jpa.model.Client;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Client.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.createQuery("delete from Client where fullName='Samy Ali' ")
			.executeUpdate();
			
			session.getTransaction().commit();
		} catch(Exception e) {
			System.out.println(e.toString());
		} finally {
			session.close();
		}
		
	}

}


//String url = "jdbc:mysql://localhost:3306/employee?useSSL=false";
//String username = "root";
//String password = "12345";
//




//try {
//	Connection connection = DriverManager.getConnection(url, username, password);
//	System.out.println("Connected Successfullt!!");
//	System.out.println(connection);
//}catch(Exception e) {
//	System.out.println(e.toString());
//}


//Save Client
//Client client = new Client("Ayman Ali", 28, "Tanta");
//Client client2 = new Client("Ramy Hela", 28, "Tanta");
//Client client3 = new Client("Samy Ali", 28, "Tanta");
//Client client4 = new Client("Hassan Ali", 28, "Tanta");
//session.save(client);
//session.save(client2);
//session.save(client3);
//session.save(client4);


//get and update
//Client client = session.get(Client.class, id);
//client.setFullName("Updated");
//client.setAge(50);
//client.setCountry("Updated");


//update object
//Client client = new Client("Kamal Updated", 50, "Mansoura Updated");
//client.setId((long)1);
//session.update(client);


//delete client
//Client client = new Client();
//client.setId((long)2);
//session.delete(client);

//session.createQuery("update Client set fullName='AhmedAA' where id=1 ")
//.executeUpdate();


































