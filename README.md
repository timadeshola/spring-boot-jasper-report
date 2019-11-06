Jasper Report Generator with Spring Boot

Dependency:
You need to import jasper dependency to enable you implement jasper report in spring boot.

        <dependency>
            <groupId>net.sf.jasperreports</groupId>
            <artifactId>jasperreports</artifactId>
            <version>6.9.0</version>
        </dependency>

Download Jasper Studio using the below link  <html> <a href="https://community.jaspersoft.com/project/jaspersoft-studio/releases">here</a></html>

Install and follow the installation wizard.

Step 1:
- Open the Jasper Studio
- Click on the Repository Explorer
- Right Click on the Data Adapter and click on Create Data Adapter
- Select your data adapter from the options provided 
- Click on next
- Enter name of your adapter, e.g. MySql Adapter
- Select appropriate data sources with username and password if required.

I am using postgres datasource, so below are my properties
- Name: Postgres Data Source
- JDBC Driver:  PostgresSQL (org.postgresql.Driver)
- JDBC URL: jdbc:postgresql://localhost:5432/database
- username: postgres
- password: postgres
- Click on Driver Classpath, and select a postgres jar file
- click on finish

Step 2:
 - Go to Project Explorer 
 - Create a project
 - Create a Jasper Report
 - A dialog box appears, enter the report name with .jrxml extension and next
 - Select your data adapter
 - Write your sql query in the right panel e.g. select * from employees and next
 - select the fields that you need to display on the report and next
 - Select field you want to use to group the report - optional and next
 - Click finish
 
 Step 3:
 - Edit your table
 - Copy the xml source file
 - Create a file inside your resource folder with same name as your jasper jrxml
 
 
 