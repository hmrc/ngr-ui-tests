#!/usr/bin/env bash

BROWSER=$1
ENVIRONMENT=$2

sbt scalafmtAll
sbt clean -Dbrowser="${BROWSER:=chrome}" \
          -Dbrowser.option.headless=true \
          -Denvironment="${ENVIRONMENT:=local}" \
          -Dsecurity.assessment=false \
           "testOnly" testReport
