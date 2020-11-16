<?php
include_once '.php/AppSettings.php';
include_once 'httpCalls/CallHandler.php';
session_start();

#Initialize jwt token
if (!isset($_SESSION['jwt'])){ $_SESSION['jwt'] = ""; }

# Initialize callHandler object
if (!isset($_SESSION['callHandler'])) { $_SESSION['callHandler'] = new Handler($_BASE_URL);}

# When GET values are submitted
if (!empty($_GET)){ 
	$result = $_SESSION['callHandler'] -> get_call($_GET, $_SESSION['jwt']); 
}

# When POST values are submitted
if (!empty($_POST)){
	$result = $_SESSION['callHandler'] -> post_call($_POST, $_SESSION['jwt']);
	
	# If authentication post is made store jwt in session
	if (isset($result['jwt'])){ if (strlen($result['jwt']) === 129 ){ $_SESSION['jwt'] = $result['jwt'];} }
}

if ($_SESSION['jwt'] == "" ){ echo "JWT is not fetched, write test to Username and Password then Submit Query to fetch it!";}
else{ echo "JWT fetched! Now you can search books and movies...";}

?>

<html>
<body>
	<form action = "" method = "POST">
	Username: <input type = "text" name = "username" />
	Password: <input type = "text" name = "password" />
	<input type = "submit" />
	</form>
	
	<form action = "" method = "GET">
	Book ISBN: <input type = "text" name = "ISBN" />
	<input type = "submit" />
	</form>
	
	<form action = "" method = "GET">
	Movie title: <input type = "text" name = "movieTitle" />
	Movie year: <input type = "text" name = "movieYear" />
	Movie plot: <select name = "moviePlot">
			<option value = "" name = "" /></option>
			<option value = "short" name = "" />Short</option>
			<option value = "full" name = "" />Full</option>
		    </select>
	<input type = "submit" />
	</form>

</body>
</html>
