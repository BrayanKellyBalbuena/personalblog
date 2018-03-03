$('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

$('#register').click(function(){
  $('.login-form').fadeOut(slow);
  $('.register-form').fadeIn();
})