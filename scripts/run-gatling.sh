#!/bin/bash

BASE_URL='http://localhost'
TEST_DURATION=11
INITIAL_USER_RATE=2
INITIAL_USER_DURATION=100
SECONDARY_USERS_COUNT=200
SECONDARY_USER_RAMP=10
SECONDARY_USER_DURATION=7
SECONDARY_USER_PAUSE=13
TEST=

while getopts ":-:" opt; do
  case $opt in
    -)
        case "${OPTARG}" in
            baseUrl)
                val="${!OPTIND}"; OPTIND=$(( $OPTIND + 1 ))
                echo "Parsing option: '--${OPTARG}', value: '${val}'" >&2;
                BASE_URL=${val}
                ;;
            testDuration)
                val="${!OPTIND}"; OPTIND=$(( $OPTIND + 1 ))
                echo "Parsing option: '--${OPTARG}', value: '${val}'" >&2;
                TEST_DURATION=${val}
                ;;
            initialUserRate)
                val="${!OPTIND}"; OPTIND=$(( $OPTIND + 1 ))
                echo "Parsing option: '--${OPTARG}', value: '${val}'" >&2;
                INITIAL_USER_RATE=${val}
                ;;
            initialUserDuration)
                echo "Optind: ${OPTIND}"
                val="${!OPTIND}"; OPTIND=$(( $OPTIND + 1 ))
                echo "Parsing option: '--${OPTARG}', value: '${val}'" >&2;
                INITIAL_USER_DURATION=${val}
                ;;
            secondaryUsersCount)
                val="${!OPTIND}"; OPTIND=$(( $OPTIND + 1 ))
                echo "Parsing option: '--${OPTARG}', value: '${val}'" >&2;
                SECONDARY_USERS_COUNT=${val}
                ;;
            secondaryUserRamp)
                val="${!OPTIND}"; OPTIND=$(( $OPTIND + 1 ))
                echo "Parsing option: '--${OPTARG}', value: '${val}'" >&2;
                SECONDARY_USER_RAMP=${val}
                ;;
            secondaryUserDuration)
                val="${!OPTIND}"; OPTIND=$(( $OPTIND + 1 ))
                echo "Parsing option: '--${OPTARG}', value: '${val}'" >&2;
                SECONDARY_USER_DURATION=${val}
                ;;
            secondaryUserPause)
                val="${!OPTIND}"; OPTIND=$(( $OPTIND + 1 ))
                echo "Parsing option: '--${OPTARG}', value: '${val}'" >&2;
                SECONDARY_USER_PAUSE=${val}
                ;;
            test)
                val="${!OPTIND}"; OPTIND=$(( $OPTIND + 1 ))
                echo "Parsing option: '--${OPTARG}', value: '${val}'" >&2;
                TEST=${val}
                ;;
        esac;;
    \?)
      echo "Invalid option: -$OPTARG" >&2
      ;;
  esac
done

echo $TEST

./bin/gatling.sh -DbaseUrl=$BASE_URL -DtestDuration=$TEST_DURATION -DinitialUserRate=$INITIAL_USER_RATE -DinitialUserDuration=$INITIAL_USER_DURATION -DsecondaryUsersCount=$SECONDARY_USERS_COUNT -DsecondaryUserRamp=$SECONDARY_USER_RAMP -DsecondaryUserDuration=$SECONDARY_USER_DURATION -DsecondaryUserPause=$SECONDARY_USER_PAUSE -s $TEST
