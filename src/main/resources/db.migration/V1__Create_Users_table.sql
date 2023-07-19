create sequence user_sequence start with 1 increment by 1

create table users (
    age integer,
    sex smallint check (sex between 0 and 1),
    id bigint not null,
    avatar varchar(255),
    dob varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    primary key (id)
)