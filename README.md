# mfe_microservices_k8s
Repo to exercise Micro-frontends &amp; Microservices architecture design

## Requirements

To run this application, you will need the following:

- [KinD cluster](https://kind.sigs.k8s.io/docs/user/quick-start/#installing-from-release-binaries)
- [Kubectl](https://kubernetes.io/docs/tasks/tools/)
- Java 11 SDK -  recommend installing it via [sdkman](https://sdkman.io/install).
- [Maven](https://maven.apache.org/install.html) - Required to build and run the application. .

## Build

To build the application, run the following command:

```bash
mvn clean install -DskipTests
```
#### Docker image

Build and push the Docker images to a local registry for the following services:

### Customer API Service Docker
```bash
cd customer-api
docker build -t localhost:5001/customer-api:latest .
docker push localhost:5001/customer-api:latest
```

### Products API Service Docker
```bash
cd products-api
docker build -t localhost:5001/products-api:latest .
docker push localhost:5001/products-api:latest
```

### Cart API Service Docker
```bash
cd cart-api
docker build -t localhost:5001/cart-api:latest .
docker push localhost:5001/cart-api:latest
```

## Deploy
To deploy the application, run the following commands:
```bash
# Setup k8s cluster
/mfe_microservices_k8s/k8s/local_cluster/create_cluster.sh

kubectl create namespace backend

# Deploy mySQL db
kubectl apply -f k8s/db/mysql.yaml

# Deploy microservices
kubectl apply -f k8s/customers-microservice.yaml
kubectl apply -f k8s/products-microservice.yaml
kubectl apply -f k8s/cart-microservice.yaml
```

# Test the APIs
The APIs can be tested on the following endpoints:

- Products API: `localhost:30000/products`
- Customers API: `localhost:30010/customers`
- Cart API: `localhost:30020/carts`