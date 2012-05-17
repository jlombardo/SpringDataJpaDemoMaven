package edu.wctc.mvn.spring.data.jpa.demo1.service;

import edu.wctc.mvn.spring.data.jpa.demo1.domain.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jlombardo
 */
public interface ICustomerService {

    @Modifying
    @Transactional(readOnly = false)
    void delete(Customer entity);

    @Modifying
    @Transactional(readOnly = false)
    void delete(Integer id);

    List<Customer> getAllCustomers();

    @Modifying
    @Transactional(readOnly = false)
    void saveOrUpdate(Customer entity);

}
