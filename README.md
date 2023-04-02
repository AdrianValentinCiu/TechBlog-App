# TechBlog

TechBlog is the newest technology blog where you can ask any question abaut any technology available on the market.
The purpose of this application is to enable users to find answears from real profesionals without being annoyed by the ads.

## The main objectives of this project are:
- Allowing long-distance communication between people from all over the world about tech problems.
- Allowing sharing media files
- Facilitating communication between more users via specific subjects group chats.

## The side objectives are:
- Allowing a user to create a profile where they can share something about their tech knowledge and see their activity score on the app.

---
## Functional requierments:
#####  Authentication actions:
- The software allows a user to register.
- The software allows only users with the age higher than 18 years old to use the app.
- The software encrypts the passwords (including the old ones) using SHA_256 hashing.
- The software allows a user to introduce additional data.
- The software allows a user to change his password.
- The software allows a user to log in the system.
- The software allows a user to log off from the system.

#####  User actions:
- The software allows a user to other user's info
- The software allows a user to search through tech subjects
- The software allows a user to answer or to put a new question on a specific topic
- The software allows a user to ask a new question about their problem
- The software allows a user to block a user from answearing to their topic
- The software allows a user to unblock a user from answearing to their topic
 

##### Topic actions:
- The software allows a user to post new topic
- The software allows a user to post messages on the topic
- The software allows a user to delete messages inapropiate for their created topic
- The software allows a user to edit their posted message on a topic

##### Media actions:
- The software allows a user to upload/delete a picture for the profile
- The software allows a user to upload/remove media files from his/her profile.
- The software allows a user to upload/remove a media file from a topic

---
##  Non-functional requirements
- The application should be intuitive and easy to use.
- The application should use as little buttons as possible.
- The application should use icons instead of plain text for the buttons.
- The application should have a good contrast of colors.


---
## Use cases:
- A user can create a new account (register).
- A user can create a new account only if his/her age is above 18 years
- A user can log in in the application
- A user can log off in the application
- A user can upload a profile picture (media file)
- A user can update/delete the profile picture.
- A user can additional data which can be visible to the other users.
- A user can change the current password.
- A user can send messages (including media files) to a topic or on his/her own topic
- A user can create a new topic
- A user can delete his/her topic
- A user can edit a message
- A user can block another user from his/her topic
- A user can edit their messages
---

## Database diagram:


![db_diagram](https://user-images.githubusercontent.com/111737211/225292495-4d65691f-2215-4c26-8fda-3304a194a285.svg)


## Observer Design Pattern:
For this application I used the Observer design pattern in order to notofy all users about the new updates in the app via their provided email address when creating a new account on the blog.

## Endopoints:
- POST: Register a new user:
http://localhost:8080/api/v1/auth/register
- JASON example:
{
    "email" : "test",
    "password" : "1234" 
}

- PUT: Login in a user:
http://localhost:8080/api/v1/auth/login
- JASON example:
{
    "email" : "adrian_ciu@yahoo.com",
    "password" : "1234" 
}

- PUT: Log out a user:
http://localhost:8080/api/v1/auth/logout
- JASON example:
{
    "id" : "8" 
}

- DELETE: Delete a user by an admin:
http://localhost:8080/api/v1/user/delete_user
-JASON example:
{
    "id" : "5" ,
    "idAdminUser" : "1" 
}

- GET: Get data about a specific user:
http://localhost:8080/api/v1/user/user_data/4

- PUT: Additional user data:
http://localhost:8080/api/v1/user/user_data
-JASON example:
{
    "userId" : 8,
    "firstName" : "Adrian-Valentin",
    "lastName" : "Ciu",
    "info" : "Student at UTCN, CTI"
}

- POST: Create a new topic on the blog
http://localhost:8080/api/v1/topic/create-topic
-JASON example:
{
    "topicTitle" : "Topic test title",
    "idUserPostAdmin" : 8
}

- POST: Post a new message on a specific topid:
http://localhost:8080/api/v1/topic/post-message-topic
-JASON example:
{
    "msgText" : "Second Msg",
    "idTopic" : 1,
    "idUser" : 8
}

- PUT: Like a message from a topic:
http://localhost:8080/api/v1/topic/like-topic-message
-JASON example:
{
    "idMessage" : 2, 
    "idTopic" : 1,
    "idUser" : 8
}
