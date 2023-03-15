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
https://www.planttext.com/api/plantuml/svg/ZLHVJy8m77pVfwWnCP18Y2-6a6PX8Y9HmP1fufFfs6_Oq3-aBM54-EvsC4U5egvFwzsrTxTVrj66ABFWB3XB8QC2q5nHJjJgVGQhMbv7E0dnH3AfskT9gtLzPLylB1JYvdOtH3bk9c6bpgG2EXMLkfIIxNCahMHsOy65gu2iM5R18QMaeM0YLUgJ6f8mA9GW33Khb2ECKIs-HCiFQg2EmZ3OKP19s8i6XUheCq0_SYAQxf0s6WpZNhytHfPHca9KZmGhhhBmpMZqs8k6BWoSK5PWtVje77LZAtwDnc-3OTyXpOdMIvlW5C_jpRg9qfGQAWLXjyGGrnV6TmysqiO9jISN8NO2NyJJXpf6Cwgq6H8ENgSkav5VY6vz8fD-ZXk2WzPa2dxdJz-WrpBNqnXoyyzgOpcd4q-ZHyJ3YV0qNvxbitnqZMFO55XC3VkpEqPdu4dlD_iijObIJeNVTJdzctMZiLxxvoPmFiIULw1-P1iog8eua0GT4AdzjNm1
https://www.planttext.com/api/plantuml/svg/ZLHVJy8m77pVfwWnCP18Y2-6a6PX8Y9HmP1fufFfs6_Oq3-aBM54-EvsC4U5egvFwzsrTxTVrj66ABFWB3XB8QC2q5nHJjJgVGQhMbv7E0dnH3AfskT9gtLzPLylB1JYvdOtH3bk9c6bpgG2EXMLkfIIxNCahMHsOy65gu2iM5R18QMaeM0YLUgJ6f8mA9GW33Khb2ECKIs-HCiFQg2EmZ3OKP19s8i6XUheCq0_SYAQxf0s6WpZNhytHfPHca9KZmGhhhBmpMZqs8k6BWoSK5PWtVje77LZAtwDnc-3OTyXpOdMIvlW5C_jpRg9qfGQAWLXjyGGrnV6TmysqiO9jISN8NO2NyJJXpf6Cwgq6H8ENgSkav5VY6vz8fD-ZXk2WzPa2dxdJz-WrpBNqnXoyyzgOpcd4q-ZHyJ3YV0qNvxbitnqZMFO55XC3VkpEqPdu4dlD_iijObIJeNVTJdzctMZiLxxvoPmFiIULw1-P1iog8eua0GT4AdzjNm1
