#!/usr/bin/env bash

ENVIRONMENT=${1:-local}
GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m'

case ${1} in
    [sS][tT][aA][gG][iI][nN][gG])
        ngrHost="https://ngr-stub.protected.mdtp:443"
        ;;
    [qQ][aA])
        ngrHost="https://ngr-stub.protected.mdtp:443"
        ;;
    *)
        ngrHost="127.0.0.1:1501"
        ;;
esac

echo "Populating data in ${ENVIRONMENT} environment"
echo
echo "Deleting data in ngr-stub"
echo "================================================================================"
echo

curl -X "DELETE" "${ngrHost}/ngr-stub/all-data"
echo

echo
echo "Populating data in ngr-stub"
echo "=========================================================================================="
echo

allData=$(find src/test/resources/stubData -type f -name '*.json')
dataUri="ngr-stub/data"

for data in ${allData}
do
  curl -f -s -S -o /dev/null -H "Content-Type:application/json" -d @${data} ${ngrHost}/${dataUri}
  if [[ $? -ne 0 ]]; then
    echo -e "${RED}Failed to load data: ${data}${NC}"
  else
    echo -e "${GREEN}Successfully loaded ${data}${NC}"
  fi
done
