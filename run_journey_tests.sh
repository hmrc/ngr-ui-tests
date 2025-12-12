#!/usr/bin/env bash
JOURNEYTYPE=$1
ENVIRONMENT=$2

curl -X GET "http://localhost:1503/ngr-dashboard-frontend/test-only/populate-stub-data"

sbt scalafmtAll
sbt clean -Dbrowser="${BROWSER:=chrome}" \
          -Dbrowser.option.headless=true \
          -Denvironment="${ENVIRONMENT:=local}" \
          -Dsecurity.assessment=false \
          "testOnly *specs.${JOURNEYTYPE}.*" testReport
