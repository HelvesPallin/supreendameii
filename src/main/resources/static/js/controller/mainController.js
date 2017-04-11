app.controller("mainController", function($scope, $window, $routeParams, mainFactory){
	
	$scope.products = new Array();
	
	$scope.product = new Object();
	
	$scope.product_id = null;
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
	
	$scope.initEdit = function(){
		mainFactory.getProduct($routeParams.product_id).then(function(res){
			$scope.product_id = res.data.product_id;
			$scope.product_name = res.data.product_name;
			$scope.product_patrimony = res.data.product_patrimony;
			$scope.product_desc = res.data.product_desc;
		}).catch(function(error) {
			$window.alert(error.data.message);
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
            	
                $window.location.href="../../";
            	
            }
            else{

                $window.alert(res.data.message);

            }
		}).catch(function(error) {
			$window.alert(error.data.message);
		});
	}
	
	$scope.edit = function(){

		var product = new Object();
		
		product.product_id = $scope.product_id;
		product.product_name = $scope.product_name;
		product.product_patrimony = $scope.product_patrimony;
		product.product_desc = $scope.product_desc;
		
		mainFactory.edit(product).then(function(res){
			if(res.data.code == 1){

                $window.alert(res.data.message);
                
                $window.location.href="../";
            }
            else{

                $window.alert(res.data.message);

            }
		}).catch(function(error) {
			$window.alert(error.data.message);
		});
	}
	
	$scope.delete = function(product_id){
		if($window.confirm("Are you sure?")){
			mainFactory.delete(product_id).then(function(res){
				$scope.init();
			}).catch(function(error) {
				$window.alert(error.data.message);
			});
		}
		
	}
});