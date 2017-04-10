app.config(function($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix('');
    $routeProvider
    .when('/', {
        templateUrl: '../views/products.html',
        controller: 'mainController'
    });
});