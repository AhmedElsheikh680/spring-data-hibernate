package com.springdata.jpa;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.springdata.jpa.model.Client;
import com.springdata.jpa.model.Data;
import com.springdata.jpa.model.Info;
import com.springdata.jpa.model.Person;
import com.springdata.jpa.model.Student;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Info.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			int id=3;
			Student student = new Student();
			student = session.get(Student.class, id);
			student.setName("Samy");
			student.getInfos().get(0).setPhone("01000");
			student.getInfos().get(1).setPhone("012000");
			
			session.update(student);
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

//session.createQuery("delete from Client where fullName='Samy Ali' ")
//.executeUpdate();

//List<Client> clients = session.createQuery("from Client").list();
//for(int i=0; i<clients.size(); i++) {
//	System.out.println("FullName: "+ clients.get(i).getFullName());
//}

//Query query = session.createQuery("from Client");
//query.setFirstResult(0);
//query.setMaxResults(3);
//List<Client> clients = query.list();
//for(int i=0; i<clients.size(); i++) {
//	System.out.println(clients.get(i).getFullName());
//}


//Query query = session.createQuery("from Client where id=?1 and fullName=?2");
//query.setInteger(1, id);
//query.setString(2, "AhmedAA");
//List<Client> clients = query.list();
//for(int i=0; i<clients.size(); i++) {
//	System.out.println(clients.get(i).getAge());
//}

//Query query = session.createQuery("from Client where id=:v1 and fullName=:v2");
//query.setInteger("v1", id);
//query.setString("v2", "AhmedAA");
//List<Client> clients = query.list();
//for(int i=0; i<clients.size(); i++) {
//	System.out.println(clients.get(i).getAge());
//}

//Query query = session.createQuery("select Max(id) from Client");
//Query query2 = session.createQuery("select Min(id) from Client");
//Query query3 = session.createQuery("select sum(age) from Client");
//Query query4= session.createQuery("select avg(age) from Client");
//Query query5 = session.createQuery("select count(country) from Client");
//Query query6 = session.createQuery("select count(distinct country) from Client");
//
//System.out.println("Max: "+ query.list().get(0));
//System.out.println("Min: "+ query2.list().get(0));
//System.out.println("Sum: "+ query3.list().get(0));
//System.out.println("Average: "+ query4.list().get(0));
//System.out.println("Count: "+ query5.list().get(0));
//System.out.println("Count Distinct: "+ query6.list().get(0));

//Long[] ids = {(long)1,(long)2,(long)3};
//Criteria criteria = session.createCriteria(Client.class);
//criteria.setFirstResult(0);
//criteria.setMaxResults(3);
//criteria.add(Restrictions.gt("id", (long)3));
//criteria.add(Restrictions.le("id", (long)2));
//criteria.add(Restrictions.between("id", (long)1, (long)3));
//criteria.add(Restrictions.in("id", ids));
//criteria.add(Restrictions.isNotNull("country"));
//criteria.add(Restrictions.isEmpty("country"));
//criteria.add(Restrictions.eq("fullName", "AhmedAA"));
//criteria.add(Restrictions.like("fullName", "A", MatchMode.START));
//criteria.add(Restrictions.like("fullName", "i", MatchMode.END));
//Criterion criterion = Restrictions.eq("fullName", "AhmedAA");
//Criterion criterion2 = Restrictions.eq("country", "Cairo");
//LogicalExpression logicalExpression = Restrictions.or(criterion, criterion2);
//criteria.add(logicalExpression);
//List<Client> clients = criteria.list();
//for(int i=0; i<clients.size(); i++) {
//	System.out.println(clients.get(i).getFullName());
//}

//SessionFactory sessionFactory = new Configuration()
//.configure("hibernate.cfg.xml")
//.addAnnotatedClass(Client.class)
//.buildSessionFactory();
//Session session = sessionFactory.getCurrentSession();
//int id=1;
//try {
//session.beginTransaction();
//Criteria criteria = session.createCriteria(Client.class);
////criteria.setProjection(Projections.min("id"));
////criteria.setProjection(Projections.max("id"));
////criteria.setProjection(Projections.sum("id"));
////criteria.setProjection(Projections.avg("id"));
////criteria.setProjection(Projections.count("country"));
//criteria.setProjection(Projections.countDistinct("country"));
//List<Client> clients = criteria.list();
//System.out.println(clients.get(0));
//session.getTransaction().commit();
//} catch(Exception e) {
//System.out.println(e.toString());
//} finally {
//session.close();
//}

//OneTOone
//Person person = new Person();
//person.setName("Mohamed");
//session.save(person);
//Data data = new Data();
//data.setAge("28");
//data.setPerson(person);
//session.save(data);


//Student student = new Student();
//student.setName("Ahmed");
//
//Info info = new Info();
//info.setPhone("01271265897");
//
//Info info2 = new Info();
//info2.setPhone("01004254283");
//
//student.getInfos().add(info);
//student.getInfos().add(info2);
//
//info.setStudent(student);
//info2.setStudent(student);
//
//session.save(student);


//int id=3;
//Student student = new Student();
//student = session.get(Student.class, id);
//System.out.println(student.getName());
//for(Info i: student.getInfos()) {
//	System.out.println(i.getPhone());
//}
























































