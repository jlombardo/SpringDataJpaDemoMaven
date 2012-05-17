package edu.wctc.mvn.spring.data.jpa.demo1;

import edu.wctc.mvn.spring.data.jpa.demo1.domain.Customer;
import edu.wctc.mvn.spring.data.jpa.demo1.service.ICustomerService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This is a simple demo of how to build a standalone Java application that 
 * communicates with a database using Spring-Data-Jpa. It also demonstrates
 * the use of Maven as a build system and slf4j and logback for state-of-
 * the-art logging.
 * 
 * IMPORTANT: Netbeans ships with a sample database called "Java DB" which
 * is also called "Derby". You must have the Derby "sample" database installed
 * and started before running this program.
 *
 */
public class App {
    public static void main( String[] args ) {

         // Get the Spring context so we can use the spring-managed objects
        ApplicationContext ctx = 
             new ClassPathXmlApplicationContext("applicationContext.xml");
        
        ICustomerService custService = 
                (ICustomerService)ctx.getBean("customerService");
                
        //Ask for and display the customer list
        List<Customer> customers = custService.getAllCustomers();
        
        for(Customer c : customers) {
            System.out.println(c);
        }
    }
}
