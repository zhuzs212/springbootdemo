

############################################# Java 8 新特性  ############################################################    
1.函数式编程 和 Lambda表达式
  - 函数式接口，可以使用极简的lambda表达式实例化接口
  - lambda表达式，是实现函数式接口的一个快捷方式
    
2.Optional类
  - Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
    Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
    Optional 类的引入很好的解决空指针异常。



########################################### Java锁机制 ##################################################################
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


  
######################################## Java自定义注解 & AOP运用 ######################################################## 
- 场景：用户所属单位等信息，非前端必传，可通过Java AOP 及 自定义注解完成自动赋值；
- demo：InterceptRequestParamAnnotation

