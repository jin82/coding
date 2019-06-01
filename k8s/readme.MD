
kubectl create secret generic regcred \
    --from-file=.dockerconfigjson=~/.docker/config.json \
    --type=kubernetes.io/dockerconfigjson



启动集群：minikube start
查看集群信息:
    kubectl cluster-info
使用私有仓库：
    生成secret:kubectl create secret docker-registry jin82aliyun --docker-server=registry.cn-hangzhou.aliyuncs.com --docker-username=820100449@qq.com --docker-password=<your-pword> --docker-email=820100449@qq.com
    查看: kubectl get secrets aliyunreg
运行第一个应用:
    kubectl run k8s-rest --image=registry.cn-hangzhou.aliyuncs.com/jin82/k8s-rest:1.0-snapshot --port=8080 --generator=run/v1     
    
    设置label    
    kubectl get pods --show-labels

    
    端口转发
    kubectl port-forward $POD_NAME $HOST_PORT:$POD_PORT
    
    手动扩容缩容
    kubectl scale rs rest-rs --replicas=5
    
    删除rs保存pod
    kubectl delete rs $RS_NAME --cascade=false
    
    label node 
    kubectl label node minikube $LABEL=$LABEL_VALUE
    
    请求svc
    kubectl exec rs-nodejs-9wzgp -- curl -s 10.106.208.168:8080
