# Junit-testing-with-Mockito-example

created a small spring boot application that connects with a Database using XAMMP, wrote Junit testcases for methods found in StudentServiceImpl layer. I did this by using Mockito to isolate my unit test by accessing a fake version of my database. this allowed me to test methods without communicating and writing or modifying data found in my database.

When i called a method found in repository layer i returned a value in my testcases. 


1) Junit test cases passing Screen shot
![image](https://user-images.githubusercontent.com/73298685/185584387-1fad70ce-adcd-450f-b408-ae175919eaf7.png)


2) no data being written to my database
![image](https://user-images.githubusercontent.com/73298685/185585895-37affa61-778e-411d-b0a7-16e44dc64649.png)
