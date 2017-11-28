package org.home.apapacy.dao;

import java.util.List;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.home.apapacy.models.CustomerModel;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@Repository
public class CustomerDAO {
	
	@Autowired 
	private MongoOperations mongoOperations;

    public CustomerModel save(CustomerModel customer) {
    	this.mongoOperations.save(customer);
    	return customer;
    }
    

}