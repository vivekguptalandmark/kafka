1. Enable docker desktop or minikube on local.
2. apply deployment: zookeeper-deployment.yml.
3. apply kafka config: kafka-config.yml
4. apply StatefulSet : kafka-deployment.yml
5. apply kafdrop for monitoring purpose: kafdrop-deployment.yml
6. if you want to apply ingress controller please follow below steps, this is optional as services can be accessed  by port-forward command also.
    a. helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
    b. helm repo update.
    c. helm install ingress-nginx ingress-nginx/ingress-nginx --namespace default.  **note: namespace can be changed based on the need**.
    d. kubectl apply -f .\ingress-deployment.yml
7. now  generate docker images for  producer and consumer applications.
8. give correct path in your producer and consumer deployment file
9. apply both deployment producer and consumer.