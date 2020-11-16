<?php
include_once 'httpCalls/Calls.php';

class Handler {

	function __construct($base_url){
		# Initialize caller objects
		$this -> getCaller = new GET($base_url);
		$this -> postCaller = new POST($base_url);
	}
	
	function get_call($get, $jwt){
		# Sets url and sends it to call object to make the call with jwt
		# Input:
		# 	$get:		$_GET variable from session
		# 	$jwt:		String, which contains the jwt
		# Output:
		# 	$response:	curl response from the caller

		# Book title url
		if (isset($get['ISBN'])){ 
			$url = "getBook/ISBN/" . strval($get['ISBN']);
		} 
		
		# Movie title url
		else if (isset($get['movieTitle'])){
			$url = "getMovie/";
			$t = strval($get['movieTitle']);
			$y = strval($get['movieYear']);
			$p = strval($get['moviePlot']);
			# Append values to url
			if (!empty($t)){ $url = $url . $t; }	
			if (!empty($y)){ $url = $url . "/" . $y; }
			if (!empty($p)){ $url = $url . "/" . $p; }
		}
		return $this -> getCaller -> makeRequest($url, $jwt);
	}

	function post_call($post, $jwt){
		# Sets url and sends it to call object to make the call with jwt
		# Input:
		# 	$post:		$_POST variable from session
		# 	$jwt:		String, which contains the jwt
		# Output:
		# 	$response:	curl response from the caller
		
		if (isset($post['username'])){
			$post_vars = array( 'username' => $post['username'], 'password' => $post['password']);
			$url = "authenticate";
		}
		return $this -> postCaller -> makeRequest($url, $post_vars, $jwt);
	}

}

?>
