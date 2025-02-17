#!/usr/bin/env bash

BROWSER=$1
ENVIRONMENT=$2
SPEC_FILE=$3

sbt clean -Dbrowser="${BROWSER:=chrome}" \
          -Dbrowser.option.headless=false \
          -Denvironment="${ENVIRONMENT:=local}" \
          -Dsecurity.assessment=false \
          "testOnly ${SPEC_FILE}" testReport
