#!/bin/bash

TAG="latest"

while getopts t: flag; do
  case "${flag}" in
    t) TAG=${OPTARG} ;;
  esac
done

echo "Starting services with tag: $TAG"
TAG=$TAG docker-compose up -d --build