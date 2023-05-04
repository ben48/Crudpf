package org.dao.report;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import org.modelo.report.Report;

public class DaoReport implements Serializable{
	
	//INSERTAR
		public void addReport(Report report) {
			
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.getCurrentSession();
			
			try {
				session.beginTransaction();
				session.save(report);
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Exception:" + e.getMessage());
			}
			
		}

		

		//ACTUALIZAR
			public void updateReport(Report report) {
				
				AnnotationConfiguration cfg = new AnnotationConfiguration();
				cfg.configure("hibernate.cfg.xml");
				SessionFactory factory = cfg.buildSessionFactory();
				Session session = factory.getCurrentSession();
				
				try {
					session.beginTransaction();
					session.update(report);
					session.getTransaction().commit();
				} catch (Exception e) {
					System.out.println("Exception:" + e.getMessage());
				}
				
			}
		
			

			//ELIMINAR
			public void deleteReport(Report report) {
				
				AnnotationConfiguration cfg = new AnnotationConfiguration();
				cfg.configure("hibernate.cfg.xml");
				SessionFactory factory = cfg.buildSessionFactory();
				Session session = factory.getCurrentSession();
				
				try {
					session.beginTransaction();
					session.delete(report);
					session.getTransaction().commit();
				} catch (Exception e) {
					System.out.println("Exception:" + e.getMessage());
				}
				
			}
			
			
			//LISTAR PERSONAS
			@SuppressWarnings("unchecked")
			public List<Report> ListReport() {

				AnnotationConfiguration cfg = new AnnotationConfiguration();
				cfg.configure("hibernate.cfg.xml");
				SessionFactory factory = cfg.buildSessionFactory();
				Session session = factory.getCurrentSession();
				List<Report> list=null;
				try {
					session.beginTransaction();
					list =(List<Report>) session.createQuery("from Report").list();
					session.getTransaction().commit();
				} catch (Exception e) {
					System.out.println("Exception:" + e.getMessage());
				}
				return list;
			}
			
}
