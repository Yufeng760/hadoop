var websocket = null;
if ('WebSocket' in window) {
    websocket = new WebSocket('ws://192.168.1.8:8081/sboot/WebSocketServer');
} else {
    layer.msg('该浏览器不支持websocket', {icon: 2, time: 1000});
}
websocket.onopen = function (event) {
    console.info('建立连接');
};
websocket.onclose = function (event) {
    console.info('关闭连接');
};
websocket.onmessage = function (event) {
    //console.info('收到消息' + event.data);
    var obj = $.parseJSON(event.data);
    if(obj.Data === 0){
        $('#alarmSpan').removeClass("text-danger");
        document.getElementById("alarmSpan").innerHTML="<i class=\"fa fa-bell\"></i>";
    }else{
        $('#alarmSpan').addClass("text-danger");
        document.getElementById("alarmSpan").innerHTML="<i class=\"fa fa-bell faa-ring animated\"></i>";
    }
};
websocket.onerror = function () {
    console.info('websocket通讯发生错误！');
};
websocket.onbeforeunload = function () {
    websocket.close();
};
