var stompClient = null;

function connect() {
    var socket = new SockJS('http://request-intake.okd.pyramidchallenges.com/request-api/intake-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/tickers', function (ticker) {
            //showTicker(ticker.body);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }

    console.log("Disconnected");
}

function sendTicker() {
    stompClient.send("/app/addTicker", {}, $("#request").val());
}


$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    connect();
    $( "#send" ).click(function() { sendTicker(); });
});
