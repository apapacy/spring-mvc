package org.home.apapacy.models;

import org.ektorp.Attachment;
import org.ektorp.support.CouchDbDocument;

public class CouchDbBaseDocument extends CouchDbDocument {

   private static final long serialVersionUID = -9012014877538917152L;

   @Override
   public void addInlineAttachment(Attachment a) {
       super.addInlineAttachment(a);
   }   
}
