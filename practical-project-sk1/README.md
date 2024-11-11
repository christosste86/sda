## DB Integration

* [Database Initialization](https://docs.spring.io/spring-boot/docs/2.1.x/reference/html/howto-database-initialization.html)


---

```java
 <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
<property name="connection.url">jdbc:mysql://localhost:3306/sda</property>
<property name="connection.username">root</property>
<property name="connection.password">my-secret-pw</property>
<property name="dialect">org.hibernate.dialect.MySQL8Dialect</property>
<property name="hibernate.hbm2ddl.auto">create-drop</property>

```

1. connection.url:

This property specifies the URL of the MySQL database you want to connect to. In your case, it's connecting to a database named "sda" on the local machine (localhost) using port 3306.

2. connection.username:

This property specifies the username for authenticating with the MySQL database. In your case, the username is "root".

3. connection.password:

This property specifies the password for the user specified in the spring.datasource.username property. In your case, the password is "password".

4. hibernate.hbm2ddl.auto:

This property controls the automatic schema management behavior for Hibernate, the JPA implementation. The value "create-drop" means that when the application starts, Hibernate will create the database schema based on your entity mappings, and when the application stops, it will drop the schema.
Usage: This option is often used during development and testing to have a clean slate for each run. However, be cautious because using it in production can lead to data loss.

  Options and Usage:

  * none:  No automatic schema management.
   Usage: When you want to manage schema changes manually, possibly using database migration scripts.

  * validate: Hibernate validates schema against entity mappings without making updates.
   Usage: In production, to ensure schema matches entity mappings without automatic changes.

  * update: Hibernate validates schema and performs necessary updates to match mappings.
   Usage: During development and testing to automatically update schema as entity mappings change. Be cautious in production due to potential unintended changes.

  * create: Hibernate drops existing schema and recreates it based on entity mappings.
   Usage: In development or testing to start fresh each application run. Caution: Data loss occurs.

  * create-drop: Similar to create, but drops schema on application shutdown too.
   Usage: During development and testing for a clean slate on each run. Data loss occurs.



5. dialect:

This property specifies the Hibernate dialect for MySQL. The org.hibernate.dialect.MySQL8Dialect is suitable for MySQL 8.x databases.


* ***@Entity*** - Entities in JPA are nothing but POJOs representing data that can be persisted to the database.
  An entity represents a table stored
  in a database. Every instance of an entity represents a row in the table.

  ```java
  @Entity
  public class Blog {
      // ...
  }
  ```
* ***@Table*** - Specifies the primary table for the annotated entity.
  ```java
  @Entity(name = "table_blogger")
  public class Blogger {
      // ...
  }
  ```
  Hibernate:
  ```SQL
  create table table_blogger (
    ...
  ```
* ***@Column*** - Specifies the mapped column for a persistent property or field.
    * **name**
      ```java
      @Entity
      @Table(name = "table_blogger")
      public class Blogge {
          @Column(name = "pass")
          private String password;
          // ...
      }
      ```
      Hibernate:
      ```SQL
      create table table_blogger (
        pass varchar(255),
        ...
      ```

* ***@Id*** - Specifies the primary key of an entity.
  ```java
  @Id private Long id;
  ```
* ***@GeneratedValue*** - Provides for the specification of generation strategies for the values of primary keys.
  ```java
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  ```
The @GeneratedValue annotation with GenerationType.IDENTITY is commonly used to indicate that the primary key values for entities should be generated automatically by the database (usually using an auto-increment mechanism). However, there are other strategies available that you can use based on your specific needs. Here are some alternative strategies and when you might use them:

GenerationType.AUTO:

This strategy lets the JPA provider (like Hibernate) choose the appropriate generation strategy based on the underlying database capabilities.
Usage: You might use this if you're targeting multiple database systems with different auto-generation capabilities and you want the JPA provider to choose the most appropriate strategy for each.

GenerationType.SEQUENCE:

This strategy uses database sequences to generate primary key values. Sequences are often supported by databases like Oracle.
Usage: When you're working with a database that supports sequences and you want more control over the generated values, or when you're dealing with a legacy database schema that uses sequences.

GenerationType.TABLE:

This strategy involves using a separate database table to manage the generation of primary key values. The table stores the next available value, and the application periodically queries and updates this table.
Usage: When you're working with databases that don't support auto-increment or sequences, or when you need more control over primary key generation. This strategy can be slower compared to others due to the additional table accesses.

GenerationType.UUID:

This strategy generates primary key values as UUIDs (Universally Unique Identifiers). UUIDs are globally unique identifiers.
Usage: When you want to ensure that primary keys are universally unique across distributed systems or when you don't want to rely on database-specific auto-generation mechanisms.


### Constraints
* ***Not null (JPA)***
  ```java
  @Column(nullable = false)
  private String username;
  ```
  Hibernate:
  ```SQL
  create table table_blogger (
     ...
     username varchar(255) not null,
  ```
* ***Unique***
  ```java
  @Column(nullable = false, unique = true)
  private String username;
  ```
  Hibernate:
  ```SQL
  alter table table_blogger 
    add constraint UK_ap2t1ctdrr06r9nyd09jtglan unique (username)
  ```

