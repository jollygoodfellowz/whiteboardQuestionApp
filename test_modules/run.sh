#!/bin/bash
module=$1

if [ -z "$module" ]; then
    echo "Name of module required"
    exit;
fi

files=$2
run=$3

test="Test.java"
java=".java"

testModule=$1$test 
sourceFile=$1$java

javac -d build/ $files $testModule $sourceFile

if [ -z "$run" ]; then 
    exit;
fi

cd build/
run="$1Test"
java $run
