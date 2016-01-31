(function () {
  'use strict';

  /**
   *
   * Main module of the application.
   */
  angular
    .module('ekam-app', [
      'ngAnimate',
      'ngCookies',
      'ngMessages',
      'ngSanitize',
      'ngTouch',
      'ngIdle',
      'ui.router',
      'ui.bootstrap',
      'angular-bugsnag'
    ])
    .config(['$urlRouterProvider', function($urlRouterProvider) {
      $urlRouterProvider.otherwise('/');
    }]);

}());
