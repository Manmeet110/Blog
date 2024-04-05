package com.blog.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.blog.entity.Comment;
import com.blog.entity.Post;

public class CommentDao {
	private SessionFactory factory;

	private Session session;

	private Transaction tx;

	public CommentDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public void saveComment(Comment au) {
		session = factory.openSession();
		tx = session.beginTransaction();
		session.save(au);
		tx.commit();
	}

	public Comment getCommentById(int id) {
		session = factory.openSession();
		Comment comm = session.get(Comment.class, id);
		return comm;
	}

	public List<Comment> getAllComment() {
		ArrayList<Comment> list = new ArrayList<Comment>();
		session = factory.openSession();
		Query<Comment> qu = session.createQuery("from Comment");

		qu.list().forEach((e) -> list.add(e));
		return list;
	}

	public void updateComment(Comment comm) {
		session = factory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(comm);
		tx.commit();
	}

	public void deleteComment(Comment comm) {
		session = factory.openSession();
		tx = session.beginTransaction();
		session.delete(comm);
		tx.commit();
	}
}
