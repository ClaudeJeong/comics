<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
<head>
<style type="text/css">

/* commons */
a { color: #277DA8; text-decoration: none }
a:hover { color: #48A5D4 }

body { background:  #E7E7E7; font: normal 10px/1.6 'Helvetica Neue', 'Lucida Grande', Helvetica, Arial, sans-serif }

footer { font-size: 1.3em; margin: 0 auto; overflow: auto; padding-bottom: 15px; padding-top: 10px; text-align: center; width: 1100px }

h2 { border-bottom: 1px solid #DEDEDE; clear: right; color: #444; font-size: 2.6em; letter-spacing: .5px; line-height: 1.3em; padding-bottom: 3px }
h2 a { color: #444 }

h3 { color: #555; font-size: 1.6em; letter-spacing: .5px; }

ul { margin-left: 0; padding-left: 22px }
ul li { font-size: 1.3em }


/* wrapper */
#wrapper { margin: 0 auto; width: 87% }
#wrapper #container { margin-bottom: 30px; width: 100% }

/* content */
article > p { font-size: 1.5em }

.option div { color: #444; font: bold 1.4em verdana; margin-top: 12px; letter-spacing: .7px }
.option div span { color: #888; font: 1em arial }
.option p { color: #444; font-size: 1.2em; letter-spacing: .4px; margin-top: 5px; text-align: left }

.function p { color: #444; font-size: 1.2em; letter-spacing: .4px; margin-left: 3px; margin-top: -8px; text-align: left }

.demo { margin-bottom: 10px }

.highlight { clear: both }
#result {  }
header nav { float: right; margin-top: 20px }
header nav li { display: inline-block; padding: 0 7px 14px; text-align: center; width: 105px }
header nav li a { background-color: #D7D7D7; border-radius: 4px; color: #333; display: block; font: 15px helvetica; letter-spacing: .4px; padding: 5px 0 2px 6px }
header nav li a:hover { background-color: #BBB; color: #333 }
header nav li a i { font-size: 1.5em; left: -20px; position: relative; top: 3px }

header nav li a.download { background-color: #E7D785 }
header nav li a.download:hover { background-color: #E3D070 }

.demo input, .demo textarea, .demo select { border: 1px solid #999; border-radius: 5px; color: #333; display: inline-block; height: 27px; font-size: 1.5em; text-align: center; width: 135px; vertical-align: middle }

.demo input:focus, .demo textarea:focus, .demo select:focus { border: 1px solid #95BDD4 }
.demo input:hover, .demo textarea:hover, .demo select:hover { border: 1px solid #BDBDBD }

.demo textarea { resize: none; height: 27px }
.demo select { text-align: left }

.demo .target-demo { display: inline-block; vertical-align: middle }

.demo div.hint { background-color: #F8F8F8; border-radius: 5px; color: #333; display: inline-block; height: 27px; font-size: 1.5em; text-align: center; width: 135px; vertical-align: middle }

.demo label { color: #444; font-size: 1.7em; letter-spacing: .7px; margin-right: 5px; padding-left: 6px; vertical-align: middle }

.demo a.run { font-size: 1.5em; margin-left: 5px; letter-spacing: .7px; vertical-align: middle }

</style>
  <meta charset="utf-8">
	<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
	<meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">

	<title>How to add 5 star rating using jQuery</title>
	<!--Adding basic stylesheet -->
	<link type="text/css" rel="stylesheet" href="css/application.css">
	
	<!--Adding jQuery library -->
	<script type="text/javascript" src="js/jquery.min.jsp"></script>
	<!--Adding jQuery rating plug-in-->
	<script type="text/javascript" src="lib/jquery.raty.min.js"></script>
  
	<script type="text/javascript">
		$(function()
		{
			/*
				Basic Example with custom image path
				path : indicate custom path to the star image
			*/
			$('#star').raty({ path: 'http://wbotelhos.com/raty/lib/img/' });
			
			
			/*
				Predefined score with half star,
				score : You can pass any value for it, not necessarily,
						a data- value.
						You can use a rating-score too.
						but then 
						code will be return $(this).attr('rating-score');
				half 	: that will enable user to add half star rating
				target  : define the rating hint container
				targetKeep : this will allow used to
					keep selected result inside hint container
					defining false will loose selected value
			*/

			$('#predefined-star').raty(
			{
				path: 'http://wbotelhos.com/raty/lib/img/',
				half: true,
				target: '#result',
				targetKeep: true,
				score: function()
				{
					return $(this).attr('data-score');
				}
			});
		});
	</script>

</head>
<body>
	<div id="wrapper">
		<div id="container">
		
			<!-- HTML Structure for basic rating -->
			<h2>Basic</h2>
			<div id="star"></div>
			
			<!-- With Predefined Rating -->
			<h2>Predefined Score</h2>
			<div id="predefined-star" data-score="2.5"></div> <div id="result" style="font-size: 15px !important;"></div>
			
		</div>
	</div>
</body>
</html>