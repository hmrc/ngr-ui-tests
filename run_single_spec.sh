#!/usr/bin/env bash

JOURNEYTYPE=$1
SPEC=$2
ENVIRONMENT=$3


sbt scalafmtAll
sbt clean -Dbrowser="${BROWSER:=chrome}" \
          -Dbrowser.option.headless=true \
          -Denvironment="${ENVIRONMENT:=local}" \
          -Dsecurity.assessment=false \
          "testOnly *specs.${JOURNEYTYPE}.${SPEC}" testReport
