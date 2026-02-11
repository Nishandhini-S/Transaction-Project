CREATE TABLE ACCOUNT_TBL(
 Account_Number VARCHAR2(10) CONSTRAINT pmy_key PRIMARY KEY ,
 Customer_Name VARCHAR2(15),
 Balance NUMBER(10,2)
) ;
CREATE TABLE TRANSFER_TBL(
    Transaction_ID NUMBER(4) PRIMARY KEY,
    Account_Number VARCHAR2(10),
    Beneficiary_Account_Number VARCHAR2(10),
    Transaction_Date DATE,
    Transaction_Amount NUMBER(10,2),
    CONSTRAINT emp_fk FOREIGN KEY (Account_Number) 
        REFERENCES ACCOUNT_TBL (Account_Number)
);
ALTER TABLE TRANSFER_TBL
ADD CONSTRAINT emp_fk1
FOREIGN KEY (Beneficiary_Account_Number)
REFERENCES ACCOUNT_TBL (Account_Number);
INSERT INTO ACCOUNT_TBL VALUES ('1234','Reddy',200);
INSERT INTO ACCOUNT_TBL VALUES ('2345','Mahesh',11800);
INSERT INTO ACCOUNT_TBL VALUES ('3456','Dhanu',83700);
INSERT INTO ACCOUNT_TBL VALUES ('4537','Sam',5000);

SELECT * FROM ACCOUNT_TBL;

create sequence transactionId_seq
START WITH 1000
MINVALUE 1000
MAXVALUE 9999
INCREMENT BY 1;

SELECT transactionId_seq.NEXTVAL from dual;