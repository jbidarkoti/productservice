drop table PRODUCT if exists;

create table PRODUCT (PRODUCTID bigint identity primary key, 
						PRODUCTNAME varchar(50) not null,
						PRODUCTTYPE varchar(50) not null, 
                        PRODUCTPRICE decimal(8,2));
                        
ALTER TABLE PRODUCT ALTER COLUMN PRODUCTPRICE SET DEFAULT 0.0;
