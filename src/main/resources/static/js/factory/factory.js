app.factory('mainFactory', function($http) {
	
	var main = {};
	
	var _products = function(){
		return $http({method: 'GET', url: 'http://localhost:8080/products'})
		}
	
	var _save = function(product){
		return $http.post('http://localhost:8080/save', product);
	}
	
	main.products = _products;
	main.save = _save;
	
	return main;
});