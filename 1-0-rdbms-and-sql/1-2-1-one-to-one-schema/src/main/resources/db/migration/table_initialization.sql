/*

User profile database stores information about users and their work profiles.

Each user has one and only one work profile.

Each user has stored first and last names, email and birthday which are mandatory. Email is a unique value.
A profile for each user is optional, and consists of optional information: city, job_position, company and education.
All these fields are regular strings without restrictions.

  TECH NOTES AND NAMING CONVENTION
- All tables, columns and constraints are named using "snake case" naming convention
- All table names must be plural (e.g. "companies", not "company")
- All tables (except link tables) should have a single-value identifier of type BIGINT, which is a primary key
- All primary key, foreign key, and unique constraint should be named according to the naming convention.
- All "1 - optional 1" relations should be handled using the same primary key value for both tables. E.g. child table
should have a column that stores primary key from a parent table, which is a foreign key and primary key at the same time

- All primary keys should be named according to the following rule "table_name_PK"
- All foreign keys should be named according to the following rule "table_name_reference_table_name_FK"
- All alternative keys (unique) should be named according to the following rule "table_name_column_name_AK"

*/

create table if not exists users
(
    id         BIGINT,
    first_name VARCHAR(255) not null,
    last_name  VARCHAR(255) not null,
    email      VARCHAR(255) not null,
    birthday   DATE         not null,
    CONSTRAINT users_PK PRIMARY KEY (id),
    CONSTRAINT users_email_AK UNIQUE (email)
);

create table if not exists  profiles
(
    city         VARCHAR(255),
    job_position VARCHAR(255),
    company      VARCHAR(255),
    education    VARCHAR(255),
    user_id      BIGINT,
    CONSTRAINT profiles_PK PRIMARY KEY (user_id),
    CONSTRAINT profiles_users_FK FOREIGN KEY (user_id) REFERENCES users
);
