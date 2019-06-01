DOCKER_TAG=registry.cn-hangzhou.aliyuncs.com/jin82/k8s-nodejs
docker build -t ${DOCKER_TAG}:latest . && \
docker push ${DOCKER_TAG}:latest