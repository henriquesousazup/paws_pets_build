#!/bin/bash
curl -v --silent localhost:8080/actuator/health 2>&1 | grep UP