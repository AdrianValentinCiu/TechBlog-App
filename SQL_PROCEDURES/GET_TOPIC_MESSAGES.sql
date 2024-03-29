USE [techblog]
GO
/****** Object:  StoredProcedure [dbo].[GetTopicMessages]    Script Date: 5/5/2023 1:32:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


ALTER PROCEDURE [dbo].[GetTopicMessages] 
    @TopicId INT
AS
BEGIN
    SELECT [id_message]
      , msg.msg_text
      , msg.likes_message
      ,[usr].[first_name] + ' ' + [usr].[last_name] AS [full_name]
  FROM [techblog].[dbo].[tblMessage] msg
  LEFT JOIN [techblog].[dbo].[tblAdditionalUserData] usr
  ON (usr.id_additional_data = msg.id_user)
  WHERE id_topic = @TopicId
END
