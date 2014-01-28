DROP TABLE messages CASCADE CONSTRAINTS;
DROP SEQUENCE message_id;
CREATE TABLE messages
    (message_id    NUMBER(6) PRIMARY KEY,
	message VARCHAR2(30) NOT NULL,
	message_time  DATE NOT NULL) ;
	
	CREATE SEQUENCE message_id;
	

INSERT INTO messages VALUES (message_id.nextval,'AAA',TO_DATE('05-02-1998 20:50:12', 'dd-MM-yyyy HH24:MI:SS'));
INSERT INTO messages VALUES (message_id.nextval,'BBB',TO_DATE('06-12-2003 12:40:02', 'dd-MM-yyyy HH24:MI:SS'));
INSERT INTO messages VALUES (message_id.nextval,'CCC',TO_DATE('04-02-2010 23:44:17', 'dd-MM-yyyy HH24:MI:SS'));
INSERT INTO messages VALUES (message_id.nextval,'DDD',TO_DATE('13-03-2011 12:21:00', 'dd-MM-yyyy HH24:MI:SS'));
INSERT INTO messages VALUES (message_id.nextval,'EEE',TO_DATE('21-09-2011 20:34:32', 'dd-MM-yyyy HH24:MI:SS'));
INSERT INTO messages VALUES (message_id.nextval,'FFF',TO_DATE('16-11-2013 16:50:11', 'dd-MM-yyyy HH24:MI:SS'));

