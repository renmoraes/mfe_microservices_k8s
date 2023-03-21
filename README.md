# mfe_microservices_k8s
Repo to exercise Micro-frontends &amp; Microservices architecture design

## Requirements

To run this application, you will need the following:

- KinD cluster - https://kind.sigs.k8s.io/docs/user/quick-start/#installing-from-release-binaries
- Kubectl - https://kubernetes.io/docs/tasks/tools/
- Java 11 SDK - It is suggested to use sdkman, which can be installed from https://sdkman.io/install.
- Maven - Maven is required to build and run the application. You can install Maven from https://maven.apache.org/install.html.

## Build

```bash
mvn clean install -DskipTests
```

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

## Deploy
```bash
# Setup k8s cluster
/mfe_microservices_k8s/k8s/local_cluster/create_cluster.sh

kubectl create namespace backend

# Deploy mySQL db
kubectl apply -f k8s/db/mysql.yaml

# Deploy microservices
kubectl apply -f k8s/products-microservice.yaml
```