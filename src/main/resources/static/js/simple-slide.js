$("#slidehair > div:gt(0)").hide();
$("#slidecar > div:gt(0)").hide();
$("#slidehobby > div:gt(0)").hide();
$("#slideauth > div:gt(0)").hide();
$("#sliderest > div:gt(0)").hide();
$("#slidequiz > div:gt(0)").hide();

setInterval(function() { 
  $('#slidehair > div:first')
    .fadeOut(0)
    .next()
    .fadeIn(1000)
    .end()
    .appendTo('#slidehair');
},  3000);

setInterval(function() { 
    $('#slidecar > div:first')
      .fadeOut(0)
      .next()
      .fadeIn(1000)
      .end()
      .appendTo('#slidecar');
  },  3000);

  setInterval(function() { 
    $('#slidehobby > div:first')
      .fadeOut(0)
      .next()
      .fadeIn(1000)
      .end()
      .appendTo('#slidehobby');
  },  3000);

  setInterval(function() { 
    $('#slideauth > div:first')
      .fadeOut(0)
      .next()
      .fadeIn(1000)
      .end()
      .appendTo('#slideauth');
  },  3000);

  setInterval(function() { 
    $('#sliderest > div:first')
      .fadeOut(0)
      .next()
      .fadeIn(1000)
      .end()
      .appendTo('#sliderest');
  },  3000);

  setInterval(function() { 
    $('#slidequiz > div:first')
      .fadeOut(0)
      .next()
      .fadeIn(1000)
      .end()
      .appendTo('#slidequiz');
  },  4500);


 
	$(window).scroll(function() {
		if ($(window).scrollTop() > 100) {
			$('.scrollTopButton').addClass('show');
		} else {
			$('.scrollTopButton').removeClass('show');
		}
	});
 
	$('.scrollTopButton').on('click', function() {
		$('body, html').animate({scrollTop: 0}, 500, 'linear');
	});
