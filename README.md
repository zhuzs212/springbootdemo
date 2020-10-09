# springbootdemo
############## 待优化部分 ######################
1.接口入参，需进一步拆分细化至具体操作

############## SHIRO ######################
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


############## 编码最佳实践 ######################
1.获取安全加密的随机数
SecureRandom sr = new SecureRandom();

1.非空/null检查
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
2.集合初始化（集合初始化指定大小，最大程度降低容器自动扩容）
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
     
