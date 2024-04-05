package com.blog.main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blog.dao.PostDao;
import com.blog.entity.Author;
import com.blog.entity.Post;
import com.blog.entity.Tag;

public class PostMain {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("com/blog/conn/hibernate.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Boolean f = true;

		PostDao pdao = new PostDao(factory);

		Post po = new Post();
		Author au = new Author();
		Tag tg = new Tag();

		while (f) {

			Scanner sc = new Scanner(System.in);
			System.out.println("------------------------------------------------");
			System.out.println("1. Add Post");
			System.out.println("2. view All Post");
			System.out.println("3. view Post By Id");
			System.out.println("4. Edit Post");
			System.out.println("5. Delete Post");
			System.out.println("6. Exit");
			System.out.println("------------------------------------------------");
			System.out.println("Enter Number");

			int i = sc.nextInt();
			int id;
			String title, desc;

			switch (i) {
			case 1:
				System.out.println("Enter Title ");
				title = sc.next();
				System.out.println("Enter description ");
				desc = sc.next();

				po.setTitle(title);
				po.setDescription(desc);

				po.setDate(LocalDate.now());
				pdao.savePost(po);
				System.out.println("Saved Sucess");
				break;
			case 2:
				List<Post> list = pdao.getAllPost();
				list.forEach((e) -> System.out.println(e));
				break;
			case 3:

				System.out.println("Enter Post Id ");
				id = sc.nextInt();

				po = pdao.getPostById(id);
				if (po != null) {
					System.out.println(po);
				} else {
					System.out.println("invalid post id");
				}

				break;
			case 4:

				System.out.println("Enter Post Id ");
				id = sc.nextInt();

				po = pdao.getPostById(id);
				if (po != null) {
					Post pos = new Post();
					System.out.println("Enter Title ");
					title = sc.next();
					System.out.println("Enter description ");
					desc = sc.next();

					pos.setTitle(title);
					pos.setDescription(desc);
					pos.setId(id);
					pos.setDate(LocalDate.now());
					pdao.updatePost(pos);
					System.out.println("Update Sucess");

				} else {
					System.out.println("invalid post id");
				}

				break;
			case 5:

				System.out.println("Enter Post Id ");
				id = sc.nextInt();

				po = pdao.getPostById(id);
				if (po != null) {
					pdao.deletePost(po);
					System.out.println("Delete Sucess");
				} else {
					System.out.println("invalid post id");
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
