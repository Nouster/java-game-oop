DROP DATABASE IF EXISTS correction_tp1;
CREATE DATABASE  correction_tp1;

use  correction_tp1;

CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(255) NOT NULL,
  created DATETIME DEFAULT NOW(),
  PRIMARY KEY (id),
  UNIQUE (email)
);

CREATE TABLE article (
    id INT NOT NULL  AUTO_INCREMENT,
    user_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    created DATETIME DEFAULT NOW(),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE comment (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  article_id INT NOT NULL,
  content TEXT NOT NULL ,
  created DATETIME DEFAULT NOW(),
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (article_id) REFERENCES article(id)
);


INSERT INTO user (name, email)
    VALUES
        ('Paulette', 'p@toto.fr'),
        ('Joe', 'joe@dalton.us'),
        ('jean', 'jean@jean.jean');

INSERT INTO article (user_id, title, content)
    VALUES
        (1, 'Le sport c\'est bien ... ', 'LOL'),
        (2, 'Pas cool la prison ...', 'aie ....');

INSERT INTO comment (article_id, user_id, content)
    VALUES
        (2, 3, 'sans déconner ...'),
        (1,2, 'je creuse ... '),
        (1, 1, 'T\'as pas fini !');