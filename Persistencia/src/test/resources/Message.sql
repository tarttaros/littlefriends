insert into user(id_user,date_creation,email,identification,name,password,phone_number,photo_url,sex) values (1,"2023/5/15","angela@gmail.com","115170980","angela marin","55500","318814414","imagen1",2);
insert into user(id_user,date_creation,email,identification,name,password,phone_number,photo_url,sex) values (2,"2023/1/12","pedro@gmail.com","160890980","pedro antonio","55500","318814414","imagen1",1);
insert into user(id_user,date_creation,email,identification,name,password,phone_number,photo_url,sex) values (3,"2023/5/15","jesica@gmail.com","119168980","jesica robledo","18962400","318811114","imagen1",2);

insert into veterinary (id_veterinary,email,identification,name,password,phone_number,photo_url,sex,num_license) values (1,"maria@gmail.com","1915841052","maria uribe","202041","3188545796","imagen2",2,"1414541414");
insert into veterinary (id_veterinary,email,identification,name,password,phone_number,photo_url,sex,num_license) values (2,"carlos@gmail.com","1816841781","carlos velez","45101","313874414","imagen3",1,"4488441414");

insert into chat (id_chat,id_user,id_veterinary) values (1,1,1);
insert into chat (id_chat,id_user,id_veterinary) values (2,2,2);

insert into message (id_message,date,content,id_chat) values (1,"2023/5/21","holi",1);
insert into message (id_message,date,content,id_chat) values (2,"2023/2/20","buenas",1);
insert into message (id_message,date,content,id_chat) values (3,"2023/12/25","buenas tardes",2);