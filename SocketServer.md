# Kafka SocketServer 实现原理
1. Kafka底层请求对象建模
2. 请求队列实现原理
3. 请求处理核心监控指标


num.network.threads 控制每个监听器上创建的processor的个数
num.io.threads
background.threads


## 请求(Request)

```java
class Request(val processor: Int,
            val context: RequestContext,
            val startTimeNanos: Long,
            memoryPool: MemoryPool,
            @volatile private var buffer: ByteBuffer,
            metrics: RequestChannel.Metrics) extends BaseRequest {
```
Request是实现client与Broker、Broker与Broker间请求的实现类，属性包括`processor`, `context`, `startTimeNanos`, `memoryPool`, `buffer`, `metrics`

### Processor
processor是Processor的序号，表明这个请求是由哪个Processor接收处理的, Broker端通过`num.network.threads`来控制每个监听器上创建的Processor的个数
这里为何要在Request中添加Processor的序号？是因为request在被I/O线程处理完成后，还要通过Processor来将Response返回给请求发送方，因此每个Request要记录自己是被哪个Processor接收的
需要注意的是：Processor仅仅是网络接收线程，并不负责请求处理(这部分是由I/O线程来负责的)

### context
context是用来标记上下文信息的，