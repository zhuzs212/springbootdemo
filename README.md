# springbootdemo
############################ 待优化部分 ####################################
1.接口入参，需进一步拆分细化至具体操作


############################ 编码最佳实践 ####################################
1.获取安全加密的随机数
SecureRandom sr = new SecureRandom();

2.非空/null检查
    a)字符串为空或null检查
        String message = null;
        StringUtils.isEmpty(message);
    b)集合为空或null检查
        List<String> list = Lists.newArrayListWithCapacity(10);
        CollectionUtils.isEmpty(list);
        Set<String> set = Sets.newHashSetWithExpectedSize(10);
        CollectionUtils.isEmpty(set);
        Map<String, String> map = Maps.newHashMapWithExpectedSize(10);
        CollectionUtils.isEmpty(map);
    c)数组为空或null检查
        String[] strings = {};
        ObjectUtils.isEmpty(strings);
    d)非字符串、集合、数组对象null检查
        User user = null;
        ObjectUtils.isEmpty(user);
        Integer num = null;
        ObjectUtils.isEmpty(num);
3.集合初始化（集合初始化指定大小，最大程度降低容器自动扩容）
    a)List初始化
        List<String> list = Lists.newArrayListWithCapacity(10); 优先
        List<String> list = Lists.newArrayList();
        List<String> list = Lists.newLinkedList();
    b)Set初始化
        Set<String> set = Sets.newHashSetWithExpectedSize(10); 优先
        Set<String> set = Sets.newHashSet();
    c)Map初始化
        Map<String, String> map = Maps.newHashMapWithExpectedSize(10); 优先
        Map<String, String> map = Maps.newHashMap();
4.所有的接口出入参需为包装对象（私有方法除外） 
    
    
    
############################ Java 8 新特性 ####################################    
1.函数式编程 和 Lambda表达式
  - 函数式接口，可以使用极简的lambda表达式实例化接口
  - lambda表达式，是实现函数式接口的一个快捷方式
    
2.Optional类
  - Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
    Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
    Optional 类的引入很好的解决空指针异常。



############################ nacos ####################################
1.在spring cloud版本中我们使用eureka、consul等做为服务注册中心，使用spring cloud config做为配置中心;
  而在spring cloud alibaba中，使用nacos组件即可完成服务注册发现与服务配置两大功能




############################ Java锁机制 ####################################
- 解决多线程的并发安全问题，java无非就是加锁：
  1.Synchronized(java自带的关键字,JVM层面的锁) 隐式锁
    - 同步代码块 synchronized 
    - 同步方法 synchronized 
  2.同步锁Lock (jdk1.5以后，可重入锁java.util.concurrent.locks包下有两个接口，分别对应两个类实现了这个两个接口) 显示锁
    - lock接口(API层面的锁), 实现的类为：ReentrantLock类 可重入锁;
    - readwriteLock接口，实现类为：ReentrantReadWriteLock 读写锁
  注意：显示锁，需要通过lock()方式上锁，必须通过unlock()方式进行释放锁

  也就是说有三种：
  （1）synchronized 是互斥锁；
  （2）ReentrantLock 顾名思义 ：可重入锁
  （3）ReentrantReadWriteLock :读写锁
  
- 隐式和显式锁对比：
  - 隐式锁基本没有灵活性可言，因为 synchronized 控制的代码块无法跨方法，修饰的范围很窄；
    而显示锁则本身就是一个对象，可以充分发挥面向对象的灵活性，完全可以在一个方法里获得锁，另一个方法里释放。
  - 隐式锁简单易用且不会导致内存泄漏；而显式锁的过程完全要程序员控制，容易导致锁泄露；
  - 隐式锁只是非公平锁；显示锁支持公平/非公平锁；
  - 隐式锁无法限制等待时间、无法对锁的信息进行监控；显示锁提供了足够多的方法来完成灵活的功能；
  
- # 乐观锁 和 悲观锁



############################ 定时任务 ####################################    
1.基于@Scheduled注解和@EnableScheduling注解的单线程实现；
- cron 表达式语法： 
 格式： [秒] [分] [小时] [日] [月] [周] [年]
 序号	说明	    是否必填	  允许填写的值	      允许的通配符
  1	     秒	      是	    0-59	            , - * /
  2	     分	      是	    0-59	            , - * /
  3	     小时	  是	    0-23  	            , - * /
  4	     日	      是	    1-31	            , - * ? / L W
  5	     月	      是	    1-12 or JAN-DEC     , - * /
  6	     周	      是	    1-7 or SUN-SAT      , - * ? / L #
  7	     年	      否	  empty 或 1970-2099    , - * /
  
- fixedDelay
  上一次执行完毕时间点之后多长时间再执行
  
  fixedDelayString
  与 fixedDelay 意思相同，只是使用字符串的形式。唯一不同的是支持占位符：
  在 application.yml 配置文件中添加如下配置：
  time:
    fixedDelay: 5000
  @Scheduled(fixedDelayString = "${time.fixedDelay}")
  
- fixedRate
  上一次开始执行时间点之后多长时间再执行
  
  fixedRateString
  与 fixedRate 意思相同，只是使用字符串的形式。唯一不同的是支持占位符
  
- initialDelay
  第一次延迟多长时间后再执行
  initialDelayString
  与 initialDelay 意思相同，只是使用字符串的形式。唯一不同的是支持占位符
  
  
2.基于线程池的多线程实现
- 自定义线程池工厂类



############################ 阻塞队列 ####################################
阻塞队列提供了四种操作方法：

  方法/处理方式      抛出异常      返回特殊值      一直阻塞      超时退出
  插入方法           add(e)       offer(e)      put(e)       offer(e,time,unit)
  移除方法          remove(e)     poll(e)       take(e)      poll(time,unit)
  检查方法          element()     peek()        不可用        不可用
  
  
- 抛出异常  : 当队列满时，再向队列中插入元素，则会抛出IllegalStateException异常。
             当队列空时，再向队列中获取元素，则会抛出NoSuchElementException异常。
             
- 返回特殊值: 当队列满时，向队列中添加元素，则返回false，否则返回true。
             当队列为空时，向队列中获取元素，则返回null，否则返回元素。
- 一直阻塞  : 当阻塞队列满时，如果生产者向队列中插入元素，则队列会一直阻塞当前线程，直到队列可用或响应中断退出。
             当阻塞队列为空时，如果消费者线程向阻塞队列中获取数据，则队列会一直阻塞当前线程，直到队列空闲或响应中断退出。
             
- 超时退出  : 当队列满时，如果生产线程向队列中添加元素，则队列会阻塞生产线程一段时间，超过指定的时间则退出返回false。
             当队列为空时，消费线程从队列中移除元素，则队列会阻塞一段时间，如果超过指定时间退出返回null。

1.是一个用数组实现的有界阻塞队列，此队列按照先进先出（FIFO）的原则对元素进行排序。
  支持公平锁和非公平锁。
  注：
  每一个线程在获取锁的时候可能都会排队等待，如果在等待时间上，先获取锁的线程的请求一定先被满足，那么这个锁就是公平的。
  反之，这个锁就是不公平的。公平的获取锁，也就是当前等待时间最长的线程先获取锁
  
  
  
  
############################ Java自定义注解 & AOP运用 #################################### 
- 场景：用户所属单位等信息，非前端必传，可通过Java AOP 及 自定义注解完成自动赋值；
- demo：InterceptRequestParamAnnotation




############################ FeignClient #################################### 
1.FeignClient 调用不可以直接注入，定义 Manage 进行注入；
2.Feign 调用断路器：
  - 定义类实现 feign.hystrix.FallbackFactory 并范型为





      
############################ SHIRO ####################################
认证过滤器：
anon：无需认证即可访问，游客身份。
authc：必须认证（登录）才能访问。
authcBasic：需要通过 httpBasic 认证。
user：不一定已通过认证，只要是曾经被 Shiro 记住过登录状态的用户就可以正常发起请求，比如 rememberMe。

授权过滤器:
perms：必须拥有对某个资源的访问权限（授权）才能访问。
role：必须拥有某个角色权限才能访问。
port：请求的端口必须为指定值才可以访问。
rest：请求必须是 RESTful，method 为 post、get、delete、put。
ssl：必须是安全的 URL 请求，协议为 HTTPS。