package org.home.apapacy.dao;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
 
public class CouchDbBaseDAO<T> extends CouchDbRepositorySupport<T> {
  
    protected CouchDbBaseDAO(Class<T> type, CouchDbConnector db) {
        super(type, db);
    }
 
    public CouchDbConnector getDb() {
        return super.db;
    }   
}