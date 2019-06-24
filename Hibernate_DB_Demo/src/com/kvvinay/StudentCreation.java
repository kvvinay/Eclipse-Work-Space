package com.kvvinay;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class StudentCreation {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure()
                                                    .addAnnotatedClass(Student.class)
                                                    .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("venky","G","venky@gmail.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
