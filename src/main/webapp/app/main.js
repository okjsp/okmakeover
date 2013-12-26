require.config({
    baseUrl: '/app',
    paths: {
        jquery: ['//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min', '/components/jquery-1.10.2.min'],
        bootstrap: ['//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min','/components/bootstrap.min']
    },
    shim : {
        bootstrap: {
            deps: ['jquery']
        }
    }
});