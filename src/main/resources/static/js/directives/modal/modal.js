var vfModal = angular.module('vfModal', []);
vfModal.directive('modal',function () {
    return {
        restrict:'EA',
        replace:true,
        transclude:true,
        scope:{
            title:'=',
            content:'=',
            ok:'&',
            cancel:'&',
            cancelable:'=',
            confirm:'&'
        },
        templateUrl:'modal.html'
    };
});
vfModal.controller('modalController',function ($scope) {
    $scope.cancel = function () {
        $('#vfmodal').modal('hide');
    };
    $scope.ok = $scope.cancel();
});