app.factory('mainFactory', function($http) {
	
	var main = {};
	
	var _products = function(){
		return $http({method: 'GET', url: 'http://localhost:8080/products'})
		}
	
	var _save = function(product){
		return $http.post('http://localhost:8080/save', product);
	}
	
	var _edit = function(product){
		return $http.post('http://localhost:8080/edit', product);
	}
	
	var _getProduct = function(product_id){
		return $http.get('http://localhost:8080/edit/'+product_id);
	}
	
	var _delete = function(product_id){
		return $http.delete('http://localhost:8080/delete/'+product_id);
	}
	
	main.products = _products;
	main.save = _save;
	main.edit = _edit;
	main.getProduct = _getProduct;
	main.delete = _delete;
	
	return main;
});