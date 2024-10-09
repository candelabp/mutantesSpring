FROM ubuntu:latest
LABEL authors="cande"

ENTRYPOINT ["top", "-b"]