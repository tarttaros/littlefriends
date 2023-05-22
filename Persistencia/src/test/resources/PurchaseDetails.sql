insert into user(id_user,date_creation,email,identification,name,password,phone_number,photo_url,sex) values (1,"2023/5/15","angela@gmail.com","115170980","angela marin","55500","318814414","imagen1",2);
insert into user(id_user,date_creation,email,identification,name,password,phone_number,photo_url,sex) values (2,"2023/1/12","pedro@gmail.com","160890980","pedro antonio","55500","318814414","imagen1",1);
insert into user(id_user,date_creation,email,identification,name,password,phone_number,photo_url,sex) values (3,"2023/5/15","jesica@gmail.com","119168980","jesica robledo","18962400","318811114","imagen1",2);

insert into purchase (id_purchase,date_purchase,payment_method,id_user) values (1,"2020/5/12","debito",1);
insert into purchase (id_purchase,date_purchase,payment_method,id_user) values (2,"2023/6/10","credito",3);
insert into purchase (id_purchase,date_purchase,payment_method,id_user) values (3,"2021/7/19","debito",2);
insert into purchase (id_purchase,date_purchase,payment_method,id_user) values (3,"2021/7/19","debito",2);

insert into product(id_product,description,name_product,price,quantity_product) values (1,"producto para el dolor","ibuprofeno",15000.0,40);
insert into product(id_product,description,name_product,price,quantity_product) values (2,"producto para la fiebre","acetaminofen",18000.0,30);
insert into product(id_product,description,name_product,price,quantity_product) values (3,"producto para el vomito","algo",70000.0,20);

insert into purchase_detail (id_purchase_detail ,price,units,id_product,id_purchase) values (1,15000.0,3,1,1);
insert into purchase_detail (id_purchase_detail ,price,units,id_product,id_purchase) values (2,19000.0,4,2,1);
insert into purchase_detail (id_purchase_detail ,price,units,id_product,id_purchase) values (3,24000.0,2,3,2);