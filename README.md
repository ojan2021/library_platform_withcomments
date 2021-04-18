# Library Platform
### Necessary queries for the database
- Make sure that you have executed these queries before deployment
```sh
https://pastebin.com/nWL3wJUT
```
### Endpoint for Register:
* Use POST method
```sh
/auth/login
```
- In Headers part, Content-Type should be application/json.
#### In Body:
```sh
{
    "username": "ojan2021",
    "email": "sample@sample.com",
    "password":"qwerty",
    "firstname":"Orhan",
    "lastname":"Jan",
    "birthday":"11.11.1111",
    "role": ["admin"]
}
```

### Endpoint for Login:
* Use POST method
```sh
/auth/login
```
- In Headers part, Content-Type should be application/json.
#### In Body:
```sh
{
    "username": "ojan2021",
    "password":"qwerty"
}
```
### Endpoints for Book Operations:
- Use GET method
- List all categories, books, metadata:
```sh
search/categories
search/book_titles
search/metadata
```
#### Search by category:
- In Headers part, "category" should be one of the categories.
```sh
search/sbc
```
#### Search by author:
- In Headers part, "author" should be one of the authors.
```sh
search/sba
```
#### Search by title:
- In Headers part, "title" should be one of the book titles.
```sh
search/sbt
```
#### Pick up the book:
- In Headers part, "title" should be one of the book titles and "Authorization" should be the token.
```sh
search/pickup_book
```
#### Drop off the book:
- In Headers part, "title" should be one of the book titles and "Authorization" should be "Bearer " + the token.
```sh
search/dropoff_book
```
#### List the books that you have taken:
- In Headers part, "Authorization" should be "Bearer " + the token.
```sh
search/pickedup_books
```