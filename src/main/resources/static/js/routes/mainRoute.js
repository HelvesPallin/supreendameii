app.config(function($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix('');
    $routeProvider
    .when('/', {
        templateUrl: '../views/products.html',
        controller: 'mainController'
    })
    .when('/add', {
        templateUrl: '../views/productAdd.html',
        controller: 'mainController'
    })
    .when('/edit/:product_id', {
    	templateUrl: '../views/productEdit.html',
        controller: 'mainController'
    });
});