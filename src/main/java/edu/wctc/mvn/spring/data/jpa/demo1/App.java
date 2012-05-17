package edu.wctc.mvn.spring.data.jpa.demo1;

import edu.wctc.mvn.spring.data.jpa.demo1.domain.Customer;
import edu.wctc.mvn.spring.data.jpa.demo1.service.ICustomerService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        ApplicationContext ctx = 
             new ClassPathXmlApplicationContext("applicationContext.xml");
        
        ICustomerService custService = 
                (ICustomerService)ctx.getBean("customerService");
                
        List<Customer> customers = custService.getAllCustomers();
        
        for(Customer c : customers) {
            System.out.println(c);
        }
    }
}
