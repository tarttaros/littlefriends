insert into category(id_category,description) values (1,"Antialergico");
insert into category(id_category,description) values (2,"Antidepresivo");

insert into product(id_product,description,name_product,price,quantity_product) values (1,"producto para el dolor","ibuprofeno",15000.0,40);
insert into product(id_product,description,name_product,price,quantity_product) values (2,"producto para la fiebre","acetaminofen",18000.0,30);
insert into product(id_product,description,name_product,price,quantity_product) values (3,"producto para el vomito","algo",70000.0,20);

insert into product_category(id_product_category,id_category,id_product) values (1,1,2);
insert into product_category(id_product_category,id_category,id_product) values (2,2,1);
insert into product_category(id_product_category,id_category,id_product) values (3,1,2);