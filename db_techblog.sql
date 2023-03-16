USE techblog
GO
CREATE TABLE tblUser
(
	id_User INT IDENTITY(1,1) PRIMARY KEY, 
	is_Online BIT DEFAULT(0) NOT NULL,
	email VARCHAR(40) UNIQUE NOT NULL,
	password VARCHAR(40) NOT NULL,
	user_Role VARCHAR(40) NOT NULL,
)

--DROP DATABASE techblog
--CREATE DATABASE techblog

--DELETE FROM tblUser
--DBCC CHECKIDENT ('tblUser', RESEED, 0);

CREATE TABLE tblAdditionalUserData
(
	idAdditionalData INTEGER PRIMARY KEY,
	firstName VARCHAR(40) NOT NULL,
	lastName VARCHAR(40) NOT NULL,
	info VARCHAR(500) NOT NULL,
	CONSTRAINT fk_data_user
	FOREIGN KEY (idAdditionalData)
	REFERENCES tblUser (idUser)
    ON DELETE CASCADE
)

CREATE TABLE tblTopic
(
	idTopic INTEGER IDENTITY(1,1) PRIMARY KEY,
	topicTitle VARCHAR(40) NOT NULL,
	idUserPostAdmin INTEGER NOT NULL,
	CONSTRAINT fk_topic_user
	FOREIGN KEY (idUserPostAdmin)
	REFERENCES tblUser (idUser)
    ON DELETE CASCADE
)

CREATE TABLE tblMessage
(
	idMessage INTEGER IDENTITY(1,1) PRIMARY KEY,
	msgText VARCHAR(2000) NOT NULL,
	likesMessage INTEGER NOT NULL DEFAULT(0),
	idTopic INTEGER NOT NULL,
	idUser INTEGER NOT NULL,
	CONSTRAINT fk_msg_topic
	FOREIGN KEY (idTopic)
	REFERENCES tblUser (idUser)
    ON DELETE CASCADE,
	CONSTRAINT fk_msg_user
	FOREIGN KEY (idUser)
	REFERENCES tblUser (idUser)
	ON DELETE NO ACTION
)

-- sp_rename 'tblUser.UserID', 'IDUser', 'COLUMN';
