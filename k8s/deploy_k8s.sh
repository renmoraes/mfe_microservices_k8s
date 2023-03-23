#!/bin/sh
set -o errexit

# Ensure ingress controller is up
kubectl wait --namespace ingress-nginx \
  --for=condition=ready pod \
  --selector=app.kubernetes.io/component=controller \
  --timeout=90s

kubectl create namespace backend

# Deploy mySQL db
kubectl apply -f k8s/db/mysql.yaml

# Deploy microservices
kubectl apply -f k8s/customers-microservice.yaml
kubectl apply -f k8s/products-microservice.yaml
kubectl apply -f k8s/cart-microservice.yaml

# Deploy microservices proxy
kubectl apply -f k8s/microservices-ingress.yaml