USE techblog
GO
CREATE TABLE tblUser
(
	id_User INT IDENTITY(1,1) PRIMARY KEY, 
	is_Online BIT DEFAULT(0) NOT NULL,
	email VARCHAR(40) UNIQUE NOT NULL,
	password VARCHAR(500) NOT NULL,
	user_Role VARCHAR(40) NOT NULL,
)

--DROP DATABASE techblog
--CREATE DATABASE techblog

--DELETE FROM tblUser
--DBCC CHECKIDENT ('tblUser', RESEED, 0);

CREATE TABLE tblAdditionalUserData
(
	id_additional_data INTEGER PRIMARY KEY,
	first_name VARCHAR(40) NOT NULL,
	last_name VARCHAR(40) NOT NULL,
	info VARCHAR(500) NOT NULL,
	CONSTRAINT fk_data_user
	FOREIGN KEY (id_additional_data)
	REFERENCES tblUser (id_user)
    ON DELETE CASCADE
)

CREATE TABLE tblTopic
(
	id_topic INTEGER IDENTITY(1,1) PRIMARY KEY,
	topic_title VARCHAR(40) NOT NULL,
	id_user_post_admin INTEGER NOT NULL,
	CONSTRAINT fk_topic_user
	FOREIGN KEY (id_user_post_admin)
	REFERENCES tblUser (id_user)
    ON DELETE CASCADE
)

CREATE TABLE tblMessage
(
	id_message INTEGER IDENTITY(1,1) PRIMARY KEY,
	msg_text VARCHAR(2000) NOT NULL,
	likes_message INTEGER NOT NULL DEFAULT(0),
	id_topic INTEGER NOT NULL,
	id_user INTEGER NOT NULL,
	CONSTRAINT fk_msg_topic
	FOREIGN KEY (id_topic)
	REFERENCES tblTopic (id_topic)
    ON DELETE CASCADE,
	CONSTRAINT fk_msg_user
	FOREIGN KEY (id_user)
	REFERENCES tblUser (id_user)
	ON DELETE CASCADE
)

-- sp_rename 'tblUser.UserID', 'IDUser', 'COLUMN';
