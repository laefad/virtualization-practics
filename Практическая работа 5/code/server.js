const http = require('http');

const handleRequest = (request, response) => {
    console.log(`Получен запрос на URL: ${request.url}`);
    response.writeHead(200);
    response.end("Привет мир!");
}

const server = http.createServer(handleRequest);
server.listen(8080);
