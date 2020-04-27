#!/usr/bin/env bash
##########################################################################
# script to check if the jwilder proxy container is already running
# and if the ngnix-proxy network exists
# run before "docker-compose up -d" if you use nginx-proxy for several projects
# see https://github.com/docker/compose/issues/2075
##########################################################################

if [ ! "$(docker network ls | grep db-docker_default)" ]; then
  echo "Creating db-docker_default network ..."
  docker network create db-docker_default
else
  echo "db-docker_default network exists."
fi