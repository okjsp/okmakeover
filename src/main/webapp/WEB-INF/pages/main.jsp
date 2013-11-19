<html>
<head>
    <meta name="decorator" content="basic" />
</head>
<body>
	<p>${message}</p>

    <ul>
        <li>/sample</li>
    </ul>

    <script>

        $('li').click(function() {
            window.location.href = $(this).text();
        })
    </script>
</body>
</html>