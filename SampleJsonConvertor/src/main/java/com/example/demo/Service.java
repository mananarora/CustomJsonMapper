package com.example.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Service {

	List<Team> getTeamDetails()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Team.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Query q=session.createQuery("from Team" );
		List<Team> list = q.getResultList();
		return list;
	}
	
	List<Associate> getAssociateDetails()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Team.class)
				.addAnnotatedClass(Associate.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Query q=session.createQuery("from Associate" );
		List<Associate> list = q.getResultList();
		return list;
	}
	
	List<Star> getStarDetails()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Team.class)
				.addAnnotatedClass(Associate.class).addAnnotatedClass(Star.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		String teamId = "CM0593";
		Query q = session.createQuery("from Star s where s.assignedTo.team.team_id=:teamId")
				.setParameter("teamId", teamId);
		List<Star> list = q.getResultList();
		return list;
	}
}
