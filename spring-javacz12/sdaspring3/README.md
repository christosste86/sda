## Sorting & Pagination

---

* Repository must implement [`PagingAndSortingRepository`](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/PagingAndSortingRepository.html) (`JpaRepository` already does)
* Example entity:
  ```java
    @Entity
    @ToString
    @Getter @Setter
    public class Post {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idOfThis;
    
        private String text;
    
        @CreationTimestamp
        private LocalDateTime created;
    }
  ```

### Sorting

* Example - Select from *Post* table, where *Post.text* contains substring, ordered by *Post.text* desceding:
  SQL:
  ```sql
  SELECT * FROM `post` WHERE `text` LIKE '%a%' ORDER BY `text` DESC;
  ```
  `PostRepository.java`:
  ```java
  List<Post> findAllByTextContains(String substring, Sort sort);
  ```
  Usage of [`Sort`](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/domain/Sort.html):
  ```java
  List<Post> posts = postRepository.findAllByTextContains("a", Sort.by("text").descending());
  ```
  Generated SQL query:
  ```sql
  SELECT
    post0_.id_of_this AS id_of_th1_0_,
    post0_.created AS created2_0_,
    post0_.text AS text3_0_
  FROM
    post post0_
  WHERE
    post0_.text LIKE '%a%' ESCAPE '\'
  ORDER BY post0_.text DESC
  ```
### Pagination

* Example - Select *Posts* from table *page-by-page* - not everything at once, by taking advantage of SQL syntax `LIMIT offset, count`

  SQL
  ```sql
  SELECT * FROM `post` WHERE `text` LIKE '%a%' LIMIT 0, 10;
  ```
  `PostRepository.java`:
  ```java
  Page<Post> findAllByTextContains(String substring, Pageable pageable);
  ```
  Usage of [`Pageable`](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/domain/Pageable.html):
  ```java
  Page<Post> posts = postRepository.findAllByTextContains("a", PageRequest.of(0, 5));
  ```
  Generated SQL query:
  ```sql
  select post0_.id_of_this as id_of_th1_0_, post0_.created as created2_0_, post0_.text as text3_0_ from post post0_ where post0_.text like '%a%' escape '\\' limit 5;
  select count(post0_.id_of_this) as col_0_0_ from post post0_ where post0_.text like '%a%' escape '\\';
  ```
  
### Pagination & Sorting

* Example - Select from *Post* table, where *Post.text* contains substring, ordered by *Post.text* desceding, *Post.idOfThis* ascending, page-by-page:
  ```java
  Pageable pageable = PageRequest.of(0, 10, Sort.by("text").descending().and(Sort.by("idOfThis").ascending()));
  Page<Post> posts;

  do {
      posts = postRepository.findAllByTextContains(str, pageable);
      posts.forEach(System.out::println);
      // Move to the next page
      pageable = pageable.next();
  
  // Stop when current page == total number of pages
  } while (posts.getTotalPages() > pageable.getPageNumber());
  ```
  Generated SQL queries:
  ```sql
  select post0_.id_of_this as id_of_th1_0_, post0_.created as created2_0_, post0_.text as text3_0_ from post post0_ where post0_.text like '%a%' escape '\\' order by post0_.text desc, post0_.id_of_this asc limit 10
  select count(post0_.id_of_this) as col_0_0_ from post post0_ where post0_.text like '%a%' escape '\\'
  select post0_.id_of_this as id_of_th1_0_, post0_.created as created2_0_, post0_.text as text3_0_ from post post0_ where post0_.text like '%a%' escape '\\' order by post0_.text desc, post0_.id_of_this asc limit 10, 10
  select count(post0_.id_of_this) as col_0_0_ from post post0_ where post0_.text like '%a%' escape '\\'
  select post0_.id_of_this as id_of_th1_0_, post0_.created as created2_0_, post0_.text as text3_0_ from post post0_ where post0_.text like '%a%' escape '\\' order by post0_.text desc, post0_.id_of_this asc limit 20, 10
  ```

### Note

* You don't have to specify overloads for sorting and pagination for already supported methods by `PagingAndSortingRepository` interface. They are alredy defined:
  ```java
  Iterable<T> findAll(Sort sort);
  Page<T> findAll(Pageable pageable);
  ```

### Pagination and Thymeleaf

* Moving on the next page and previous page in view:

  Endpoint:
  ```java
  model.addAttribute("posts", postRepository.findAll(PageRequest.of(pageNumber, 10));
  model.addAttribute("currentPage", pageNumber);
  ```
  View:
  ```html
  <a th:if="${currentPage > 0}" th:href="@{/show(page=${currentPage - 1})}">Previous</a>
  <a th:if="${currentPage + 1 < posts.totalPages}" th:href="@{/show(page=${currentPage + 1})}">Next</a>
  ```

## Spring Security Quickguide

* Turn off security: `@SpringBootApplication(exclude = SecurityAutoConfiguration.class)`
* Build project with **Spring security** dependency
* [Dan Vega's amazing intro to Spring Security](https://www.danvega.dev/docs/spring-boot-2-docs/#_spring_security)

### Data model
1) Create entity for storing users, which implements [`UserDetails`](https://docs.spring.io/spring-security/site/docs/4.2.3.RELEASE/apidocs/org/springframework/security/core/userdetails/UserDetails.html)`:
    ```java
    @Entity
    @Getter @Setter
    public class User implements UserDetails {
        ...
        private String username;
  
        @Column(length = 100)
        private String password;
  
        private boolean enabled;
  
        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(
                name = "users_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id")
        )
        private Set<Role> roles = new HashSet<>();
            
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());
        }
        ...
    }
    ```
2) Create entity for users' roles:
    ```java
    @Entity
    @Getter @Setter
    public class Role {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        private String name;
    
        @ManyToMany(mappedBy = "roles")
        private List<User> users;
    }
    ```

### Service layer implementation
3) Implement interface [`UserDetailsService`](https://docs.spring.io/spring-security/site/docs/4.2.3.RELEASE/apidocs/org/springframework/security/core/userdetails/UserDetailsService.html),
   which provides `UserDetails`:
    ```java
    @Service
    @RequiredArgsConstructor
    public class UserDetailServiceImpl implements UserDetailsService {
        private final UserRepository userRepository;
    
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<User> user = userRepository.findByUsername(username);
    
            if (user.isEmpty()) {
                throw new UsernameNotFoundException(username);
            }
    
            return user.get();
        }
    }
    ```
### Provide custom web security implementation
4) Provide custom implementation of [`WebSecurityConfigurerAdapter`](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/configuration/WebSecurityConfigurerAdapter.html)
    ```java
    @Configuration
    @EnableWebSecurity
    @RequiredArgsConstructor
    public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
        private final UserDetailsService userDetailsService;
    
        @Bean
        public PasswordEncoder encoder() {
            return new BCryptPasswordEncoder();
        }
    
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService);
        }
    
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/posts/**").hasRole("USER")
                    .antMatchers("/**").permitAll()
                    .and()
                    .formLogin()
                    .and()
                    .logout();
        }
    }
    ```

### How to

#### Log in & Log out
Navigate to `/login` and `/logout`.

#### Register new user
Saving new user is simple. Just make sure to handle password properly:

```java
private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;

public void registerUser(String username, String password) throws UserAlreadyExistException {
    if (userRepository.findByUsername(username).isPresent()) {
        throw new UserAlreadyExistException(String.format("User %s already exists", username));
    }

    Role role = new Role();
    role.setName("ROLE_USER");

    User user = new User();
    user.setUsername(username);
    user.setEnabled(true);
    user.addRole(role);
    user.setPassword(passwordEncoder.encode(password));

    userRepository.save(user);
}
```