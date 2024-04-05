package com.blog.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.blog.entity.Author;
import com.blog.entity.Post;

public class AuthorDao {
	private SessionFactory factory;

	private Session session;

	private Transaction tx;

	public AuthorDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public void saveAuthor(Author au) {
		session = factory.openSession();
		tx = session.beginTransaction();
		session.save(au);
		tx.commit();
	}

	public Author getAuthorById(int id) {
		session = factory.openSession();
		Author au = session.get(Author.class, id);
		return au;
	}

	public List<Author> getAllAuthor() {
		ArrayList<Author> list = new ArrayList<Author>();
		session = factory.openSession();
		Query<Author> qu = session.createQuery("from Author");

		qu.list().forEach((e) -> list.add(e));
		return list;
	}

	public void updateAuthor(Author au) {
		session = factory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(au);
		tx.commit();
	}
	

	public void deleteAuthor(Author au) {
		session = factory.openSession();
		tx = session.beginTransaction();
		session.delete(au);
		tx.commit();
	}

}
