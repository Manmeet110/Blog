# Tables Y Inserts

CREATE TABLE Author (
	id INTEGER PRIMARY KEY,
	name VARCHAR(255),
	email VARCHAR(255),
	password VARCHAR(255)
);

CREATE TABLE Post (
	id INTEGER PRIMARY KEY,
	title VARCHAR(255),
	description TEXT,
	date DATE,
	author_id INTEGER,
	FOREIGN KEY (author_id) REFERENCES Author(id)
);

CREATE TABLE Tag (
	id INTEGER PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE Post_Tag (
	post_id INTEGER,
	tag_id INTEGER,
	PRIMARY KEY (post_id, tag_id),
	FOREIGN KEY (post_id) REFERENCES Post(id),
	FOREIGN KEY (tag_id) REFERENCES Tag(id)
);
   
CREATE TABLE Comment (
	id INTEGER PRIMARY KEY,
	name VARCHAR(255),
	email VARCHAR(255),
	text TEXT,
	post_id INTEGER,
	FOREIGN KEY (post_id) REFERENCES Post(id)
);

INSERT INTO Author (id, name, email, password)
VALUES 
  (1, 'John Doe', 'john@example.com', 'password123'),
  (2, 'Jane Smith', 'jane@example.com', 'qwerty'),
  (3, 'Alice Johnson', 'alice@example.com', 'abc123');

  INSERT INTO Post (id, title, description, date, author_id)
VALUES 
  (1, 'First Post', 'This is the first post.', '2024-04-05', 1),
  (2, 'Second Post', 'This is the second post.', '2024-04-06', 2),
  (3, 'Another Post', 'This is another post.', '2024-04-07', 3);

  INSERT INTO Tag (id, name)
VALUES 
  (1, 'Technology'),
  (2, 'Science'),
  (3, 'Programming');

  INSERT INTO Post_Tag (post_id, tag_id)
VALUES 
  (1, 1), First Post is tagged with Technology
  (1, 3), First Post is also tagged with Programming
  (2, 2), Second Post is tagged with Science
  (3, 1), Another Post is tagged with Technology
  (3, 3); Another Post is also tagged with Programming

  INSERT INTO Comment (id, name, email, text, post_id)
VALUES 
  (1, 'Alice', 'alice@example.com', 'Great post!', 1),
  (2, 'Bob', 'bob@example.com', 'Interesting read.', 2),
  (3, 'Charlie', 'charlie@example.com', 'Well explained.', 2),
  (4, 'David', 'david@example.com', 'Looking forward to more.', 3);

  
