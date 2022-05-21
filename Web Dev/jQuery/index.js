// $("h1").addClass("big-title");
// // no difference selecting one or many
// $("h1").removeClass("big-title");
// $("h1").addClass("big-title margin-50");
// console.log($("h1").hasClass("margin-50"));
// $("h1").text("bye")

// $("button").text("no");
$("button").html("<em>Hey<em>");


$("a").attr("href", "https://www.yahoo.com");

// event listener
$("h1").click(function() {
  $("h1").css("color", "purple")
})


// for loop, jQuery will do automatically
$("button").click(function() {
  $("h1").css("color", "purple");
});

$("input").keydown(function(event) {
  console.log(event.key);
});

$(document).keydown(function(event) {
  $("h1").text(event.key);
});

$(document).on("mouseover", function() {
  $("h1").css("color", "green");
});


$("button").on("click", function() {
  $("h1").hide();
});

$("button").on("click", function() {
  $("h1").fadeToggle();
});

$("button").on("click", function() {
  $("h1").slideToggle();
});

$("button").on("click", function() {
  $("h1").animate({opacity: 0.5});
});

// chain
$("button").on("click", function() {
  $("h1").slideDown().slideUP().animate({opacity: 0.5});
});
