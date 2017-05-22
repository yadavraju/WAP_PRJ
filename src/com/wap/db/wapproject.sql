/*
SQLyog Ultimate v11.24 (64 bit)
MySQL - 5.1.36-community : Database - wapproject
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wapproject` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `wapproject`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `cid` int(10) NOT NULL AUTO_INCREMENT,
  `postid` int(10) NOT NULL,
  `userid` int(10) NOT NULL,
  `comment` varchar(256) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `cid` (`cid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `comment` */

insert  into `comment`(`cid`,`postid`,`userid`,`comment`,`date`) values (1,1,1,'test','2017-05-20 22:02:17'),(2,2,2,'test','2017-05-20 22:11:24'),(3,9,9,'9eddeddwewedfd','2017-05-20 22:39:04'),(4,3,3,'3333','2017-05-21 10:43:40');

/*Table structure for table `postdata` */

DROP TABLE IF EXISTS `postdata`;

CREATE TABLE `postdata` (
  `pid` int(10) NOT NULL AUTO_INCREMENT,
  `product_you_offer` varchar(256) DEFAULT NULL,
  `describe_your_offer` varchar(256) DEFAULT NULL,
  `product_you_need` varchar(256) DEFAULT NULL,
  `describe_your_need` varchar(256) DEFAULT NULL,
  `like_count` int(32) DEFAULT NULL,
  `comment_count` int(32) DEFAULT NULL,
  `userid` int(10) DEFAULT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `pid` (`pid`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `postdata` */

insert  into `postdata`(`pid`,`product_you_offer`,`describe_your_offer`,`product_you_need`,`describe_your_need`,`like_count`,`comment_count`,`userid`,`date`) values (1,'1','1','1','1',1,1,1,'2017-05-20 17:49:21'),(2,'1','2','1','1',1,1,1,'2017-05-20 18:37:55'),(3,'3','2','3','4',6,5,7,'2017-05-20 18:41:18'),(4,'3','2','3','4',6,5,11,'2017-05-20 21:36:14');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `email` varchar(64) NOT NULL,
  `fname` varchar(64) NOT NULL,
  `lname` varchar(64) NOT NULL,
  `contactno` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `profileimage` varchar(256) NOT NULL,
  `address` varchar(64) NOT NULL,
  `gender` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`email`,`fname`,`lname`,`contactno`,`password`,`profileimage`,`address`,`gender`) values (1,'rajuyadav49@outlook.com','Raju','Yadav','N/a','123456','N/a','N/a','N/a'),(4,'yadav_raju@outlook.com','raju','yadav','N/a','1123133','N/a','N/a','N/a'),(3,'rajuyadav4@outlook.com','yadda','xvjdnv','N/a','1111','N/a','N/a','N/a'),(5,'yadav_raju@outlook.com','raju','yadav','N/a','1123133','N/a','N/a','N/a'),(6,'y@yahoo.com','y','y','N/a','123456','N/a','N/a','N/a'),(20,'1@123.com','1','1','N/a','1','N/a','N/a','N/a'),(19,'dd@dd.com','dd','dd','N/a','123456','N/a','N/a','N/a'),(18,'dd@dd.com','dd','dd','N/a','123456','N/a','N/a','N/a'),(17,'cc@cc.com','cc','cc','N/a','123456','N/a','N/a','N/a'),(16,'bb@bb.com','bb','bb','N/a','123456','N/a','N/a','N/a'),(15,'a@a.com','aa','aa','N/a','123456','N/a','N/a','N/a');

/*Table structure for table `userlike` */

DROP TABLE IF EXISTS `userlike`;

CREATE TABLE `userlike` (
  `lid` int(10) NOT NULL AUTO_INCREMENT,
  `postid` int(10) NOT NULL,
  `userid` int(10) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `lid` (`lid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `userlike` */

insert  into `userlike`(`lid`,`postid`,`userid`,`date`) values (1,1,1,'2017-05-20 22:17:03'),(2,1,1,'2017-05-20 22:19:22'),(3,2,2,'2017-05-20 22:19:59'),(4,9,9,'2017-05-20 22:38:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
