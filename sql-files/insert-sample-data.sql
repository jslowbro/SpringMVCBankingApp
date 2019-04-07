DELETE FROM client where id < 100000;
INSERT INTO `client` VALUES 
	(1,'John','Malkovich','john.malkov@mail.com','John', 1000),
	(2,'Nicholas','Copernicus','nicki@mail.com','Nicholas', 100),
	(3,'Lord','Haart','haart.h3@mail.com','Lord', 480000),
	(4,'Bilbo','Baggins','shire@mail.com','Bilbo', 2600),
	(5,'Nicholas','Cage','cagecagecage@mail.com','Nicholas', 30000),
    (6,'Zbigniew','Stonoga','gazetastonoga@mail.com','Zbigniew', 1500),
	(7,'Jurand','ze Spychowa','spychow@mail.com','Jurand', 6666),
	(8,'Jan','Chabik','janchabik@mail.com','Jan', 50000);
DELETE FROM transfer where id < 100000;
INSERT INTO `transfer` VALUES 
	(1, 500, NOW() ,1,2),
    (2, 400, NOW() ,1,4),
    (3, 231, NOW() ,1,5),
    (4, 3211, NOW() ,2,6),
    (5, 5400, NOW() ,4,1),
    (6, 5020, NOW() ,8,5),
    (7, 5982, NOW() ,5,3),
    (8, 523, NOW() ,7,6),
    (9, 566, NOW() ,3,4),
    (10, 600, NOW() ,6,5),
    (11, 233, NOW() ,8,4),
    (12, 100, NOW() ,6,8),
    (13, 50038, NOW() ,5,4),
    (14, 7589, NOW() ,3,7);
	

