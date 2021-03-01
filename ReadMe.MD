
To run:
----------------------------------
Java –jar demo2-0.0.1-SNAPSHOT.jar

URLs:
----------------------------------
Main											http://localhost:8990/change_password
Password changed event logs						http://localhost:8990/logs
List of Users – to show password was updated	http://localhost:8990/users

Test Data:
----------------------------------
Username				Password
johnsmith@yahoo.com		test123
janesmith@yahoo.com 	test123

Source Code: https://github.com/laipenar/springboot.git
Jar File: https://drive.google.com/file/d/1R2ZC4uFij7tu7BYs1RXbawihGvwk8lmv/view?usp=sharing


Notes:
----------------------------------
-	For changing password, user should be able to input old password to verify that they are the correct user. 
	o	Created function to verify email and current password, but from the program, I’m just currently using findByEmail
	o	User findUserByEmailAndPasswrd(String email, String passwrd) //UserRepository
