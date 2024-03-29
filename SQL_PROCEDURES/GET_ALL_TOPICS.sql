USE [techblog]
GO
/****** Object:  StoredProcedure [dbo].[GetAllTopics]    Script Date: 5/5/2023 1:09:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[GetAllTopics]
AS
BEGIN
	SELECT TOP (1000) topic.id_topic
		,topic.topic_title
		,[usr].[first_name] + ' ' + [usr].[last_name] AS [full_name]
	FROM [techblog].[dbo].[tblTopic] topic
	LEFT JOIN [techblog].[dbo].[tblAdditionalUserData] usr
	ON (usr.id_additional_data = topic.id_user_post_admin)
END
