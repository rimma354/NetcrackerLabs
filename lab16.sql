 DROP TABLE employees CASCADE CONSTRAINTS;
 DROP TABLE departments CASCADE CONSTRAINTS;

CREATE TABLE departments
    ( department_id    NUMBER(4) PRIMARY KEY,
	department_name  VARCHAR2(30) NOT NULL) ;

CREATE TABLE employees
    ( employee_id    NUMBER(6),
    first_name     VARCHAR2(20),
    last_name      VARCHAR2(25) NOT NULL,
    salary         NUMBER(8,2),
    department_id  NUMBER(4),
    CHECK (salary > 0),
	PRIMARY KEY (employee_id),
	FOREIGN KEY (department_id)
                      REFERENCES departments
    ) ;
	
	INSERT INTO departments VALUES (1,'IT');
    INSERT INTO departments VALUES (2,'Accounting');
	
	INSERT INTO employees VALUES (1,'Neena','Kochhar',10000,1);
	INSERT INTO employees VALUES (2,'Alexander','Hunold',8000,1);
	INSERT INTO employees VALUES (3,'Bruce','Ernst',9000,1);
	INSERT INTO employees VALUES (4,'David','Austin',6000,2);
	INSERT INTO employees VALUES (5,'Valli','Pataballa',8000,2);