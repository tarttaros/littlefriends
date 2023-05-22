insert into type_pet(id_type_pet,descripcion) values (1,"perro");
insert into type_pet(id_type_pet,descripcion) values (2,"gato");

insert into veterinary(id_veterinary,date_creation,email,identification,name,password,phone_number,photo_url,sex,num_license) values (1,"2023/5/20","andres@gmail.com","1905541001","Andres carrillo","147851","3138545796","imagen1",1,"444141414");
insert into veterinary(id_veterinary,date_creation,email,identification,name,password,phone_number,photo_url,sex,num_license) values (2,"2023/6/21","maria@gmail.com","19158410521","maria uribe","202041","3188545796","imagen2",2,"1414541414");
insert into veterinary(id_veterinary,date_creation,email,identification,name,password,phone_number,photo_url,sex,num_license) values (3,"2023/5/15","carlos@gmail.com","1816841781","carlos velez","45101","313874414","imagen3",1,"4488441414");


insert into pet(id_pet,birthdate,name,sex,status,id_type_pet,id_user) values (1,"2020/5/9","pepito",1,1,1,1);
insert into pet(id_pet,birthdate,name,sex,status,id_type_pet,id_user) values (2,"2019/4/10","luna",2,1,1,2);
insert into pet(id_pet,birthdate,name,sex,status,id_type_pet,id_user) values (3,"2018/1/21","nana",2,1,1,2);


insert into veterinary_care(id_veterinary_care,message,id_pet,id_veterinary)  values (1,"se le realizo una radiografia",1,1);
insert into veterinary_care(id_veterinary_care,message,id_pet,id_veterinary)  values (2,"se vacuno por segunda vez",3,2);
insert into veterinary_care(id_veterinary_care,message,id_pet,id_veterinary)  values (3,"operacion",2,3);