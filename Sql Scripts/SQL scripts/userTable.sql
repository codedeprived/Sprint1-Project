create database mydatabase;
use mydatabase;

create table tbl_user(
user_id int primary key auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
email varchar(60) unique not null,
password varchar(50) unique not null
);

create table tbl_food (
food_id int primary key auto_increment,
food_name varchar(60) unique not null,
price decimal(10,2) not null,
f_info varchar(300) 
);

create table tbl_cart (
cart_id int primary key auto_increment,
user_id int not null,
created_at timestamp default current_timestamp ,
last_update timestamp default current_timestamp on update current_timestamp,
foreign key(user_id) references tbl_user(user_id)
);
 
 create table cart_items (
 cart_item_id int auto_increment primary key,
 cart_id int not null,
 food_id int not null,
 quantity int not null ,
 price decimal(10,2) not null,
 last_updated timeStamp default current_timestamp on update current_timestamp,
 foreign key(cart_id) references tbl_cart(cart_id),
 foreign key(food_id) references tbl_food(food_id)
 );
 
 create table tbl_order(
 order_id int primary key auto_increment,
 user_id int not null,
 cart_id int not null,
 order_date timestamp default current_timestamp,
 total_price decimal(16,2),
 quantity int,
 foreign key( user_id) references tbl_user(user_id),
 foreign key(cart_id) references tbl_cart(cart_id)
 );
 

