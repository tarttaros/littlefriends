insert into user(id_user,date_creation,email,identification,name,password,phone_number,photo_url,sex) values (1,"2023/5/15","angela@gmail.com","115170980","angela marin","55500","318814414","imagen1",2);
insert into user(id_user,date_creation,email,identification,name,password,phone_number,photo_url,sex) values (2,"2023/1/12","pedro@gmail.com","160890980","pedro antonio","55500","318814414","imagen1",1);

insert into veterinary(id_veterinary,date_creation,email,identification,name,password,phone_number,photo_url,sex,num_license) values (1,"2023/5/20","andres@gmail.com","1905541001","Andres carrillo","147851","3138545796","imagen1",1,"444141414");
insert into veterinary(id_veterinary,date_creation,email,identification,name,password,phone_number,photo_url,sex,num_license) values (2,"2023/6/21","maria@gmail.com","1915841052","maria uribe","202041","3188545796","imagen2",2,"1414541414");
insert into veterinary(id_veterinary,date_creation,email,identification,name,password,phone_number,photo_url,sex,num_license) values (3,"2023/5/15","carlos@gmail.com","1816841781","carlos velez","45101","313874414","imagen3",1,"4488441414");

insert into pet(id_pet,birthdate,name,sex,status,type,id_user) values (1,"2020/5/9","pepito",1,0,0,1);
insert into pet(id_pet,birthdate,name,sex,status,type,id_user) values (2,"2019/4/10","luna",2,0,0,2);
insert into pet(id_pet,birthdate,name,sex,status,type,id_user) values (3,"2018/1/21","nana",2,0,0,2);

insert into veterinary_care(id_veterinary_care,message,id_pet,id_veterinary)  values (1,"se le realizo una radiografia",1,1);
insert into veterinary_care(id_veterinary_care,message,id_pet,id_veterinary)  values (2,"se vacuno por segunda vez",3,2);
insert into veterinary_care(id_veterinary_care,message,id_pet,id_veterinary)  values (3,"operacion",2,3);

insert into type_medical_consultation(id_type_consultation,description ) values (1,"de rutina");
insert into type_medical_consultation(id_type_consultation,description ) values (2,"prioritaria");

insert into consultation(id_consultation,date_consultation,end_consultation,start_consultation,status,id_pet,id_type_consultation,id_veterinary,id_veterinary_care ) values (1,"2020/5/9","13:40:15","10:40:15",1,1,2,1,1);
insert into consultation(id_consultation,date_consultation,end_consultation,start_consultation,status,id_pet,id_type_consultation,id_veterinary,id_veterinary_care ) values (2,"2020/5/9","10:45:15","09:45:15",1,3,2,3,3);
insert into consultation(id_consultation,date_consultation,end_consultation,start_consultation,status,id_pet,id_type_consultation,id_veterinary,id_veterinary_care ) values (3,"2020/5/9","16:10:15","17:10:15",2,2,1,2,2);