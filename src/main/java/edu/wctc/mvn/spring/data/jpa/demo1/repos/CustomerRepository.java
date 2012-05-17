package edu.wctc.mvn.spring.data.jpa.demo1.repos;

import edu.wctc.mvn.spring.data.jpa.demo1.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jlombardo
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
