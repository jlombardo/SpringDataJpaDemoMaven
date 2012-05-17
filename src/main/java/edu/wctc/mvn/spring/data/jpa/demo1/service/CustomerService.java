package edu.wctc.mvn.spring.data.jpa.demo1.service;

import edu.wctc.mvn.spring.data.jpa.demo1.domain.Customer;
import edu.wctc.mvn.spring.data.jpa.demo1.repos.CustomerRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * An implementation of the ICustomerService contract. Note that this 
 * class is enhanced with Spring features for robust handling data access
 * exceptions (the "Repository" annotation) and transactions.
 * <P>
 * The <code>CustomerRepository</code> is the spring-data-jpa proxy object
 * that services as a DAO, while the <code>EntityManager</code> object is 
 * provided soley for use when native JPA commands are needed in the event
 * that the spring proxies don't offer needed functionality.
 * 
 * @author jlombardo
 */
@Repository
@Transactional(readOnly = true)
public class CustomerService implements ICustomerService {

    private final Logger LOG = LoggerFactory.getLogger(CustomerService.class);
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private CustomerRepository custRepo;
    
    @Override
    public List<Customer> getAllCustomers() throws DataAccessException {
        return custRepo.findAll();
    }

    @Modifying
    @Transactional(readOnly = false)
    @Override
    public void saveOrUpdate(Customer entity) throws DataAccessException {
        custRepo.save(entity);
    }
    
    @Modifying
    @Transactional(readOnly = false)
    @Override
    public void delete(Customer entity) throws DataAccessException {
        custRepo.delete(entity);
    }  
    
    @Modifying
    @Transactional(readOnly = false)
    @Override
    public void delete(Integer id) throws DataAccessException {
        custRepo.delete(id);
    }
    
}
