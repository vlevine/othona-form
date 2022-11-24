kubectl apply -f kube/postgres-pv.yaml
kubectl apply -f kube/postgres-pvc.yaml
helm install psql-test bitnami/postgresql --set persistence.existingClaim=postgres-pv-claim --set volumePermissions.enabled=true