minikube start

docker build -f Dockerfile -t laefad/daragan-ikbo-10-19-obraz .
docker push laefad/daragan-ikbo-10-19-obraz

kubectl create deployment daragan-ikbo-10-19 --image=laefad/daragan-ikbo-10-19-obraz

kubectl get deployments
kubectl get pods
kubectl get events
kubectl config view

kubectl expose deployment daragan-ikbo-10-19 --type=NodePort --port=8080

kubectl get services

minikube service daragan-ikbo-10-19

minikube addons list
minikube addons enable ingress
kubectl get pod,svc -n kube-system

minikube dashboard

# Cleanup
minikube addons disable ingress
kubectl delete service daragan-ikbo-10-19
kubectl delete deployment daragan-ikbo-10-19

minikube stop
