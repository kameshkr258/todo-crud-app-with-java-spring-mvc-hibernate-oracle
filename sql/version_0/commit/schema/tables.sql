
CREATE TABLE TEST_DB.SPRING_MVC_TODO_APP_ENV (
	ID									NUMBER(5) NOT NULL ENABLE,
	ENV_CODE							VARCHAR2(5) NOT NULL ENABLE,
	ENV_NAME							VARCHAR2(20) NOT NULL ENABLE,
	CREATED_DT							TIMESTAMP(8) NOT NULL ENABLE,
	CREATED_BY							VARCHAR2(25) NOT NULL ENABLE
)	SEGMENT CREATION IMMEDIATE 
	TABLESPACE TEST_DATA ;


CREATE TABLE TEST_DB.SPRING_MVC_TODO_APP_VERSION (
	ID									NUMBER(5) NOT NULL ENABLE,
	CODE								VARCHAR2(5) NOT NULL ENABLE,
	DESCRIPTION							VARCHAR2(25),
	VERSION								VARCHAR2(10) NOT NULL ENABLE,
	CREATED_DT							TIMESTAMP(8) NOT NULL ENABLE,
	CREATED_BY							VARCHAR2(25) NOT NULL ENABLE
)	SEGMENT CREATION IMMEDIATE 
	TABLESPACE TEST_DATA ;


CREATE TABLE TEST_DB.TODO_TASK (
	ID									NUMBER(8) NOT NULL ENABLE,
	TITLE								VARCHAR2(256) NOT NULL ENABLE,
	DESCRIPTION							CLOB,
	STATUS								VARCHAR2(10) NOT NULL ENABLE,
	CREATED_DT							TIMESTAMP(8) NOT NULL ENABLE,
	COMPLETION_DT						TIMESTAMP(8) NOT NULL ENABLE
)	SEGMENT CREATION IMMEDIATE 
	TABLESPACE TEST_DATA ;
