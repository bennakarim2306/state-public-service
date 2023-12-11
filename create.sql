create table address (id integer not null, postal_code integer, city varchar(255), country varchar(255), region varchar(255), street varchar(255), primary key (id)) engine=InnoDB;
create table address_seq (next_val bigint) engine=InnoDB;
insert into address_seq values ( 1 );
create table appointment (date_of_creation date, date_of_due date, id integer not null, citizen_id varchar(255), primary key (id)) engine=InnoDB;
create table appointment_seq (next_val bigint) engine=InnoDB;
insert into appointment_seq values ( 1 );
create table citizen (address_id integer not null, birth_date date, scope tinyint, dtype varchar(31) not null, email varchar(255), firstname varchar(255), id varchar(255) not null, image_base64 varbinary(255), middle_name varchar(255), phone_number varchar(255), surname varchar(255), primary key (id)) engine=InnoDB;
create table event_publication (completion_date datetime(6), publication_date datetime(6), id binary(16) not null, event_type varchar(255), listener_id varchar(255), serialized_event varchar(255), primary key (id)) engine=InnoDB;
alter table citizen add constraint UK_hue9uvj31uaire739po7r497c unique (address_id);
alter table appointment add constraint FKpvko6lesqchwpnt731mrflijx foreign key (citizen_id) references citizen (id);
alter table citizen add constraint FK7e1axkqo2xr5512tkik465k78 foreign key (address_id) references address (id);
create table address (id integer not null, postal_code integer, city varchar(255), country varchar(255), region varchar(255), street varchar(255), primary key (id)) engine=InnoDB;
create table address_seq (next_val bigint) engine=InnoDB;
insert into address_seq values ( 1 );
create table appointment (date_of_creation date, date_of_due date, id integer not null, citizen_id varchar(255), primary key (id)) engine=InnoDB;
create table appointment_seq (next_val bigint) engine=InnoDB;
insert into appointment_seq values ( 1 );
create table citizens (address_id integer not null, birth_date date, scope tinyint, dtype varchar(31) not null, email varchar(255), firstname varchar(255), id varchar(255) not null, image_base64 varbinary(255), middle_name varchar(255), phone_number varchar(255), surname varchar(255), primary key (id)) engine=InnoDB;
create table event_publication (completion_date datetime(6), publication_date datetime(6), id binary(16) not null, event_type varchar(255), listener_id varchar(255), serialized_event varchar(255), primary key (id)) engine=InnoDB;
alter table citizens add constraint UK_6h0rb9cuxpy6osona4j75qv6y unique (address_id);
alter table appointment add constraint FKdcl03yu8f5gulks00nlddxl79 foreign key (citizen_id) references citizens (id);
alter table citizens add constraint FKquji9chhojb3fk6c47mxelgmj foreign key (address_id) references address (id);
create table address (id integer not null, postal_code integer, city varchar(255), country varchar(255), region varchar(255), street varchar(255), primary key (id)) engine=InnoDB;
create table address_seq (next_val bigint) engine=InnoDB;
insert into address_seq values ( 1 );
create table appointment (date_of_creation date, date_of_due date, id integer not null, citizen_id varchar(255), primary key (id)) engine=InnoDB;
create table appointment_seq (next_val bigint) engine=InnoDB;
insert into appointment_seq values ( 1 );
create table citizens (address_id integer not null, birth_date date, scope tinyint, dtype varchar(31) not null, email varchar(255), firstname varchar(255), id varchar(255) not null, image_base64 varbinary(255), middle_name varchar(255), phone_number varchar(255), surname varchar(255), primary key (id)) engine=InnoDB;
create table event_publication (completion_date datetime(6), publication_date datetime(6), id binary(16) not null, event_type varchar(255), listener_id varchar(255), serialized_event varchar(255), primary key (id)) engine=InnoDB;
alter table citizens add constraint UK_6h0rb9cuxpy6osona4j75qv6y unique (address_id);
alter table appointment add constraint FKdcl03yu8f5gulks00nlddxl79 foreign key (citizen_id) references citizens (id);
alter table citizens add constraint FKquji9chhojb3fk6c47mxelgmj foreign key (address_id) references address (id);
create table address (id integer not null, postal_code integer, city varchar(255), country varchar(255), region varchar(255), street varchar(255), primary key (id)) engine=InnoDB;
create table address_seq (next_val bigint) engine=InnoDB;
insert into address_seq values ( 1 );
create table appointment (date_of_creation date, date_of_due date, id integer not null, subject tinyint, citizen_id varchar(255), comment varchar(255), primary key (id)) engine=InnoDB;
create table appointment_seq (next_val bigint) engine=InnoDB;
insert into appointment_seq values ( 1 );
create table citizens (address_id integer not null, birth_date date, scope tinyint, dtype varchar(31) not null, email varchar(255), firstname varchar(255), id varchar(255) not null, image_base64 varbinary(255), middle_name varchar(255), phone_number varchar(255), surname varchar(255), primary key (id)) engine=InnoDB;
create table event_publication (completion_date datetime(6), publication_date datetime(6), id binary(16) not null, event_type varchar(255), listener_id varchar(255), serialized_event varchar(255), primary key (id)) engine=InnoDB;
alter table citizens add constraint UK_6h0rb9cuxpy6osona4j75qv6y unique (address_id);
alter table appointment add constraint FKdcl03yu8f5gulks00nlddxl79 foreign key (citizen_id) references citizens (id);
alter table citizens add constraint FKquji9chhojb3fk6c47mxelgmj foreign key (address_id) references address (id);
create table address (id integer not null, postal_code integer, city varchar(255), country varchar(255), region varchar(255), street varchar(255), primary key (id)) engine=InnoDB;
create table address_seq (next_val bigint) engine=InnoDB;
insert into address_seq values ( 1 );
create table appointment (date_of_creation date, date_of_due date, id integer not null, subject tinyint, citizen_id varchar(255), comment varchar(255), primary key (id)) engine=InnoDB;
create table appointment_seq (next_val bigint) engine=InnoDB;
insert into appointment_seq values ( 1 );
create table citizens (address_id integer not null, birth_date date, scope tinyint, dtype varchar(31) not null, email varchar(255), firstname varchar(255), id varchar(255) not null, image_base64 varbinary(255), middle_name varchar(255), phone_number varchar(255), surname varchar(255), primary key (id)) engine=InnoDB;
create table event_publication (completion_date datetime(6), publication_date datetime(6), id binary(16) not null, event_type varchar(255), listener_id varchar(255), serialized_event varchar(255), primary key (id)) engine=InnoDB;
alter table citizens add constraint UK_6h0rb9cuxpy6osona4j75qv6y unique (address_id);
alter table appointment add constraint FKdcl03yu8f5gulks00nlddxl79 foreign key (citizen_id) references citizens (id);
alter table citizens add constraint FKquji9chhojb3fk6c47mxelgmj foreign key (address_id) references address (id);