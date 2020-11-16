# Spring REST Application + PHP client for it

## Spring
* Tested with Java 8 and gradle

<br />In terminal, inside projects folder "moviebookapp" run:<br /> `gradlew bootRun` to start the Spring REST API.
<br />Once Spring is running (leave it running for PHP client or curl to work) 
you can access the API with PHP client or using cUrl.
<br />Both ways have a minimalistic guide below.

## PHP client
* Tested with PHP 7.4.11

<br />In a new terminal, inside projects folder "php_client" run:<br /> `php -S localhost:8080 index.php`
to start the php server with index.php template.
<br />Next go to your browser and type address localhost:8080
<br />The small and uncolorful page should be now in front of you.
<br />Before fetching movies or books you must fetch the Json Web Token.
<br />This is done by writing on the Username field "test" and on the Password field
the most secure password I did come up with, it is: "test".
<br />Now you can enrich your life by fetching book information if you know the ISBN code.
<br />ISBN code is 10 digits and here are some examples you can try it out with:
<br />0375751548
<br />221285045X
<br />1425034489 
<br />If books are not your thing but you are in dire need of some movie information, well look no
further... this amazing service can provide it for you too!
<br />You need to pass in title of a movie to search for but you can also provide year.
<br />If you thought that those were your only options to work with, think again.
<br />You can also change the value of plot information from Short to Full.
<br />If you for some reason are sceptic about using PHP for this and you enjoy reading your 
book and movie information from the commandline, well there is no better cure for it than trying out
the application with cUrl.

## cUrl
<br />Because this is the more wilder approach you can open your commandline from anywhere, yes
tou do not need to be inside the project folders to make these command.
<br />Just check if your system has curl by typing `curl --version`
<br />If the terminal gave you good new, firstly fetch the Json Web Token by calling in Windows systems: 
<br />`curl -X POST -v -H "Content-Type: application/json" -d "{"""username""":"""test""", """password""":"""test"""}" http://localhost:8081/authenticate`
<br />, but in other systems you don't have to get so weird with the "" just type:
<br />`curl -X POST -v -H "Content-Type: application/json" -d "{'username':'test', 'password':'test'}" http://localhost:8081/authenticate`
<br />The command should return this kind of provoking string, like:<br />
{"jwt":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNjA1NTI5NDU2LCJpYXQiOjE2MDU0OTM0NTZ9.JfjLLJVUh1SYGzZfbUYisKEbKYsAYPuVa8gpoBa392s"}
<br />Next copy only the character snake and paste it to your GET command, like this:
<br />`curl -X GET -v -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNjA1NTI5NDU2LCJpYXQiOjE2MDU0OTM0NTZ9.JfjLLJVUh1SYGzZfbUYisKEbKYsAYPuVa8gpoBa392s" localhost:8081/getMovie/batman`
<br />By changing the ending of the url you can search different things.
<br />For movies use localhost:8081/getMovie/<title>/<year>/<plot>
<br /><title> is a must and for <plot> only "short" or "full" are allowed
<br />For Books use localhost:8081/getBook/ISBN/<isbn>
<br /><isbn> must be a 10 digit number.
<br />Thanks!

