const http = require ( 'http' );
const os = require ('os');
console.log("nodejs server starting ... ");
var handler = function (request, response) {
    console.log ("接收到来自 " + request.connection.remoteAddress  + "的请求");
    response.writeHead(200);
    response.end("您访问的是 " + os.hostname() + " \n " ) ;

}
var www = http.createServer(handler) ;
www.listen(8080);