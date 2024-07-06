# auth-using-jsp-servlet-postgresql

This project is a simple login and signup system built using JSP, Servlets, and PostgreSQL. Users can register an account and log in using their credentials. If the user ID and password do not match the database, the user cannot log in.

## Features

- User Registration
- User Login
- Password validation

## Technologies Used

- Java
- JSP (JavaServer Pages)
- Servlets
- PostgreSQL
- HTML/CSS/JS

## Prerequisites

- Java Development Kit (JDK)
- Apache Tomcat
- PostgreSQL
- Eclipse IDE
- Git

## Setup Instructions

1. **Clone the repository**
    ```bash
    git clone https://github.com/abhishekdumaniya/auth-using-jsp-servlet-postgresql.git
    ```

2. **Import the project into Eclipse**
   - Open Eclipse IDE.
   - Go to `File` > `Import` > `General` > `Existing Projects into Workspace`.
   - Select the cloned repository.

3. **Set up the database**
   - Install PostgreSQL and create a database named `users`.
   - Create a table `userinfos` with the following schema:
     ```sql
     CREATE TABLE userinfos (
         uid SERIAL PRIMARY KEY,
         uname VARCHAR(50) NOT NULL,
         uemail VARCHAR(50) NOT NULL,
         upwd VARCHAR(50) NOT NULL,
         umobile VARCHAR(50) NOT NULL
     );
     ```

4. **Add the PostgreSQL JDBC driver**
   - Download the PostgreSQL JDBC driver jar from the PostgreSQL website.
   - Right-click on your project in Eclipse, go to `Build Path` > `Add External Archives`, and add the downloaded jar file.

5. **Configure the database connection**
   - Update the database configuration in the `dbconfig.properties` file with your PostgreSQL credentials.

6. **Deploy the application**
   - Right-click on your project, go to `Run As` > `Run on Server`, and select Apache Tomcat.

7. **Run the application**
   - Access the application at `http://localhost:8080/Signup/login.jsp`.

## Usage

- **Sign Up**: Navigate to the signup page and create a new account.
- **Log In**: Use your credentials to log in. If the credentials are invalid, you will not be able to log in.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any improvements.

## License

This project is licensed under the MIT License.

## Contact

For any questions or inquiries, please contact Abhishek Dumaniya at [dumaniyaabhishek@gmail.com].
