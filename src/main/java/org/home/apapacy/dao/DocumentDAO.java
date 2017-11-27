package org.home.apapacy.dao;

import java.io.InputStream;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.ektorp.CouchDbConnector;
import org.ektorp.Page;
import org.ektorp.PageRequest;
import org.ektorp.support.View;
import org.ektorp.ViewQuery; 
// import org.ektorp.ViewResult; 
// import org.ektorp.ViewResult.Row; 
import org.ektorp.support.GenerateView;
import org.home.apapacy.models.Document;


@Component
public class DocumentDAO  extends CouchDbBaseDAO<Document> {
     
     
    @Autowired
    public DocumentDAO(@Qualifier("dmsDatabase") CouchDbConnector db) {
        super(Document.class, db);
        initStandardDesignDocument();
    }
 
    @GenerateView
    @Override
    public List<Document> getAll() {
        ViewQuery q = createQuery("all")
                        .includeDocs(true);
        return db.queryView(q, Document.class);
    }
     
    public Page<Document> getAll(PageRequest pr) {
        ViewQuery q = createQuery("all")
                        .includeDocs(true);
        return db.queryForPage(q, pr, Document.class);
    }
     
    @View( name = "tree", map = "classpath:/couchdb/tree_map.js", reduce = "classpath:/couchdb/tree_reduce.js")
    public InputStream getTree(String startKey, String endKey, int groupLevel) {
        ViewQuery q = createQuery("tree")
        .startKey(startKey)
        .endKey(endKey)
        .groupLevel(groupLevel)
        .group(true);
        InputStream is = db.queryForStream(q);
        return is;
    }
 
}