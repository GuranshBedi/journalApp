package net.journal.journalAPP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class JournalApp {

	public static void main(String[] args) {
		SpringApplication.run(JournalApp.class, args);
	}

	@Bean
	public PlatformTransactionManager add(MongoDatabaseFactory dBFactory){
		return new MongoTransactionManager(dBFactory);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
//RestAPI stands for Representational state transfer API
//@SpringBootApplication is the annotation for SpringBoot
//It does 3 functions @Configuration used on classes to create @Beans. @Beans are applied on method
//@ComponentScan Inside the package(First Line) it will scan and detect all components
//@EnableAutoConfiguration - sab khudse karlega bas dependecies daaldo pom.xml mein
//Methods inside a controller should be public so they can be invoked by spring or http requests
//RequestBody basically means that spring is converting this(data from this request)
// content into a java object
//While using POSTMAN , post requests are done in body using JSON format
//controller will call service which will call repository
//@Document will mark that class as a collection for mongodb
//fazceCwvi9GLH3w7
//SpringBoot Actuators is like our dashboard to seethe health of the website, server etc. Just add the dependency
//and you can access the end points.(Add a line in application.yml to access endpoints)
