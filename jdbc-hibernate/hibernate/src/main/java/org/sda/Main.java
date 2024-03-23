package org.sda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sda.entities.Person;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            // Database operations
            try {
                System.out.println("Success");
                Person person = new Person("John", "Doe");
                session.save(person);
                Person person2 = new Person("John2", "Doe2");
                session.save(person2);

            }catch (Exception ex){
                System.out.println(ex);
            }
            transaction.commit();
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
