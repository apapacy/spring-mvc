function (doc) {
  var tokens = doc.dateEffective.split("-");
  var year = null;
  var month = null;
  if(tokens.length == 3) {
    year = tokens[0];
    month = tokens[1];
  }
  var key = [doc.clientId, doc.categoryId, doc.subCategoryId, year, month].concat(doc.title);
  var value = null;
  emit(key, value);
}
