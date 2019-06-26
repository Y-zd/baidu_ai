FROM centos:jdk1.8.0_151
ADD target/a.jar /app/baiduai/
RUN mkdir -p /app/baiduai/data
ENV JAVA_OPTS=""
EXPOSE  9008
ENTRYPOINT [ "sh", "-c", "java -jar -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap  -XX:MaxRAMFraction=2 "]