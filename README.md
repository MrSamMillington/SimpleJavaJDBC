# JDBC Tutorial

JDBC Driver handles converting calls into low level code in the database.

JDBC API is defined in packages:

-   `java.sql`
-   `javax.sql`

Key classes are:

-   `java.sql.DriverManger`
-   `java.sql.Connection`
-   `java.sql.Statement`
-   `java.sql.ResultSet`
-   `java.sql.DataSource` (for connection pooling)

## Development process

1. Get a connection to database
2. Create a statement object
3. Execute SQL query
4. Do something with the results.

### 1. 

connection string: `jdbc:<driver protocol>:<driver connection details>`

e.g 

```$java
...
String dbUrl = "jdbc:mysql://localhost:3306/demo"
String user = "student"
String pass = "password

Connection myConn = DriverManager.getConnection(dbUrl, user, pass)

```

errors:

`SQLException` - invalid url, pass or user. 

### 2.

`Statement statement = myConn.createStatement()`

### 3. 

`ResultSet myRs = statement.executeQuery("select * from students")`

###4. 

```$xslt
...
while(myRs.next()){
   String name = myRs.getString("last_name")
    //process.
}

```

## Database setup

1. Install MySQL
2. Connect to database

Need to create a user, in the Users and Privileges tab -> Add Account

password123!



