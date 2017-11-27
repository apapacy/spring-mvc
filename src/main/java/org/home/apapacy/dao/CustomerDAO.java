package org.home.apapacy.dao;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.home.apapacy.models.CustomerModel;; 

public interface CustomerDAO extends MongoRepository<CustomerModel, String> {

    public CustomerModel findByFirstName(String firstName);
    public List<CustomerModel> findByLastName(String lastName);

}