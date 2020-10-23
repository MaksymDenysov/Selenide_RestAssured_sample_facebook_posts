# Selenide_RestAssured_sample_facebook_posts

This is an example project for automation testing framework in java

It is based on RestAssured and Selenide frameworks

As functionality to test was taken Facebook posts:
- covered CRUD operations by Api tests
- covered CRUD operations by acceptance tests (using Cucumber), feature files are placed in resources folder

Test data for api and accepatnce tests is managed with help of RestAssured, also before each test all posts are deleted using API

In order to make project working credentials and page_id have to be provided in credentials.properties file
