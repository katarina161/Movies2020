/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 10.4.8-MariaDB : Database - movies
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`movies` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `movies`;

/*Table structure for table `genre` */

DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `genre` */

insert  into `genre`(`id`,`name`) values 
(1,'Action'),
(2,'Adventure'),
(3,'Animation'),
(4,'Biography'),
(5,'Comedy'),
(6,'Crime'),
(7,'Drama'),
(8,'Family'),
(9,'Fantasy'),
(10,'History'),
(11,'Horror'),
(12,'Mystery'),
(13,'Romance'),
(14,'Thriller'),
(15,'Sci-Fi'),
(16,'War');

/*Table structure for table `movie` */

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `year` int(10) unsigned NOT NULL,
  `duration` int(10) unsigned NOT NULL,
  `rating` double unsigned NOT NULL,
  `reviews` int(10) unsigned NOT NULL,
  `image` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `movie` */

insert  into `movie`(`id`,`title`,`year`,`duration`,`rating`,`reviews`,`image`) values 
(1,'The Dark Knight',2008,152,9,37,'theDarkKnight.jpg'),
(2,'Schindler\'s List',1993,195,8.9,80,'schindlersList.jpg'),
(3,'Pulp Fiction',1994,154,8.9,64,'pulpFiction.jpg'),
(4,'Forrest Gump',1994,142,8.8,113,'forestGump.jpg'),
(5,'Seven',1995,127,8.6,77,'seven.jpg'),
(6,'Spirited Away',2001,125,8.6,200,'spiritedAway.jpg'),
(7,'The Thing',1982,109,8.1,190,'theThing.jpg'),
(8,'Rope',1948,80,8,124,'rope.jpg'),
(9,'The Birds',1963,119,7.7,69,'theBirds.jpg'),
(10,'Inglourious Basterds',2009,153,8.3,200,'inglouriousBasterds.jpg'),
(11,'Good Will Hunting',1997,126,8.3,234,'goodWillHunting.jpg'),
(12,'It',2017,135,7.3,197,'it.jpg'),
(13,'Shutter Island',2010,138,8.2,124,'shutterIsland.jpg'),
(14,'The Sixth Sense',1999,107,8.1,213,'theSixthSense.jpg'),
(15,'The Terminator',1984,107,8,321,'theTerminator.jpg'),
(16,'Die Hard',1988,132,8.2,297,'dieHard.jpg'),
(17,'Up',2009,96,8.2,195,'up.jpg'),
(18,'The Matrix',1999,136,8.7,496,'theMatrix.jpg'),
(19,'Parasite',2019,132,8.6,314,'parasite.jpg'),
(20,'Interstellar',2014,169,8.6,216,'interstellar.jpg'),
(21,'Test',2020,60,0,0,NULL);

/*Table structure for table `movie_genre` */

DROP TABLE IF EXISTS `movie_genre`;

CREATE TABLE `movie_genre` (
  `movie_id` bigint(20) NOT NULL,
  `genre_id` bigint(20) NOT NULL,
  PRIMARY KEY (`movie_id`,`genre_id`),
  KEY `genre_id` (`genre_id`),
  CONSTRAINT `movie_genre_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`),
  CONSTRAINT `movie_genre_ibfk_2` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `movie_genre` */

insert  into `movie_genre`(`movie_id`,`genre_id`) values 
(1,1),
(1,6),
(1,7),
(2,4),
(2,7),
(2,10),
(3,6),
(3,7),
(4,7),
(4,13),
(5,6),
(5,7),
(5,12),
(6,2),
(6,3),
(6,8),
(7,11),
(7,12),
(7,15),
(8,6),
(8,7),
(8,12),
(9,7),
(9,11),
(9,12),
(10,2),
(10,7),
(10,16),
(11,7),
(11,13),
(12,11),
(13,12),
(13,14),
(14,7),
(14,12),
(14,14),
(15,1),
(15,15),
(16,1),
(16,14),
(17,2),
(17,3),
(17,5),
(18,1),
(18,15),
(19,5),
(19,7),
(19,14),
(20,2),
(20,7),
(20,15),
(21,1);

/*Table structure for table `review` */

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `user_id` bigint(20) unsigned NOT NULL,
  `movie_id` bigint(20) NOT NULL,
  `rating` double NOT NULL,
  PRIMARY KEY (`user_id`,`movie_id`),
  KEY `movie_user_fk2` (`movie_id`),
  CONSTRAINT `movie_user_fk1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `movie_user_fk2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `review` */

insert  into `review`(`user_id`,`movie_id`,`rating`) values 
(2,5,9),
(2,7,10);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `firstname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`firstname`,`lastname`,`gender`,`birthday`) values 
(2,'katarina96','Kaca1234.','Katarina','Novakovic','Female','22-08-1996'),
(6,'sava96','Sava1234.','Sava','Jeremic','Male','05-10-1996'),
(12,'test111','Test111.','Test','Test','Female','22-08-2020');

/*Table structure for table `watchlist` */

DROP TABLE IF EXISTS `watchlist`;

CREATE TABLE `watchlist` (
  `user_id` bigint(20) unsigned NOT NULL,
  `movie_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`movie_id`),
  KEY `movie_id` (`movie_id`),
  CONSTRAINT `watchlist_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `watchlist_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `watchlist` */

insert  into `watchlist`(`user_id`,`movie_id`) values 
(2,2),
(2,12);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
