<html>

	<head>
		<title>BlackJack</title>
		<style>
		.divlink {
			color: blue;
		    text-decoration: underline;
		}
		
		.divlink:hover {
		    cursor: hand;
		    cursor: pointer;
		    opacity: .9;
		}
		</style>
		<script type="text/javascript">
		
		function startNewRound() {
			
			var xhttp = new XMLHttpRequest();
		  	xhttp.onreadystatechange = function() {
		    	if (this.readyState == 4 && this.status == 200) {
		    		//alert(this.responseText);
		    		
		    		var responseJson = JSON.parse(this.responseText);
		    		
		    		document.getElementById("dealerHand").innerHTML = JSON.stringify(responseJson.dealerHand);
		    		document.getElementById("gamblerHand").innerHTML = JSON.stringify(responseJson.gamblerHand);
		    		document.getElementById("gameStatus").innerHTML = responseJson.status;
		    		document.getElementById("gamblerMoney").innerHTML = responseJson.gamblerMoney;
		    		document.getElementById("gameStats").innerHTML = responseJson.gamblerHandsWon + " out of " + responseJson.gamblerHandsPlayed;
		    	}
		  	};
		  	xhttp.open("GET", "/startround?gameId=${gameId}&bet=1000", true);
		  	xhttp.send();
			
		}
		
		function hit() {
			alert("hit");
			var xhttp = new XMLHttpRequest();
		  	xhttp.onreadystatechange = function() {
		    	if (this.readyState == 4 && this.status == 200) {
		    		alert(this.responseText);
		    		
		    		var responseJson = JSON.parse(this.responseText);
		    		
		    		document.getElementById("dealerHand").innerHTML = JSON.stringify(responseJson.dealerHand);
		    		document.getElementById("gamblerHand").innerHTML = JSON.stringify(responseJson.gamblerHand);
		    		document.getElementById("gameStatus").innerHTML = responseJson.status;
		    		document.getElementById("gamblerMoney").innerHTML = responseJson.gamblerMoney;
		    		document.getElementById("gameStats").innerHTML = responseJson.gamblerHandsWon + " out of " + responseJson.gamblerHandsPlayed;
		    	}
		  	};
		  	xhttp.open("GET", "/gamblerhit?gameId=${gameId}", true);
		  	xhttp.send();
			
		}
		
		function stand() {
			
			var xhttp = new XMLHttpRequest();
		  	xhttp.onreadystatechange = function() {
		    	if (this.readyState == 4 && this.status == 200) {
		    		//alert(this.responseText);
		    		
		    		var responseJson = JSON.parse(this.responseText);
		    		
		    		document.getElementById("dealerHand").innerHTML = JSON.stringify(responseJson.dealerHand);
		    		document.getElementById("gamblerHand").innerHTML = JSON.stringify(responseJson.gamblerHand);
		    		document.getElementById("gameStatus").innerHTML = responseJson.status;
		    		document.getElementById("gamblerMoney").innerHTML = responseJson.gamblerMoney;
		    		document.getElementById("gameStats").innerHTML = responseJson.gamblerHandsWon + " out of " + responseJson.gamblerHandsPlayed;
		    	}
		  	};
		  	xhttp.open("GET", "/gamblerstand?gameId=${gameId}", true);
		  	xhttp.send();
			
		}
		
		</script>
	
	</head>
	
	<body>
		<h2>Welcome to BlackJack</h2>
		
		<div>Game Id: ${gameId}</div>
		
		<div class="divlink" onclick="startNewRound()">Start New Round</div>
		
		<span>Status</span>
		<div id="gameStatus"></div>
		<div id="blackJackTable">
		
			<span>Dealer</span>
			<div id="dealerHand"></div>
			<span>Player</span>
			<div id="gamblerHand"></div>
		
		</div>
		
		<div class="divlink" id="gamblerHit" onclick="hit()">Hit</div>
		<div class="divlink" id="gamblerStand" onclick="stand()">Stand</div>
		<span>Player Money</span>
		<div id="gamblerMoney"></div>
		<span>Stats</span>
		<div id="gameStats"></div>
		
	</body>
</html>