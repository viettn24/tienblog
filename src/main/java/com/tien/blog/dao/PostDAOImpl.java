package com.tien.blog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tien.blog.entity.Post;

@Repository
public class PostDAOImpl implements PostDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Post> getPost() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Post> list = session.createQuery("FROM Post P ORDER BY P.id DESC", Post.class);
		
		list.setFirstResult(1);
		list.setMaxResults(3);
		
		List<Post> theResultPost = list.getResultList();

		return theResultPost;
	}
	
	
	@Override
	@Transactional
	public List<Post> getPostAdmin() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Post> list = session.createQuery("FROM Post", Post.class);

		
		List<Post> theResultPost = list.getResultList();

		return theResultPost;
	}

	@Override
	@Transactional
	public void savePost(Post thePost) {

		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(thePost);
		
	}

	@Override
	@Transactional
	public Post updatePost(int theId) {

		Session session = sessionFactory.getCurrentSession();
		
		Post newPost = session.get(Post.class,theId);
		
		return newPost;
	}

	@Override
	@Transactional
	public void deletePost(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
				
		Query<Post> theQuery = session.createQuery("delete from Post where id=:thePostId");
			theQuery.setParameter("thePostId", theId);
			
		theQuery.executeUpdate();
			
		
		
	}

	@Override
	@Transactional
	public List<Post> searchPost(String theSearch) {
		Session session = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		if(theSearch !=null && theSearch.trim().length() > 0) {
			theQuery = session.createQuery("from Post where lower(tittle) like :theSearch or lower(body) like :theSearch", Post.class);
			theQuery.setParameter("theSearch", "%" + theSearch.toLowerCase() + "%");
		}
		else {
			theQuery = session.createQuery("from Post", Post.class); 
		}
		List<Post> posts = theQuery.getResultList();
		
		
		return posts;
	}
	
	
	
	
	
	
	
	
	
	
	

}
