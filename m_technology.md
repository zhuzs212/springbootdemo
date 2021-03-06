
########################################### 注解
1.Annotation 是从JDK5.0开始引入的新技术
2.Annotation 的作用
- 不是程序本身，可以对程序做出解释；
- 可以被其他程序（比如：编译器等）读取
3.Annotation在哪里使用
- package、class、method、filed等，相当于给他们添加了一些额外的辅助信息，
  我们可以通过反射机制实现对这些元素的访问。 
4.元注解
  负责注解其他注解，即用来对其他annotation类型作说明。（java.lang.annotation包）
- @Target：指定注解的作用范围（ElementType）；
- @Retention：指定注解的生命周期（RetentionPolicy：保留策略 runtime > class > sources）
- @Documented：说明该注解将被包含在 Javadoc 中；
- @Inherited：子类可以继承父类的该注解；

5.自定义注解
- @interface 
  
  
########################################### 反射
1.Java反射机制概述
- Reflection 是Java被视为动态语言的关键。反射机制允许程序在执行期借助于Reflection API
  取得任何类的内部信息，并能直接操作任意对象的内部属性及方法。
- 加载完类之后，在堆内存的方法区中就产生了一个Class类型的对象（一个类只有一个Class对象），
  这个对象包含了完整的类的结构信息。
优点：
    可以实现动态创建对象和编译，灵活性大；
缺点：
    反射是一种解释性操作，耗性能；

2.理解Class类并获取Class实例 
- Class 本身也是一个类
- Class对象只能由系统建立
- 一个加载的类在JVM中只会有一个Class实例
- 一个Class对象对应的是一个加载到JVM中的.class文件
- 每个类的实例都会记得自己是由哪个Class实例所生成
- 通过Class可以完整地得到一个类中的所有被加载的结构；
- Class类是Reflection的根源，针对任何你想动态加载、运行的类，唯有先获得相应的Class对象

3.类的加载与ClassLoader

4.创建运行时类的对象

5.获取运行时类的完整结构

6.调用运行时类的指定结构

########################################### 定时任务
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


########################################### 阻塞队列
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
  
  
########################################### FeignClient
1.FeignClient 调用不可以直接注入，定义 Manage 进行注入；
2.Feign 调用断路器：
  - 定义类实现 feign.hystrix.FallbackFactory 并范型为
 
 
 
 
 ########################################### Spring框架 ###################################################################
 
  ########################################### IOC
 1.1 概念
 - IOC （控制反转），将对象的创建及对象之间的调用过程，交给Spring容器进行管理。目的是解耦合。
 
 1.2 底层原理
 - XML解析、工厂模式、反射
 
 2.0 IOC容器
 - IOC思想是基于IOC容器完成的，IOC底层就是对象工厂；
 - Spring提供IOC容器的两种实现方式：
    - BeanFactory
    IOC容器基本实现方式 ，是Spring内部使用的接口。加载配置文件时不会创建对象，在调用getBean("")方法时才会创建对象；
    - ApplicationContext
    BeanFactory子接口，提供更多更强大的功能。加载配置文件时，会将配置的所有对象进行创建。
 
 3.0 IOC操作 Bean管理（创建对象 &  属性注入）
 - 基于XML创建对象
    - Bean标签、id 唯一标识、class 类的全路径
    - 创建对象时，默认调用类的无参构造
 
 - 基于XML属性注入
    - DI（Dependency Injection）：依赖注入。容器可以通过set() 或者 构造器 来建立对象之间的依赖关系。
    - set方法注入
       - Bean标签内部，property标签，name（类属性名），value（待注入属性值）
    - 有参构造注入 
       - Bean标签内部，constructor-arg标签，name（类属性名），value（待注入属性值）
    
 
 - 基于注解创建对象
    - 引入依赖、开启组件扫描（细节配置）、添加注解 @Com ponent(value="")、@Controller(value="")、@Service(value="")、@Repository(value="")
 
 - 基于注解属性注入
    - @Autowired：根据属性类型进行自动装配
    - @Qualifier(value="")：根据属性名称进行自动装配，需要与@Autowired一起使用；
    - @Resource(name="")：根据属性类型、属性名称进行自动装配；
    - @Value：普通类型属性进行注入
 
 - 完全注解开发
    - 创建配置类，替代xml配置文件；
    - @Configuration
       @ComponentScan(basePackages={""})
       
       
 ########################################### AOP
 1.0 概念
 - AOP（Aspect Oriented Programming ），面向切面编程,即: 不用修改源代码就可以扩展功能；
 
 
 2.0 底层原理（通过动态代理来实现）
   a.JDK动态代理，只能对 实现了接口的 类 产生代理
   Proxy：返回指定接口的代理类的实例
   b.cglib动态代，对 没有实现接口的 类 产生代理
  
 
 3.术语：
 a.连接点
 - 类中所有可以被增强的方法
 b.切入点
 - 实际被增强的方法
 c.通知（增强）
 - 增强的逻辑部分
 - 通知有五种类型
   - Around
   - Before（前置通知：在目标方法执行前执行）
   - After（后置通知：在目标方法执行后执行，无论方法是否执行成功）
   - AfterReturnning（返回通知：在目标方法返回后执行，执行成功之后）
   - AfterThrowing（异常通知：在目标方法抛异常时执行）
 d.切面
 - 动作，把通知应用到切入点的过程
 
 
 4.AOP 操作
 a.Spring框架一般都是基于AspectJ实现AOP操作；
 - AspectJ：独立的AOP框架
 
 b.基于AspectJ实现AOP操作
 - 基于XML配置
 - 基于注解
   - @Component｜@Aspect、@Pointcut、@Before...
   - 切入点表达式
      execution([权限修饰符][返回值类型][类全路径][方法名称]([参数列表])) 
   - @Pointcut  提取公共切入点
   - 有多个增强类对同一个方法进行增强，设置增强类的优先级。在增强类上添加注解@Order(0/1/2/3/4)，值越小优先级越高
 
 - 基于完全注解开发的 AOP配置
   @Configuration
   @ComponentScan(basePackages = "com.zhuzs.admin")
   // 表示开启AOP代理自动配置；表示使用cglid进行代理对象的生成；表示通过aop框架暴露该代理对象；
   @EnableAspectJAutoProxy(proxyTargetClass = true) 
   public class AopConfig {
   }




########################################### 第三方框架 ###################################################################

########################################### shiro 
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


########################################### JWT




############################################## 中间件 ###################################################################

########################################### RocketMQ 

1.Github 上关于 RocketMQ 的介绍:
  RcoketMQ 是一款低延迟、高可靠、可伸缩、易于使用的消息中间件。具有以下特性：
  - 支持发布/订阅（Pub/Sub）和点对点（P2P）消息模型
  - 在一个队列中可靠的先进先出（FIFO）和严格的顺序传递
  - 支持拉（pull）和推（push）两种消息模式
  - 单一队列百万消息的堆积能力
  - 支持多种消息协议，如 JMS、MQTT 等
  - 分布式高可用的部署架构,满足至少一次消息传递语义
  - 提供 docker 镜像用于隔离测试和云集群部署
  - 提供配置、指标和监控等功能丰富的 Dashboard
  
  https://www.jianshu.com/p/824066d70da8



########################################### nacos 
1.在spring cloud版本中我们使用eureka、consul等做为服务注册中心，使用spring cloud config做为配置中心;
  而在spring cloud alibaba中，使用nacos组件即可完成服务注册发现与服务配置两大功能



