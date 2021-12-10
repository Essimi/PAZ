
var memId = document.getElementById('chatbotId').value;

(function() {
  	  
  	  var w = window;
  	  if (w.ChannelIO) {
  		  return (window.console.error || window.console.log || function(){})('ChannelIO script included twice.');
  	  }
  	  
  	  var ch = function() {
  		  ch.c(arguments);
  	  };
  	  
  	  ch.q = [];
  	  ch.c = function(args) {
  		  ch.q.push(args);
  	  };
  	  
  	  w.ChannelIO = ch;
  	  
  	  function l() {
  		  
  		  if (w.ChannelIOInitialized) {
  			  return;
  		  }
  		  
    	      w.ChannelIOInitialized = true;
    	      var s = document.createElement('script');
    	      s.type = 'text/javascript';
    	      s.async = true;
    	      s.src = 'https://cdn.channel.io/plugin/ch-plugin-web.js';
    	      s.charset = 'UTF-8';
    	      var x = document.getElementsByTagName('script')[0];
    	      x.parentNode.insertBefore(s, x);
  		  
  	  }

  	  
  	  if (document.readyState === 'complete') {
  		  l();
  	  } else if (window.attachEvent) {
  		  window.attachEvent('onload', l);
  	  } else {
  		  window.addEventListener('DOMContentLoaded', l, false);
  	      window.addEventListener('load', l, false);
  	  }
  	  
  	  })();
    
    
    ChannelIO('boot', {
  	  "pluginKey": "35ff19fc-28ca-4f68-a473-c123fe20bbf2", //please fill with your plugin key
			
		    "memberId": "ID", // 비회원의 경우 아이디를 입력 받음.
		    "profile": {
		    "name": memId // 회원의 경우 세션에 저장된 아이디를 가져옴.
		    },
		  
		    "customLauncherSelector": ".hello",
		    "hideChannelButtonOnBoot": true
    });

