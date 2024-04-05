package com.blog.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.blog.entity.Post;
import com.blog.entity.Tag;

public class TagDao {
	private SessionFactory factory;

	private Session session;

	private Transaction tx;

	public TagDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public void saveTag(Tag tg) {
		session = factory.openSession();
		tx = session.beginTransaction();
		session.save(tg);
		tx.commit();
	}

	public Tag getTagById(int id) {
		session = factory.openSession();
		Tag tag = session.get(Tag.class, id);
		return tag;
	}

	public List<Tag> getAllTag() {
		ArrayList<Tag> list = new ArrayList<Tag>();
		session = factory.openSession();
		Query<Tag> qu = session.createQuery("from Tag");

		qu.list().forEach((e) -> list.add(e));
		return list;
	}

	public void updateTag(Tag tag) {
		session = factory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(tag);
		tx.commit();
	}

	public void deleteTag(Tag t) {
		session = factory.openSession();
		tx = session.beginTransaction();
		session.delete(t);
		tx.commit();
	}
}
