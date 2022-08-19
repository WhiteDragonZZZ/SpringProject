#Student Result Processing System

Features:
- The grading system is user configurable.
- The examination system is user configurable.
- The system provides examinations-weight age handling.
- There is provision of calculated as well as average column management.
- The system provides management of grace marks.
- Sub-subjects marks can be entered and managed in the system as user
desires.
- There is a special analysis section in the system which can be used for
various purposes.
  

My views of realisation this final exam. I created prototype dl system. Where i created to need classes
I have 3 main controllers,which divided by roles. Student can look own id and update own information
Teacher can look all list of Student. Teacher can update Student,add Student and delete
In the end Admin can manage everyone. 

##My entity

Teacher | Student | Admin | Faculty | Proctor | Subject | Exam | Audience
| :--- | ---: | :---: | :---: | :---: | :---: | :---: | :---:
id  | id | id  | id | id | id | id | subject_id
name  | name | name| name | name | name | name | teacher_id
role  | password | password| amount | work | credits | status | audience
hours  | grade | role| list of students | list of exam | status
 . | role 


###1. Create a database in postgres or use h2 in memory database. Create 7 entity
   tables, where should be One-to-one, One-to-many, many-to-many
   relationships (join table won’t be counted as entity table). Create a
   DATABASE UML diagram. Upload your diagram with project as PDF file.
   FILE SHOULD BE LOCATED INSIDE YOUR PROJECT FOLDER
###2. Upload database backup file with your project, if you use postgres database.
   Name your database – {$your_variant_{$your_lastname}}. For example
   variant2_Akimbayev.tar
   spring.datasource.url=jdbc:postgresql://localhost:5432/ variant2_
   Akimbayev
###3. Create Readme.MD file in project structure. In this file write your project's
###4. Use different type of beans annotations.
````
First type bean
@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.postgresql.Driver");
			dataSource.setUrl("jdbc:postgresql://localhost:5432/variant2_Akimbayev");
			dataSource.setUsername("postgres");
			dataSource.setPassword("admin");

		return dataSource;
	}
````
````
Second type bean
<bean id="transactionManager"
class="org.springframework.orm.hibernate5.HibernateTransactionManager">
<property name="sessionFactory" ref="sessionFactory"/>
</bean>
````

###5. Use different type of Dependency Injections. (ONLY CONSTRUCTOR and
   Setter injection. NO FIELD injection)

![](C:\Users\Zhassulan\Pictures\Screenshots\auto.png)
![](C:\Users\Zhassulan\Pictures\Screenshots\auto2.png)
###6. Write good service logic in service classes. (If your most port of code will
   consist only calling repo method, -50% from your grade)
###7. Use next annotations: @Profile, @PostConstruct, @PreDestroy
![](C:\Users\Zhassulan\Pictures\Screenshots\auto3.png)
![](C:\Users\Zhassulan\Pictures\Screenshots\auto4.png)
###8. Add at least 4 configuration classes.
![](C:\Users\Zhassulan\Pictures\Screenshots\auto5.png)

###9. Add AOP configuration. Use AspectJ annotation style.
````

@Configuration
@ComponentScan("com.example.finalspring")
@EnableAspectJAutoProxy
public class ConfigAop {

}
````
###10.Use next annotations: @Before, @Pointcut, @After, @Aspect,
   @AfterReturning, @Around, @AfterThrowing. 
###11.Add real service/business logic in AOP code.

````
@Component
@Aspect
public class LoggingAspect {

	@Pointcut("execution(* delete*(..))")
	private void deleteAllMethods(){};

	@Before("execution(public * getTeacher(..))")
	public void beforeGetAllTeacher() {
		System.out.println("beforeGetAllTeacher:подготовка к получению всех работников");
	}

	@Around("execution(* com.example.finalspring.repository.*.*(..))")
	public Object aroundAllRepositoryMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		MethodSignature methodSignature =(MethodSignature) proceedingJoinPoint.getSignature();
		String methodName = methodSignature.getName();
		System.out.println("Begin with " + methodName);
		Object targetMethodResult = proceedingJoinPoint.proceed();
		System.out.println("End of "+ methodName);
		return targetMethodResult;
	}


	@After("deleteAllMethods()")
	public void AfterDeleteMethod() {
		System.out.println("Удаление прошло успешно");
	}


	@AfterReturning("execution(* getStudent(..))")
	public void afterReturningGetStudentLoggingAdvice() {
		System.out.println("afterReturning:логируем получение" + " списка студентов после вызова");
	}


	@AfterThrowing(value = "execution(* getStudent(..))",throwing = "exception")
	public void afterThrowingGetStudentLogging(Throwable exception) {
		System.out.println("afterThrowingGetStudentLogging "+"исключения "+ exception);
	}
}
````
###12.Add new hibernate configurations. Use different and more complex
   methods/code for SessionFactory interface. DON’T USE JPA
   Repositories.

````
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.finalspring")
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
public class SpringConfig {


	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.postgresql.Driver");
			dataSource.setUrl("jdbc:postgresql://localhost:5432/variant2_Akimbayev");
			dataSource.setUsername("postgres");
			dataSource.setPassword("admin");

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean sessionFactory =  new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.example.finalspring.entity");
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect"
				,"org.hibernate.dialect.PostgreSQL81Dialect");
		hibernateProperties.setProperty("hibernate.show_sql"
				,"true");
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}
}
````
###13.Use batch operations.
````
@Configuration
@EnableBatchProcessing
public class BatchConfig {
}
````

###14.Add cache configuration.
````
@Configuration
@EnableCaching
public class CacheConfig {
}
````
###15.Change transaction level.
````
@Override
@Transactional(rollbackForClassName = {"NullPointerException"})
public void addExam(Exam exam) {
examRepository.addNewProctor(exam);
}
````
###16.Use ALL next annotations:
![](C:\Users\Zhassulan\Pictures\Screenshots\auto6.png)
````
@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "faculty_id")
	private Faculty faculty;

````
![](C:\Users\Zhassulan\Pictures\Screenshots\auto7.png)
````
@Entity
@Table(name = "faculty")
@Component
public class Faculty {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "amount")
	private int amount;


	@OneToMany(cascade = CascadeType.ALL,mappedBy = "faculty")
	private List<Student> students;
````

````
@Entity
@Table(name = "subject")
public class Subject {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "credits")
	private int credits;

	@Column(name = "status")
	private String status;


	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "audience",
			joinColumns = @JoinColumn(name = "subject_id")
			,inverseJoinColumns = @JoinColumn(name = "teacher_id")
	)
	List<Teacher> teachers;
````

````
@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "role")
	private String role;

	@Column(name = "hours")
	private int hours;


	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "audience",
			joinColumns = @JoinColumn(name = "teacher_id")
			,inverseJoinColumns = @JoinColumn(name = "subject_id")
	)
	private List<Subject> subjects;

````
###17.Implement Global Transactions with JTA
###18.Create a Custom Validator (javax.validation.ConstraintValidator)
![](C:\Users\Zhassulan\Pictures\Screenshots\auto8.png)
````
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckNameValidator.class)
public @interface CheckName {
	public String value() default "A";
	public String message() default "Began with uppercase";

	public Class<?>[] groups() default {};
	public Class<? extends Payload> [] payload() default {};
}

public class CheckNameValidator implements ConstraintValidator<CheckName,String> {

	private String beganName;

	@Override
	public void initialize(CheckName constraintAnnotation) {
		beganName = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String enterValue, ConstraintValidatorContext constraintValidatorContext) {

		return enterValue.startsWith(beganName);
	}
}

````
###19.Write scheduled method. Use @Scheduled annotations with attributes:
- fixedDelay
- fixedRate
- initialDelay
###20.Schedule a Task Using Cron Expressions
````

@Component
public class ScheduleConfig {
	Logger logger = Logger.getLogger("ScheduleConfig");

	@Scheduled(fixedRate = 20000)
	public void Schedule() {
		logger.info("FixedRate is run");
	}

	@Scheduled(fixedDelay = 10000)
	public void ScheduleDelay() {
		logger.info("FixedDelay is run");
	}

	@Scheduled(initialDelay = 10000,fixedDelay = 10000)
	public void ScheduleInitialDelay() {
		logger.info("FixedInitialDelay is run");
	}

	@Scheduled(cron = "0/15 * * * * *")
	public void ScheduledCron() {
		logger.info("Cron work");
	}
}

````
###21.Use all next methods:
###22.Use next annotations
````
@RestController
@RequestMapping("/admin/api")
public class AdminController {
	private final ProctorService proctorService;
	private final StudentService studentService;
	private final TeacherService teacherService;



	@Autowired
	private ExamService examService;

	@Autowired
	public AdminController(ProctorService proctorService, StudentService studentService, TeacherService teacherService) {
		this.proctorService = proctorService;
		this.studentService = studentService;
		this.teacherService = teacherService;
	}


	@GetMapping("/proctor/{id}")
	public Proctor getProctor(@PathVariable int id) {
		return proctorService.getProctor(id);
	}

	@PostMapping("/addProctor")
	public Proctor addProctor(@RequestBody Proctor proctor) {
		proctorService.addProctor(proctor);
		return proctor;
	}

	@PostMapping("/addExam")
	public Exam addExam(@RequestBody Exam exam) {
		examService.addExam(exam);
		return exam;
	}

	@GetMapping("/students")
	public List<Student> showAllStudents() {
		List<Student> allStudents = studentService.getAllStudent();
		return allStudents;
	}

	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);

		return "Student with ID = "+ id + " was deleted";
	}

	@GetMapping("/teachers")
	public List<Teacher> showAllTeachers() {
		List<Teacher> allTeachers = teacherService.getAllTeacher();
		return allTeachers;
	}

	@GetMapping("/teacher/{id}")
	public Teacher getTeacher(@PathVariable int id) {
		Teacher teacher = teacherService.getTeacher(id);
		if (teacher == null) {
			throw new NoSuchTeacherException("There is no teacher with ID = "+id + " in Database");
		}
		return teacher;
	}


	@PutMapping("/updateTeacher")
	public Teacher updateTeacher(@RequestBody Teacher teacher) {
		teacherService.updateTeacher(teacher);
		return teacher;
	}

	@PostMapping("/addTeacher")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		teacherService.addTeacher(teacher);
		return teacher;
	}

	@DeleteMapping("/deleteTeacher/{id}")
	public String deleteTeacher(@PathVariable int id) {
		teacherService.deleteTeacher(id);
		return "Teacher with ID " + id + "was deleted";
	}
}

````
###23.Use RequestBody and ResponseBody Annotations. Read HTTP Headers in Spring REST Controllers.
###24.Use Spring @ResponseStatus to Set HTTP Status Code. Use Spring ResponseEntity to Manipulate the HTTP Response
###25.Add Error Handling for REST with Spring
![](C:\Users\Zhassulan\Pictures\Screenshots\auto9.png)

###26.Setting Up Swagger 2 with a Spring REST API
````
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
}
````
###27.Add JUnit test with at least 80% code coverage.
![](C:\Users\Zhassulan\Pictures\Screenshots\auto10.png)
###28.Use Apache Kafka four your JMS service.
(https://www.baeldung.com/spring-kafka)
###29.Use Spring Security JWT Authentication.
###30.DO NOT USE in memory authentication (auth.inMemoryAuthentication())
###31.Use Spring Security Remember Me
###32.Use Custom AuthenticationFailureHandler
###33.Add 1-2 pages which supports websocket technology ONLY with
RabbitMQ websocket external stomp support. Example -
https://www.baeldung.com/websockets-spring.
###34.Write CURL in README.md for your ALL endpoints, or upload in
project folder POSTMAN collections.
````
StudentController
one student
curl --location --request GET 'http://localhost:8080/api/student/students/1'
two student
curl --location --request GET 'http://localhost:8080/api/student/students/1000'
curl --location --request PUT 'http://localhost:8080/api/student/updateStudent' \
--header 'Content-Type: application/json' \
--data-raw '{
        "id": 4,
        "name": "Update Zhanik",
        "password": "admin1236",
        "grade": 2.9,
        "role": "student"
    }'
    
TeacherController
curl --location --request GET 'http://localhost:8080/staff/api/students'
curl --location --request POST 'http://localhost:8080/staff/api/addStudent' \
--header 'Content-Type: application/json' \
--data-raw ' {
        "id": 2,
        "name": "Zhassulan",
        "password": "admin123",
        "grade": 3.5,
        "role": "admin"
    }'
curl --location --request DELETE 'http://localhost:8080/staff/api/deleteStudent/4'

ADMIN CONTROLLER
curl --location --request GET 'http://localhost:8080/admin/api/proctor/1'

curl --location --request POST 'http://localhost:8080/admin/api/addProctor' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 10,
    "name": "Abdukarim",
    "work": "part",
    "exam": {
        "id": 1,
        "name": "Web",
        "status": "Active"
    }
}'

curl --location --request GET 'http://localhost:8080/admin/api/students' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 10,
    "name": "Abdukarim",
    "work": "part",
    "exam": {
        "id": 1,
        "name": "Web",
        "status": "Active"
    }
}'

http://localhost:8080/admin/api/teachers


curl --location --request POST 'http://localhost:8080/admin/api/addTeacher' \
--header 'Content-Type: application/json' \
--data-raw '{
        "id": 30,
        "name": "NEw Teacher",
        "role": "TEACHER",
        "hours": 8
    }'
    
    
````