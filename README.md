# 四大主流MQ和SpringBoot整合Demo

每个Demo都有一个producer和一个consumer
----
## RabbitMQ
- 启动RabbitMQ服务器
    * cd /usr/local/Cellar/rabbitmq/3.7.14/sbin
    * ./rabbitmq-server
- 访问管理页面
  http://localhost:15672/
    * username:guest
    * password:guest
- 启动demo项目
    * 启动producer
        > com.demo.queue.rabbitmq.producer.RabbitmqDemoProducerApplication
    * 启动consumer
        > com.demo.queue.rabbitmq.consumer.RabbitmqDemoConsumerApplication
- 参考博客
    > https://blog.csdn.net/qq_35387940/article/details/100514134
## RocketMQ
- 启动RocketMQ 
    * cd /Users/wf/myRocketMQ/rocketmq-all-4.7.1-source-release
    * Start Name Server
        > nohup sh bin/mqnamesrv &
        > tail -f ~/logs/rocketmqlogs/namesrv.log
    * Start Broker
        > nohup sh bin/mqbroker -n localhost:9876 &
        > tail -f ~/logs/rocketmqlogs/broker.log
- 启动管理端
    * cd /Users/wf/myRocketMQ/rocketmq-externals/rocketmq-console
    * run App.class
    * curl http://localhost:8090/#/
- 启动demo项目
    * 启动producer
        > com.demo.queue.rocketmq.producer.RocketmqDemoProducerApplication
    * 启动consumer
        > com.demo.queue.rocketmq.consumer.RocketmqDemoConsumerApplication
- 参考博客
    > http://rocketmq.apache.org/docs/quick-start/
## ActiveMQ
- 启动ActiveMQ
    * cd /Users/wf/activemq/apache-activemq-5.15.7/bin/macosx
    * ./activemq start
- 访问管理端
    * http://localhost:8161/admin/queues.jsp
- 启动demo项目
    * 启动producer
        > com.demo.queue.activemq.producer.ActivemqDemoProducerApplication
    * 启动consumer
        > com.demo.queue.activemq.consumer.ActivemqDemoConsumerApplication
## kafkaMQ
- 启动KafkaMQ
    * zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties & 
    * kafka-server-start /usr/local/etc/kafka/server.properties &
- 启动demo项目
    * 启动producer
        > com.demo.queue.kafka.producer.KafkaDemoProducerApplication
    * 启动consumer
        > com.demo.queue.kafka.consumer.KafkaDemoConsumerApplication
