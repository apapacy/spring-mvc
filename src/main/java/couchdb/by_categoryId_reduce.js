 
//by_categoryId_reduce.js
//_count
function(keys, values, rereduce) {
  if (rereduce) {
    return sum(values);
  } else {
    return values.length;
  }
}
 
