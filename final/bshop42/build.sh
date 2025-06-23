#!/bin/bash

TAG="latest"

while getopts t: flag; do
  case "${flag}" in
    t) TAG=${OPTARG} ;;
  esac
done

echo "Building image with tag: $TAG"
docker build -t bshop42-app:$TAG .
