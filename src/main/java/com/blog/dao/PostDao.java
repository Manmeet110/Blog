package com.blog.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.blog.entity.Post;

public class PostDao {

	private SessionFactory factory = null;

	private Session session = null;

	private Transaction tx = null;

	public PostDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public void savePost(Post p) {
		session = factory.openSession();
		tx = session.beginTransaction();
		session.save(p);
		tx.commit();
	}

	public Post getPostById(int id) {
		session = factory.openSession();
		Post p = session.get(Post.class, id);
		return p;
	}

	public List<Post> getAllPost() {
		ArrayList<Post> list = new ArrayList<Post>();
		session = factory.openSession();
		Query<Post> qu = session.createQuery("from Post");

		qu.list().forEach((e) -> list.add(e));
		return list;
	}

	public void updatePost(Post p) {
		System.out.println(p);
		session = factory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(p);
		tx.commit();
	}

	public void deletePost(Post p) {
		session = factory.openSession();
		tx = session.beginTransaction();
		session.delete(p);
		tx.commit();
		session.close();
	}

}
