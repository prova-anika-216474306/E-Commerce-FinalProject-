#CUSTOMER DATA 
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `location` varchar(100) NOT NULL

);

INSERT INTO customer ( `id`,`name`,`email`,`password`,`location`) VALUES 
(1, 'Christy', 'cy@gmail.com', 'cc', 'Downsview'),
(2, 'Chris', 'cs@gmail.com', 'cc', 'Finch West'),
(3, 'Caroline', 'ce@gmail.com', 'cc', 'Vaughan'),
(4, 'Carol', 'cl@gmail.com', 'cc', 'YorkVille Street'),
(5, 'Caren', 'cn@gmail.com', 'cc', 'Shepperd West'),
(6, 'Candel', 'clll@gmail.com', 'cc', 'Downsview'),
(7, 'Candace', 'cee@gmail.com', 'cc', 'High Park'),
(8, 'Celinda', 'ca@gmail.com', 'cc', 'York University'),
(9, 'Collie', 'ceee@gmail.com', 'cc', 'Museum Road'),
(10, 'Cecilee', 'clee@gmail.com', 'cc', 'College Street');

#ITEM DATA
CREATE TABLE IF NOT EXISTS `item` (
    `id` INT(10),
    `name` VARCHAR(100),
    `category` VARCHAR(100),
    `price`INT(10),
    `quantity` INT(10),
	`description` VARCHAR(100)
   
);

INSERT INTO item ( `id`,`name`,`category`,`price`,`quantity`, `description`) VALUES 
(11, 'Apple', 'Produce', 5, 100, 'Fresh Fruits'),
(22, 'Banana', 'Produce', 2, 100, 'Fresh Fruits'),
(33, 'Brocoli', 'Produce', 8, 100, 'Fresh Vegetables'),
(44, 'Roma Tomatoes', 'Produce', 6, 100, 'Fresh Vegetables'),
(55, 'Lettuce', 'Produce', 9, 100, 'Organic Vegetables'),
(66, 'Toothbrush', 'Hyegine', 10, 100, 'Oral Hyegine'),
(667, 'Shower Gel', 'Hyegine', 10, 100, 'Fragrant Moisturizing'),
(77, 'Iphone Charger', 'Electronics', 25, 100, 'Iphone 12 Charger'),
(88, 'Airpods', 'Electronics', 250, 100, 'Airpod Pro'),
(909, 'Airpods', 'Electronics', 250, 100, 'Airpod Pro'),
(110, 'Tylenol', 'Medicine', 10, 100, 'Tylenol 100 tablets'),
(111, 'Pepto Bismol', 'Medicine', 10, 100, 'Better Digestion');


#MANAGER DATA
CREATE TABLE IF NOT EXISTS `manager` (
  
  `id` int(5) NOT NULL,
  `name` varchar(100) ,
  `email` varchar(100) ,
  `password` varchar(100) ,
 `location` varchar(200) ,
`shop` varchar(100) ,
  
  PRIMARY KEY (`id`)
);

INSERT INTO manager ( `id`,`name`,`email`,`password`,`location`, `shop`) VALUES 
(1, 'Megan', 'mn@gmail.com', 'cc', 'Downsview', 'ShopDD'),
(2, 'Mehreen', 'mnn@gmail.com', 'cc', 'Finch West', 'Shop Fine'),
(3, 'Mike', 'me@gmail.com', 'cc', 'Vaughan', 'Value Store'),
(44, 'Mila', 'maa@gmail.com', 'cc', 'YorkVille Street', 'XYZ Enterprise'),
(5, 'Mento', 'mo@gmail.com', 'cc', 'Shepperd West', 'North Point Store'),
(6, 'Mariam', 'mm@gmail.com', 'cc', 'Union Station', 'ShopUU '),
(7, 'Megna', 'mam@gmail.com', 'cc', 'High Park', 'ParkG Store'),
(8, 'Monty', 'my@gmail.com', 'cc', 'York University', 'Shoppers Hub'),
(9, 'Mika', 'mka@gmail.com', 'cc', 'Museum Road', 'Store M'),
(10, 'Miron', 'mrn@gmail.com', 'cc', 'College Street', 'College Store');

#STORE DATA
CREATE TABLE IF NOT EXISTS `store` (
  `name` varchar(100),
  `opening` varchar(100),
  `closing` varchar(100),
  `location` varchar(100)
);

INSERT INTO store (`name`,`opening`,`closing`,`location`) VALUES 
('ShopDD', '8 AM', '11 PM', 'Downsview'),
('Shop Fine', '8 AM', '11 PM', 'Finch West'),
('Value Store', '8 AM', '11 PM', 'Vaughan'),
('XYZ Enterprise', '8 AM', '11 PM', 'YorkVille Street'),
('North Point Store', '8 AM', '11 PM', 'Shepperd West'),
('ShopUU ', '8 AM', '11 PM','Union Station'),
('ParkG Store', '8 AM', '11 PM', 'High Park'),
('Shoppers Hub', '8 AM', '11 PM', 'York University'),
('Store M', '8 AM', '11 PM','Museum Road'),
('College Store','8 AM', '11 PM', 'College Street');
