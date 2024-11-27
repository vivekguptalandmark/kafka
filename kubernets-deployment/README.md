1. Enable docker desktop or minikube on local.
2. apply deployment: zookeeper-deployment.yml.
3. apply kafka config: kafka-config.yml
4. apply StatefulSet : kafka-deployment.yml
5. apply kafdrop for monitoring purpose: kafdrop-deployment.yml
6. if you want to apply ingress controller please follow below steps, this is optional as services can be accessed  by port-forward command also.
    a. helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
    b. helm repo update
    c. helm install ingress-nginx ingress-nginx/ingress-nginx --namespace default.  **note: namespace can be changed based on the need**.
    d. kubectl apply -f .\ingress-deployment.yml
7. build producer and consumer applications. (mvn  clean package )
8. generate image  for consumer: docker build -t vivekguptalandmarkgroupin/kafka:consumer-image-latest . 
9. generate image  for producer: docker build -t vivekguptalandmarkgroupin/kafka:producer-image-latest .
10. post image is generated push them to docker repo using command:
11. docker push  vivekguptalandmarkgroupin/kafka:producer-image-latest, docker push  vivekguptalandmarkgroupin/kafka:consumer-image-latest
12. give correct path in your producer and consumer deployment file
13. apply both deployment producer and consumer.
14. kubectl apply -f  producer-deployment.yml
15. kubectl apply -f  consumer-deployment.yml
16. use port forward send messages to producer service: 
    kubectl port-forward service/producer-service 8555:80  
17. x`you can create partition using below command:  please note this path depends on your base kafka image
**kubectl exec -it kafka-0 -- bash -c "/usr/bin/kafka-topics --alter --topic backpressure --bootstrap-server kafka-service:9092 --partitions 20"**
18. Apply HPA to scale up consumer pod  kubectl apply -f consumer-hpa.yml 
    19. Note: if you are running HPA on desktop-local, HPA may not be applied due to it will not be able to read metrix. so let's install metrix:
        1. kubectl apply -f https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml
        2. kubectl get pods -n kube-system | grep metrics-server
           3. you should be able to see metrix server is installed and running. In case it is getting failed becuase of SSL certificate please follow below steps:
              1. kubectl edit deployment metrics-server -n kube-system
              2. Add the --kubelet-insecure-tls flag under the container's args section
              3. it should look like below:
                   containers:
                     - name: metrics-server
                       image: k8s.gcr.io/metrics-server/metrics-server:v0.6.3
                       args:
                         - --cert-dir=/tmp
                         - --secure-port=4443
                         - --kubelet-preferred-address-types=InternalIP,Hostname,ExternalIP
                         - --kubelet-insecure-tls



