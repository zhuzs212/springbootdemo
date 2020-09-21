# springbootdemo
############## 待优化部分 ######################
1.接口入参，需进一步拆分细化至具体操作



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
     
