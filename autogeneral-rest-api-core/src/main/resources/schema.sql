DROP TABLE IF EXISTS ToDoItem;
DROP SEQUENCE IF EXISTS S_ToDoItem;

create sequence S_ToDoItem START WITH 0;

/*==============================================================*/
/* Table : ToDoItem		                                        */
/*==============================================================*/
CREATE TABLE ToDoItem (
	ID 				    BIGINT           not null,
	text 				VARCHAR(150)     not null,
	isCompleted            INT              not null,
	createdAt              VARCHAR(20)           not null,
	CONSTRAINT PK_ToDoItem PRIMARY KEY (ID)
);


