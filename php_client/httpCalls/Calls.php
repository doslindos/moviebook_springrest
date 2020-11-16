<?php

class GET {
	
	public $base_url;
	
	# Initializes the class base url
	function __construct($base_url) {
		$this -> base_url = $base_url;
	}
	
	function makeTable($variable_list, $rec=false){
		# Parses the json data into html table
		# Inputs:
		# 	$variable_list:		Array
		# 	$rec:			bool, tells the function if it's recursive call
		
		foreach($variable_list as $k=>$v){
			# If variable in the array is not another array
			if (!is_array($v)){
				
				# When value is null, display No data
				if ($v == null){$v = "No data";}
				
				# If function call is not recursive, the keys are "main" keys
				# so they are displayed with bigger font
				if ($rec === false){
					echo "<tr><td style='font-size: 20px;'>$k</td><td>$v</td><tr>"; }
			       	else {echo "<tr><td>$k</td><td>$v</td><tr>"; }
			
			}

			# If variable is an array make another loop to get also the values
			# from subarrays
			else {
				if (!is_int($k)) {echo "<tr><td style='font-size: 20px;'>$k";}
				self::makeTable($v, true);
				if (!is_int($k)) {echo "</td></tr>"; }
				}
			}	
		}


	function makeRequest($url_end, $jwt) {
		# Makes a GET call with curl
		# Inputs:
		# 	$url_end:		String, ending to the base url
		# 	$jwt:			String
		
		# Initialize curl
		$curl = curl_init($this -> base_url . $url_end);
		
		# Set options and headers to curl
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		curl_setopt($curl, CURLOPT_FAILONERROR, true);
		curl_setopt($curl, CURLOPT_HTTPHEADER, [
			'Accept: application/json',
			'Content-Type: application/json',
			'Authorization: Bearer ' . $jwt
		]);

		# Execute the call
		$response = curl_exec($curl);

		# Display error
		if (curl_errno($curl)) {
			echo curl_error($curl);
		}

	       	# Make the table if no errors	
		else {
			# Parse the json into html
			echo "<table>";
			self::makeTable(json_decode($response, true), false);
			echo "</table>";
		}	

		return $response;
	}
}

class POST {
	
	public $base_url;
	
	# Initializes the class base url
	function __construct($base_url) {
		$this -> base_url = $base_url;
	}
	
	function makeRequest($url_end, $post_fields) {
		# Makes a POST call with curl
		# Inputs:
		# 	$url_end:		String, ending to the base url
		# 	$post_fields:		array, fields to add into the post
		
		# Convert postable fields	
		$post_fields = json_encode($post_fields);
		
		# Initialize curl
		$curl = curl_init($this -> base_url . $url_end);

		# Set options and headers for curl call
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		curl_setopt($curl, CURLOPT_FAILONERROR, true);
		curl_setopt($curl, CURLOPT_POST, true);
		curl_setopt($curl, CURLOPT_HTTPHEADER, [
			'Content-Type: application/json'
		]);
		
		# Set fields to curl
		curl_setopt($curl, CURLOPT_POSTFIELDS, $post_fields);


		# Execute the call
		$response = curl_exec($curl);
		# Convert the returned json string into an array
		$response_list = json_decode($response, true);
		
		return $response_list;

	 }
}
?>
