function (doc) { 
 if(doc.title && doc.categoryId) {
  emit(doc.categoryId, doc._id);
 } 
}
