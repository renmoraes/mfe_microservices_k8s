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
From the project directory, run the following commands to deploy the application:
```bash
# Setup k8s cluster
./k8s/local_cluster/create_cluster.sh

# Deploy microservices k8s resources
./k8s/deploy_k8s.sh
```

### Access the APIs

1. Retrieve the IP address of the ingress controller:

```bash
$ kubectl get ingress -n backend
NAME              CLASS    HOSTS                 ADDRESS     PORTS   AGE
backend-ingress   <none>   backend.example.com   localhost   80      64m
```

2 - Add an entry for backend.example.com to your /etc/hosts file (or C:\Windows\System32\drivers\etc\hosts on Windows):

```bash
127.0.0.1       kubernetes.docker.internal      localhost        backend.example.com
::1             kubernetes.docker.internal      localhost        backend.example.com
```
3 - Test the APIs by sending HTTP requests to the following endpoints:

| API Name       | API Endpoint                           |
| -------------- | -------------------------------------- |
| Products API   | http://backend.example.com/products   |
| Customers API  | http://backend.example.com/customers  |
| Cart API        | http://backend.example.com/carts      |

For example, you can use the curl command to send a request to the Products API:

```bash
curl http://backend.example.com/products
```
The response should be a list of products in JSON format.

Note: You may need to modify the port number in the Ingress resource and the Service definitions if they conflict with other services running on your system.

That's it! You should now be able to test the backend APIs using the domain name and endpoints specified in the Ingress resource.