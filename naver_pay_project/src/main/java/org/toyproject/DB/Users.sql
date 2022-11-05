DROP TABLE USERS;

CREATE TABLE USERS(
                      SERIAL_NUMBER INT,
                      USER_ID VARCHAR(255),
                      PASSWORD VARCHAR(255),
                      USERNAME VARCHAR(255),
                      POINT INT,
                      PHONE_NUMBER VARCHAR(255),
                      ADDRESS VARCHAR(255),
                      PRIMARY KEY (SERIAL_NUMBER)
);

-- Test Data
INSERT INTO USERS VALUES (1,'CHOI','123','wj',100,'010-1234-1234','RightCenter');
INSERT INTO USERS VALUES (2,'CHOI','124','sj',200,'010-1234-1235','LeftCenter');
INSERT INTO USERS VALUES (3,'KWAK','125','yh',300,'010-1234-1236','LeftTop');
INSERT INTO USERS VALUES (4,'LIM','126','hj',400,'010-1234-1237','LeftBottom');
INSERT INTO USERS VALUES (5,'KIM','127','ty',500,'010-1234-1238','RightTop');
INSERT INTO USERS VALUES (6,'HONG','128','sh',600,'010-1234-1239','RightBottom');