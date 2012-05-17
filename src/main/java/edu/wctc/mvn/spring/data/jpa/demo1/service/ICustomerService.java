package edu.wctc.mvn.spring.data.jpa.demo1.service;

import edu.wctc.mvn.spring.data.jpa.demo1.domain.Customer;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

/**
 * The general contract for customer-oriented service implementations.
 * 
 * @author jlombardo
 */
public interface ICustomerService {

    @Modifying
    @Transactional(readOnly = false)
    void delete(Customer entity) throws DataAccessException;

    @Modifying
    @Transactional(readOnly = false)
    void delete(Integer id);

    List<Customer> getAllCustomers() throws DataAccessException;

    @Modifying
    @Transactional(readOnly = false)
    void saveOrUpdate(Customer entity) throws DataAccessException;

}
