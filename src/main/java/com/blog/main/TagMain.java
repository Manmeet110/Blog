package com.blog.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blog.dao.PostDao;
import com.blog.dao.TagDao;
import com.blog.entity.Post;
import com.blog.entity.Tag;

public class TagMain {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("com/blog/conn/hibernate.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Boolean f = true;

		TagDao dao = new TagDao(factory);

		Tag tg = new Tag();

		PostDao pdao = new PostDao(factory);
		Post po = new Post();

		while (f) {

			Scanner sc = new Scanner(System.in);
			System.out.println("------------------------------------------------");
			System.out.println("1. Add Tag");
			System.out.println("2. view All Tag");
			System.out.println("3. view Tag By Id");
			System.out.println("4. Edit Tag");
			System.out.println("5. Delete Tag");
			System.out.println("6. Exit");
			System.out.println("------------------------------------------------");
			System.out.println("Enter Number");

			int i = sc.nextInt();
			int id;
			String name;
			switch (i) {
			case 1:

				System.out.println("Enter Post Id ");
				id = sc.nextInt();

				po = pdao.getPostById(id);
				if (po != null) {

					System.out.println("Enter Tag Name");
					name = sc.next();
					tg.setName(name);
					tg.setPost(po);

					dao.saveTag(tg);
					System.out.println("Saved Sucess");
				}
				break;
			case 2:
				List<Tag> list = dao.getAllTag();
				list.forEach((e) -> System.out.println(e));
				break;
			case 3:
				System.out.println("Enter Tag ID");
				id = sc.nextInt();
				tg = dao.getTagById(id);
				if (tg != null) {
					System.out.println(tg);
				} else {
					System.out.println("Invalid Tag");
				}

				break;
			case 4:

				System.out.println("Enter Tag ID");
				id = sc.nextInt();
				System.out.println("Enter Tag Name");
				name = sc.next();
				tg.setId(id);

				tg = dao.getTagById(id);

				if (tg != null) {
					tg.setName(name);
					dao.updateTag(tg);
					System.out.println("Update Success");
				} else {
					System.out.println("Invalid Tag");
				}

				break;
			case 5:
				System.out.println("Enter Tag ID");
				id = sc.nextInt();
				tg = dao.getTagById(id);
				if (tg != null) {
					dao.deleteTag(tg);
					System.out.println("Delete Success");
				} else {
					System.out.println("Invalid Tag");
				}

				break;
			default:
				f = false;
				System.out.println("Thank u");
				break;
			}

		}
	}
}
