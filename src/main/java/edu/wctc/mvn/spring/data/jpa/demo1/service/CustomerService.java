package edu.wctc.mvn.spring.data.jpa.demo1.service;

import edu.wctc.mvn.spring.data.jpa.demo1.domain.Customer;
import edu.wctc.mvn.spring.data.jpa.demo1.repos.CustomerRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
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
    public List<Customer> getAllCustomers() {
        return custRepo.findAll();
    }

    @Modifying
    @Transactional(readOnly = false)
    @Override
    public void saveOrUpdate(Customer entity) {
        custRepo.save(entity);
    }
    
    @Modifying
    @Transactional(readOnly = false)
    @Override
    public void delete(Customer entity) {
        custRepo.delete(entity);
    }  
    
    @Modifying
    @Transactional(readOnly = false)
    @Override
    public void delete(Integer id) {
        custRepo.delete(id);
    }
    
}
