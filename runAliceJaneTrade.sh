#!/bin/bash

if [ "$1" == "-h" ] || [ "$1" == "--help" ] || [ "$1" == "help" ]; then
  echo "Pass the params as two separate string in num,num,... format (No {})";
  echo './script "1,3,4,5" "2,3,4,5"';
  exit 0;
fi

if [ $# != 2 ]; then
  echo "Pass 2 valid args!"
  exit 1;
fi


./gradlew run --args "\"$1\" \"$2\""