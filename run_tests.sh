#!/usr/bin/env bash

ENVIRONMENT=$1

sbt scalafmtAll
sbt clean -Dbrowser="${BROWSER:=chrome}" \
          -Dbrowser.option.headless=false \
          -Denvironment="${ENVIRONMENT:=local}" \
          -Dsecurity.assessment=false \
           "testOnly" testReport
