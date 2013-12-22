require.config({
    paths: {
        jquery: ['/components/jquery-1.10.2.min'],
        bootstrap: ['/components/bootstrap.min']
    },
    shim : {
        bootstrap: ['jquery']
    }
});