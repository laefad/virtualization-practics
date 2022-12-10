FROM alpine:latest

LABEL author=laefad

RUN apk update && apk upgrade

RUN addgroup -S laefadgroup && adduser -S laefad -G laefadgroup
USER laefad

CMD whoami
