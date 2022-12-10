#!/bin/bash 

curl -d '{"price":10}' -H "Content-Type: application/json" -X POST http://localhost:8000/ticket
echo
curl -d '{"price":20}' -H "Content-Type: application/json" -X POST http://localhost:8000/ticket
echo
curl http://localhost:8000/tickets
echo
curl -o image.png http://localhost:8000/image
echo
