app.controller("mainController", function($scope, $window, mainFactory){
	
	$scope.products = new Array();
	
	$scope.product_name = null;
	$scope.product_patrimony = null;
	$scope.product_desc = null;	
	
	$scope.init = function(){
		
		mainFactory.products().then(function(res){
			$scope.products = res.data;
		}).catch(function(error){
			$window.alert(error);
		});
	}
	
	$scope.save = function(){
		
		var product = new Object();
		
		product.product_name = $scope.product_name;
		product.product_patrimony = $scope.product_patrimony;
		product.product_desc = $scope.product_desc;
		
		mainFactory.save(product).then(function(res){
			if(res.data.code == 1){

                $window.alert(res.data.message);

                $scope.product_name = null;
            	$scope.product_patrimony = null;
            	$scope.product_desc = null;	
            }
            else{

                $window.alert(res.data.message);

            }
		}).catch(function(error) {
			$window.alert(error.data.message);
		});
	}
});