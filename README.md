Đây là phần server của đồ án
1. Tải oracle 21c và SQL Developer
2. Tạo connection (NAME= oracle | PORT= 1521) và chạy query tạo dtb sau:

CREATE TABLE USERS (
    USER_ID VARCHAR2(4) PRIMARY KEY,
    NAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    CREATE_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

INSERT INTO USERS VALUES ('U001', 'cga', 'cga@gmail.com', '1902', CURRENT_TIMESTAMP);

SELECT * FROM USERS;


3. trên Intellij IDEA nhớ update dependencies (Maven)
4. Khởi động server (SERVER_PORT= 8094)
5. Chạy song song với client và thực hiện các chức năng
