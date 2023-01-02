kubectl apply -f kube/postgres-storage.yaml
kubectl apply -f kube/postgres-deployment.yaml
kubectl apply -f kube/postgres-service.yaml
kubectl apply -f kube/postgres-configmap.yaml
#helm install psql-test bitnami/postgresql --set persistence.existingClaim=postgres-pv-claim --set volumePermissions.enabled=true