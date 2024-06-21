
curl -X POST "http://localhost:8080/pets" \
     -H "Content-Type: application/json" \
     -d '{
           "name": "Fido",
           "tag": "dog"
         }'

curl -X POST "http://localhost:8080/pets" \
     -H "Content-Type: application/json" \
     -d '{
           "name": "Whiskers",
           "tag": "cat"
         }'

curl -X POST "http://localhost:8080/pets" \
     -H "Content-Type: application/json" \
     -d '{
           "name": "Nemo",
           "tag": "fish"
         }'


curl -X GET "http://localhost:8080/pets" -H "accept: application/json"

apiVersion: apps/v1
kind: Deployment
metadata:
  name: petstore
spec:
  replicas: 1
  selector:
    matchLabels:
      app: petstore
  template:
    metadata:
      creationTimestamp: null
      labels:
        app: petstore
    spec:
      containers:
      - image: quay.io/dacelent/petstore
        imagePullPolicy: IfNotPresent
        name: container
        ports:
        - containerPort: 8080
          protocol: TCP
        resources: {}
        terminationMessagePath: /dev/termination-log
        terminationMessagePolicy: File
      dnsPolicy: ClusterFirst
      restartPolicy: Always
      schedulerName: default-scheduler
      securityContext: {}
      terminationGracePeriodSeconds: 30

apiVersion: v1
kind: Service
metadata:
  name: pet
spec:
  ports:
  - port: 8080
    protocol: TCP
    targetPort: 8080
  selector:
    app: petstore
  type: ClusterIP
