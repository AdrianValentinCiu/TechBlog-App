SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

ALTER PROCEDURE GetUserInfo 
	@UserId INT
AS
BEGIN
	SET NOCOUNT ON;
	SELECT usr.id_User
		,usr.is_Online
		,usr.email
		,usr.password
		,usr.user_Role
		,[usr_data].[first_name] + ' ' + [usr_data].[last_name] AS [full_name]
		,usr_data.info
	FROM [techblog].[dbo].[tblUser] usr
	LEFT JOIN [techblog].[dbo].[tblAdditionalUserData] usr_data
	ON (usr_data.id_additional_data = usr.id_User)
	WHERE usr.id_User = @UserId
END
GO
