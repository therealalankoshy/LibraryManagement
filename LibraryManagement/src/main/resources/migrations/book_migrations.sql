CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `date_created` datetime DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `book_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `date_created` datetime DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `shelf` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `date_created` datetime DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `section_name` varchar(255) DEFAULT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `date_created` datetime DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `book_category_id` int(11) DEFAULT NULL,
  CONSTRAINT `book_category_mapping` FOREIGN KEY (`book_category_id`) REFERENCES `book_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `book_author` (
  `book_id` int(11) DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  CONSTRAINT `book_to_book_author` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `author_to_book_author` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `book_copy` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `date_created` datetime DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `shelf_id` int(11) DEFAULT NULL,
  CONSTRAINT `book_to_book_copy` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `shelf_to_book_copy` FOREIGN KEY (`shelf_id`) REFERENCES `shelf` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `copy_issue` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `date_created` datetime DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `book_copy_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `date_issued`  datetime DEFAULT NULL,
  `date_due`  datetime DEFAULT NULL,
  `return_date`  datetime DEFAULT NULL
	
  CONSTRAINT `book_copy_to_copy_issue` FOREIGN KEY (`book_copy_id`) REFERENCES `book_copy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
