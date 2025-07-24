#!/usr/bin/env bash

ENVIRONMENT=$1
JOURNEYTYPE=$2
SPEC=$3


sbt scalafmtAll
sbt clean -Dbrowser="${BROWSER:=chrome}" \
          -Dbrowser.option.headless=false \
          -Denvironment="${ENVIRONMENT:=local}" \
          -Dsecurity.assessment=false \
          "testOnly *specs.${JOURNEYTYPE}.${SPEC}" testReport
