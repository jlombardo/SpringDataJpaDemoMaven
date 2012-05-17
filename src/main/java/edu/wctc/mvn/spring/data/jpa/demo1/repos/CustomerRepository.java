package edu.wctc.mvn.spring.data.jpa.demo1.repos;

import edu.wctc.mvn.spring.data.jpa.demo1.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is where the magic of spring-data-jpa happens. Spring will create
 * real, proxy objects based on this interface. It performs introspection to
 * determine the C.R.U.D. methods and implementations needed.
 * <P>
 * You can expand on these methods by writing your own, using native JPA or
 * by using the spring-data-jpa DSL (domain specific language). See the 
 * spring-data-jpa documentation for more information.
 * <P>
 * Note that spring-data-jpa repository interfaces result in code that
 * essentially acts as a DAO (data access object).
 * 
 * @author jlombardo
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
