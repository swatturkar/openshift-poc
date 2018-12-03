

$(function () {
    getDashboard();
    connect();
});



function getDashboard(){

    $.get( "http://localhost/request-api/intake/dashboard", function( data ) {

      $("#dashboardData").html("");

      for (var i=0; i<data.length; i++){
        $("#dashboardData").append("<tr><td>" + data[i][0] + "</td><td>" + data[i][1] +"</td></tr>");
      }
    });

}

function connect() {
    var socket = new SockJS('http://localhost/request-api/intake-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/tickers', function (ticker) {
            showTicker(ticker.body);
        });
    });
}

function showTicker(message) {

    var rows = $("#dashboardData tr");
    var found = false;
    $(".blinking").removeClass("blinking");

    for (var i=0; i<rows.length; i++){

          var ticker = rows[i].cells[0];
          if (ticker.innerHTML == message){
            var count  = parseInt(rows[i].cells[1].innerHTML);
            count++;
            rows[i].cells[1].innerHTML = count;
            $(rows[i].cells[1]).addClass("blinking")
            found = true;
          }
    }

    if (!found){
        $("#dashboardData").append("<tr><td>" + message + "</td><td class='blinking'>1</td></tr>");
    }

}