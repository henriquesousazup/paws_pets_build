#!/usr/bin/env bash

curl -v localhost:8080/actuator/health 2>&1 | grep UP