<?php
include 'httpCalls/Calls.php';
include '.php/AppSettings.php';
# Initialize GET Objects for movie and book
$bookGetCaller = new GET($_BASE_URL);
$movieGetCaller = new GET($_BASE_URL);

# When ISBN is submitted make the request to Book API
if (isset($_GET['ISBN'])){ $bookGetCaller->makeRequest("getBook/ISBN/" . strval($_GET['ISBN'])); }

# When Movie title is submitted make the request to Movie API
if (isset($_GET['movieTitle'])){ $bookGetCaller->makeRequest("getMovie/title/" . strval($_GET['movieTitle'])); }
?>

<html>
<body>
	<form action = "" method = "GET">
	Book ISBN: <input type = "text" name = "ISBN" />
	<input type = "submit" />
	</form>
	
	<form action = "" method = "GET">
	Movie title: <input type = "text" name = "movieTitle" />
	<input type = "submit" />
	</form>

</body>
</html>
