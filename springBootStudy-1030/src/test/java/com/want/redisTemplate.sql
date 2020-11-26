
1、leftPush(K key, V value) 在变量左边添加元素值。(left|right)Push
    redisTemplate.opsForList().leftPush("list","a");  
    redisTemplate.opsForList().leftPush("list","b");  
    redisTemplate.opsForList().leftPush("list","c");  

2. index(K key, long index)   获取集合指定位置的值。
    String listValue = redisTemplate.opsForList().index("list",1) + "";  
    System.out.println("通过index(K key, long index)方法获取指定位置的值:" + listValue);  

3、range(K key, long start, long end) 获取指定区间的值。
    List<Object> list =  redisTemplate.opsForList().range("list",0,-1);  
    System.out.println("通过range(K key, long start, long end)方法获取指定范围的集合值:"+list);  

4、leftPush(K key, V pivot, V value) 把最后一个参数值放到指定集合的第一个出现中间参数的前面，如果中间参数值存在的话。
    redisTemplate.opsForList().leftPush("list","a","n");  
    list =  redisTemplate.opsForList().range("list",0,-1);  
    System.out.println("通过leftPush(K key, V pivot, V value)方法把值放到指定参数值前面:" + list);  

5、leftPushAll(K key, V... values) 向左边批量添加参数元素。
	redisTemplate.opsForList().leftPushAll("list","w","x","y");  
	list =  redisTemplate.opsForList().range("list",0,-1);  
	System.out.println("通过leftPushAll(K key, V... values)方法批量添加元素:" + list); 

6、leftPushAll(K key, Collection<V> values)  以集合的方式向左边批量添加元素。
    List newList = new ArrayList();  
    newList.add("o");  
    newList.add("p");  
    newList.add("q");  
    redisTemplate.opsForList().leftPushAll("list",newList);  
    list =  redisTemplate.opsForList().range("list",0,-1);  
    System.out.println("通过leftPushAll(K key, Collection<V> values)方法以集合的方式批量添加元素:" + list);  

7、leftPushIfPresent(K key, V value) 如果存在集合则添加元素。
    redisTemplate.opsForList().leftPushIfPresent("presentList","o");  
    list =  redisTemplate.opsForList().range("presentList",0,-1);  
    System.out.println("通过leftPushIfPresent(K key, V value)方法向已存在的集合添加元素:" + list);  

8、size(K key) 获取集合长度。
    long listLength = redisTemplate.opsForList().size("list");  
    System.out.println("通过size(K key)方法获取集合list的长度为:" + listLength);  

9、leftPop(K key) 移除集合中的左边第一个元素。
    Object popValue = redisTemplate.opsForList().leftPop("list");  
    System.out.print("通过leftPop(K key)方法移除的元素是:" + popValue);  
    list =  redisTemplate.opsForList().range("list",0,-1);  
    System.out.println(",剩余的元素是:" + list);  

10、leftPop(K key, long timeout, TimeUnit unit) 移除集合中左边的元素在等待的时间里，如果超过等待的时间仍没有元素则退出。
    popValue = redisTemplate.opsForList().leftPop("presentList",1, TimeUnit.SECONDS);  
    System.out.print("通过leftPop(K key, long timeout, TimeUnit unit)方法移除的元素是:" + popValue);  
    list =  redisTemplate.opsForList().range("presentList",0,-1);  
    System.out.println(",剩余的元素是:" + list);  

11、rightPopAndLeftPush(K sourceKey, K destinationKey) 移除集合中右边的元素，同时在左边加入一个元素。
    popValue = redisTemplate.opsForList().rightPopAndLeftPush("list","12");  
    System.out.print("通过rightPopAndLeftPush(K sourceKey, K destinationKey)方法移除的元素是:" + popValue);  
    list =  redisTemplate.opsForList().range("list",0,-1);  
    System.out.println(",剩余的元素是:" + list);  

12、rightPopAndLeftPush(K sourceKey, K destinationKey, long timeout, TimeUnit unit) 移除集合中右边的元素在等待的时间里，
同时在左边添加元素，如果超过等待的时间仍没有元素则退出。
	popValue = redisTemplate.opsForList().rightPopAndLeftPush("presentList","13",1,TimeUnit.SECONDS);  
	System.out.println("通过rightPopAndLeftPush(K sourceKey, K destinationKey, long timeout, TimeUnit unit)方法移除的元素是:" + popValue);  
	list =  redisTemplate.opsForList().range("presentList",0,-1);  
	System.out.print(",剩余的元素是:" + list); 

13、set(K key, long index, V value)
    在集合的指定位置插入元素,如果指定位置已有元素，则覆盖，没有则新增，超过集合下标+n则会报错。
    redisTemplate.opsForList().set("presentList",3,"15");  
    list =  redisTemplate.opsForList().range("presentList",0,-1);  
    System.out.print("通过set(K key, long index, V value)方法在指定位置添加元素后:" + list);  

14、remove(K key, long count, Object value)
    从存储在键中的列表中删除等于值的元素的第一个计数事件。
    count> 0：删除等于从左到右移动的值的第一个元素；
    count< 0：删除等于从右到左移动的值的第一个元素；
    count = 0：删除等于value的所有元素。

    long removeCount = redisTemplate.opsForList().remove("list",0,"w");  
    list =  redisTemplate.opsForList().range("list",0,-1);  
    System.out.println("通过remove(K key, long count, Object value)方法移除元素数量:" + removeCount);  
    System.out.println(",剩余的元素:" + list);  

15、trim(K key, long start, long end)
    截取集合元素长度，保留长度内的数据。
    redisTemplate.opsForList().trim("list",0,5);  
    list =  redisTemplate.opsForList().range("list",0,-1);  
    System.out.println("通过trim(K key, long start, long end)方法截取后剩余元素:" + list);  

/*************************/

2.afterPropertiesSet               //配置默认序列化与反序列化工具类
3.execute               //根据参数执行相关operation操作，例如，事务
4.executePipelined               //执行pipelining流水线相关操作
5.executeWithStickyConnection               //执行指定connection连接的相关操作
6.executeSession               //执行session内的execute方法
7.createRedisConnectionProxy               //创建RedisConnection代理类
8.preProcessConnection               //connection连接的预处理
9.postProcessResult               //结果的后处理，默认什么都不做
10.isExposeConnection               //是否向RedisCallback暴露本地连接
11.setExposeConnection               //设置是否向RedisCallback暴露本地连接
12.isEnableDefaultSerializer               //12到26都是设置和获取相关序列化工具类
13.setEnableDefaultSerializer
14.getDefaultSerializer
15.setDefaultSerializer
16.setKeySerializer
17.getKeySerializer
18.setValueSerializer
19.getValueSerializer
20.getHashKeySerializer
21.setHashKeySerializer
22.getHashValueSerializer
23.setHashValueSerializer
24.getStringSerializer
25.setStringSerializer
26.setScriptExecutor
27.rawKey               //27到34为私有方法，不对外提供使用
28.rawString
29.rawValue
30.rawKeys
31.deserializeKey
32.deserializeMixedResults
33.deserializeSet
34.convertTupleValues
35.exec               //执行事务
36.execRaw
37.delete               //删除操作
38.unlink               //接触链接
39.hasKey               //查看是否含有指定key
40.countExistingKeys
41.expire               //设置过期时间
42.expireAt
43.convertAndSend               //转换成字节流并向channel发送message
44.getExpire               //获取过期时间
46.keys               //根据传入的正则表达式返回所有的key
47.persist               //取消指定key的过期时间
48.move               //移动指定的key和index到数据库中
49.randomKey               //从键空间随机获取一个key
50.rename               //将指定key改成目标key
51.renameIfAbsent               //key不存在时，将指定key改成目标key
52.type               //设置存储在指定key的类型
53.dump               //检索存储在key的值的序列化版本
54.restore               //执行Redis的restore的命令
55.multi               //标记事务阻塞的开始
56.discard               //丢弃所有在multi之后发出的命令
57.watch               //观察指定key在事务处理开始即multi之后的修改情况
58.unwatch               //刷新先前观察的所有key
59.sort               //为key元素排序
60.killClient               //关闭客户端连接
61.getClientList               //请求连接客户端的相关信息和统计数据
62.slaveOf               //更改复制配置到新的master
63.slaveOfNoOne               //将本机更改为master
64.opsForCluster               //64到79都是获取相对应的操作
65.opsForGeo
66.boundGeoOps
67.boundHashOps
68.opsForHash
69.opsForHyperLogLog
70.opsForList
71.boundListOps
72.boundSetOps
73.opsForSet
74.opsForStream
75.boundStreamOps
76.boundValueOps
77.opsForValue
78.boundZSetOps
79.opsForZSet
80.setEnableTransactionSupport               //设置是否支持事务
81.setBeanClassLoader               //设置bean的类加载器








