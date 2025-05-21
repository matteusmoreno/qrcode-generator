FROM ubuntu:latest
LABEL authors="matteus"

ENTRYPOINT ["top", "-b"]