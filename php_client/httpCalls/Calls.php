<?php

class GET {
	
	public $base_url;
	public $content_style;
	public $response_status;
	
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


	function makeRequest($url_end) {
		# Makes a GET call with curl
		# Inputs:
		# 	$url_end:		String, ending to the base url

		# Initialize curl
		$curl = curl_init($this -> base_url . $url_end);
		
		# Set headers to http call
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		curl_setopt($curl, CURLOPT_HTTPHEADER, [
			'Content-Type: application/json'
		]);

		# Execute the call
		$response = curl_exec($curl);
		
		# Parse the json into html
		echo "<table>";
		self::makeTable(json_decode($response, true), false);
		echo "</table>";
	}
}

?>
