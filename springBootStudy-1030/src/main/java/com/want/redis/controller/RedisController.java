package com.want.redis.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.redis.model.RedisUser;
import com.want.redis.service.UserService;

@RestController
@RequestMapping("/redisuser")
public class RedisController {

	@Autowired
	UserService userService;

	// http://localhost:8081/redisuser/3
	@RequestMapping("/{id}")
	public RedisUser ForTest(@PathVariable String id) {
		return userService.selectUser(id);
	}

	// http://localhost:8081/redisuser/addUser
	@RequestMapping("/addUser")
	public String addUser(@RequestBody RedisUser user) {
		userService.addUser(user);
		return "success";
	}

	// http://localhost:8081/redisuser/update
	@RequestMapping("/update")
	public String update(@RequestBody RedisUser user) {
		userService.updataById(user);
		return "success";
	}

	// http://localhost:8081/redisuser/delete/3
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		userService.deleteById(id);
		return "delete success";
	}

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@SuppressWarnings("rawtypes")
	@Autowired
    //@Qualifier("redisTemplateCustomize")
	private RedisTemplate redisTemplate;

	//http://localhost:8081/redisuser/test1
	@RequestMapping("/test1")
	public String test1() {
		redisTemplate.opsForValue().set("num", 123);
		redisTemplate.opsForValue().set("string", "some strings");
		Object s = redisTemplate.opsForValue().get("num");
		Object s2 = redisTemplate.opsForValue().get("string");
		System.out.println(s);
		System.out.println(s2);
		return "test1";
	}

	@SuppressWarnings("static-access")
	@RequestMapping("/test2")
	public String test2() {
		// 设置的是3秒失效，3秒之内查询有结果，3秒之后返回为null
		redisTemplate.opsForValue().set("num", "123XYZ", 3, TimeUnit.SECONDS);
		try {
			Object s = redisTemplate.opsForValue().get("num");
			System.out.println(s);
			Thread.currentThread().sleep(2000);
			Object s2 = redisTemplate.opsForValue().get("num");
			System.out.println(s2);
			Thread.currentThread().sleep(5000);
			Object s3 = redisTemplate.opsForValue().get("num");
			System.out.println(s3);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		return "test2";
	}

	@RequestMapping("/test3")
	public String test3() {
		// 覆写(overwrite) 给定 key 所储存的字符串值，从偏移量 offset 开始
		redisTemplate.opsForValue().set("key", "helloworld", 7);
		System.out.println(redisTemplate.opsForValue().get("key"));
		return "test3";
	}

	@RequestMapping("/test4")
	public String test4() {
		// 设置键的字符串值并返回其旧值
		redisTemplate.opsForValue().set("getSetTest", "test");
		System.out.println(redisTemplate.opsForValue().getAndSet("getSetTest", "test2"));
		System.out.println(redisTemplate.opsForValue().get("getSetTest"));
		return "test4";
	}

	@RequestMapping("/test5")
	public String test5() {
		redisTemplate.opsForValue().append("k", "test");
		System.out.println(redisTemplate.opsForValue().get("k"));

		redisTemplate.opsForValue().append("k", "test2");
		System.out.println(redisTemplate.opsForValue().get("k"));
		return "test5";
	}

	@RequestMapping("/test6")
	public String test6() {
		redisTemplate.opsForValue().set("key", "1");
		System.out.println(redisTemplate.opsForValue().size("key"));
		return "test6";
	}

	@RequestMapping("/test7")
	public String test7() {
		Map<String, Object> testMap = new HashMap<String, Object>();
		testMap.put("name", "zhonghua");
		testMap.put("sex", "male");
		redisTemplate.opsForHash().putAll("Hash", testMap);
		System.out.println(redisTemplate.opsForHash().entries("Hash"));
		return "test7";
	}

	@RequestMapping("/test8")
	public String test8() {
		redisTemplate.opsForHash().put("redisHash", "name", "hongwei");
		redisTemplate.opsForHash().put("redisHash", "sex", "male");
		System.out.println(redisTemplate.opsForHash().entries("redisHash"));
		System.out.println(redisTemplate.opsForHash().values("redisHash"));
		return "test8";
	}

	@RequestMapping("/test9")
	public String test9() {
		redisTemplate.opsForHash().put("redisHash", "name", "hongwei");
		redisTemplate.opsForHash().put("redisHash", "sex", "male");
		System.out.println(redisTemplate.opsForHash().delete("redisHash", "name"));
		System.out.println(redisTemplate.opsForHash().entries("redisHash"));
		return "test9";
	}

	@RequestMapping("/test10")
	public String test10() {
		redisTemplate.opsForHash().put("redisHash", "name", "hongwei");
		redisTemplate.opsForHash().put("redisHash", "sex", "male");
		System.out.println(redisTemplate.opsForHash().hasKey("redisHash", "name"));
		System.out.println(redisTemplate.opsForHash().hasKey("redisHash", "age"));

		return "test10";
	}

	// 从键中的哈希获取给定hashKey的值
	@RequestMapping("/test12")
	public String test12() {
		redisTemplate.opsForHash().put("redisHash", "name", "hongwei");
		redisTemplate.opsForHash().put("redisHash", "sex", "male");
		System.out.println(redisTemplate.opsForHash().get("redisHash", "name"));
		return "test12";
	}

	@RequestMapping("/test13")
	public String test13() {
		// 获取key所对应的散列表的key
		redisTemplate.opsForHash().put("redisHash", "name", "hongwei");
		redisTemplate.opsForHash().put("redisHash", "sex", "male");
		System.out.println(redisTemplate.opsForHash().keys("redisHash"));
		return "test13";
	}

	@RequestMapping("/test14")
	public String test14() {
		// 获取key所对应的散列表的大小个数
		redisTemplate.opsForHash().put("redisHash", "name", "hongwei");
		redisTemplate.opsForHash().put("redisHash", "sex", "male");
		System.out.println(redisTemplate.opsForHash().size("redisHash"));
		return "test14";
	}

	@RequestMapping("/test15")
	public String test15() {
		// 批量把一个数组插入到列表中
		String[] strings = new String[] { "1", "2", "3" };
		redisTemplate.opsForList().leftPushAll("list", strings);
		System.out.println(redisTemplate.opsForList().range("list", 0, -1));
		return "test15";
	}

	@RequestMapping("/test16")
	public String test16() {
		// 返回存储在键中的列表的长度。如果键不存在，则将其解释为空列表，并返回0。当key存储的值不是列表时返回错误。
		String[] strings = new String[] { "1", "2", "3" };
		redisTemplate.opsForList().leftPushAll("list", strings);
		System.out.println(redisTemplate.opsForList().size("list"));
		return "test16";
	}

	@RequestMapping("/test17")
	public String test17() {
		// 将所有指定的值插入存储在键的列表的头部。如果键不存在，则在执行推送操作之前将其创建为空列表。（从左边插入）
		redisTemplate.opsForList().leftPush("list", "1");
		System.out.println(redisTemplate.opsForList().size("list"));
		redisTemplate.opsForList().leftPush("list", "2");
		System.out.println(redisTemplate.opsForList().size("list"));
		redisTemplate.opsForList().leftPush("list", "3");
		System.out.println(redisTemplate.opsForList().size("list"));
		return "test17";
	}

	@RequestMapping("/test18")
	public String test18() {
		// 将所有指定的值插入存储在键的列表的头部。如果键不存在，则在执行推送操作之前将其创建为空列表。（从右边插入）

		redisTemplate.opsForList().rightPush("listRight", "1");
		System.out.println(redisTemplate.opsForList().size("listRight"));
		redisTemplate.opsForList().rightPush("listRight", "2");
		System.out.println(redisTemplate.opsForList().size("listRight"));
		redisTemplate.opsForList().rightPush("listRight", "3");
		System.out.println(redisTemplate.opsForList().size("listRight"));
		return "test18";
	}

	@RequestMapping("/test19")
	public String test19() {
		String[] strings = new String[] { "1", "2", "3" };
		redisTemplate.opsForList().rightPushAll("list", strings);
		System.out.println(redisTemplate.opsForList().range("list", 0, -1));
		return "test19";
	}

	@RequestMapping("/test20")
	public String test20() {
		// 在列表中index的位置设置value值
		String[] strings = new String[] { "1", "2", "3" };
		redisTemplate.opsForList().rightPushAll("list6", strings);
		System.out.println(redisTemplate.opsForList().range("list6", 0, -1));
		redisTemplate.opsForList().set("list6", 1, "值");
		System.out.println(redisTemplate.opsForList().range("list6", 0, -1));
		return "test20";
	}

	@RequestMapping("/test21")
	public String test21() {
		// 删除列表中存储的列表中第一次次出现的
		String[] strings = new String[] { "1", "2", "3" };
		redisTemplate.opsForList().rightPushAll("list7", strings);
		System.out.println(redisTemplate.opsForList().range("list7", 0, -1));
		redisTemplate.opsForList().remove("list7", 1, "2");// 将删除列表中存储的列表中第一次次出现的“2”。
		System.out.println(redisTemplate.opsForList().range("list7", 0, -1));

		return "test21";
	}

	@RequestMapping("/test22")
	public String test22() {
		// 根据下表获取列表中的值，下标是从0开始的
		String[] strings = new String[] { "1", "2", "3" };
		redisTemplate.opsForList().rightPushAll("list8", strings);
		System.out.println(redisTemplate.opsForList().range("list8", 0, -1));
		System.out.println(redisTemplate.opsForList().index("list8", 2));
		return "test22";
	}

	@RequestMapping("/test23")
	public String test23() {
		// 弹出最左边的元素，弹出之后该值在列表中将不复存在
		String[] strings = new String[] { "1", "2", "3" };
		redisTemplate.opsForList().rightPushAll("list9", strings);
		System.out.println(redisTemplate.opsForList().range("list9", 0, -1));
		System.out.println(redisTemplate.opsForList().leftPop("list9"));
		System.out.println(redisTemplate.opsForList().range("list9", 0, -1));

		return "test23";
	}

	@RequestMapping("/test24")
	public String test24() {
		// 弹出最右边的元素，弹出之后该值在列表中将不复存在
		String[] strings = new String[] { "1", "2", "3" };
		redisTemplate.opsForList().rightPushAll("list10", strings);
		System.out.println(redisTemplate.opsForList().range("list10", 0, -1));
		System.out.println(redisTemplate.opsForList().rightPop("list10"));
		System.out.println(redisTemplate.opsForList().range("list10", 0, -1));
		return "test24";
	}

	@RequestMapping("/test25")
	public String test25() {
		// 无序集合中添加元素，返回添加个数
		String[] strs = new String[] { "str1", "str2" };
		System.out.println(redisTemplate.opsForSet().add("Set1", strs));
		// 也可以直接在add里面添加多个值
		System.out.println(redisTemplate.opsForSet().add("Set1", "1", "2", "3"));

		return "test25";
	}

	@RequestMapping("/test26")
	public String test26() {
		// 移除集合中一个或多个成员
		String[] strs = new String[] { "str1", "str2" };
		System.out.println(redisTemplate.opsForSet().add("Set2", strs));
		System.out.println(redisTemplate.opsForSet().remove("set2", strs));

		return "test26";
	}

	@RequestMapping("/test27")
	public String test27() {
		// 移除并返回集合中的一个随机元素
		String[] strs = new String[] { "str1", "str2" };
		System.out.println(redisTemplate.opsForSet().add("Set3", strs));
		System.out.println(redisTemplate.opsForSet().pop("Set3"));
		System.out.println(redisTemplate.opsForSet().members("Set3"));

		return "test27";
	}

	@RequestMapping("/test28")
	public String test28() {
		// 将 member 元素从进行移动
		String[] strs = new String[] { "str1", "str2" };
		System.out.println(redisTemplate.opsForSet().add("Set4", strs));
		redisTemplate.opsForSet().move("Set4", "str2", "Set4to2");
		System.out.println(redisTemplate.opsForSet().members("Set4"));
		System.out.println(redisTemplate.opsForSet().members("Set4to2"));

		return "test28";
	}

	@RequestMapping("/test29")
	public String test29() {
		// 无序集合的大小长度
		String[] strs = new String[] { "str1", "str2" };
		System.out.println(redisTemplate.opsForSet().add("Set5", strs));
		System.out.println(redisTemplate.opsForSet().size("Set5"));

		return "test29";
	}

	@RequestMapping("/test30")
	public String test30() {
		// 返回集合中的所有成员
		String[] strs = new String[] { "str1", "str2" };
		System.out.println(redisTemplate.opsForSet().add("Set6", strs));
		System.out.println(redisTemplate.opsForSet().members("Set6"));
		return "test30";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/test31")
	public String test31() {
		// 遍历set
		String[] strs = new String[] { "str1", "str2" };
		System.out.println(redisTemplate.opsForSet().add("Set7", strs));
		Cursor<Object> curosr = redisTemplate.opsForSet().scan("Set7", ScanOptions.NONE);
		while (curosr.hasNext()) {
			System.out.println(curosr.next());
		}
		return "test31";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/test32")
	public String test32() {
        ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-1", 9.6);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-2", 9.9);
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        System.out.println(redisTemplate.opsForZSet().add("zset1", tuples));
        System.out.println(redisTemplate.opsForZSet().range("zset1", 0, -1));
		return "test32";
	}

	@RequestMapping("/test33")
	public String test33() {
		// 新增一个有序集合，存在的话为false，不存在的话为true
		System.out.println(redisTemplate.opsForZSet().add("zset2", "zset-1", 1.0));
		System.out.println(redisTemplate.opsForZSet().add("zset2", "zset-1", 1.0));
		return "test33";
	}

	@RequestMapping("/test34")
	public String test34() {
		// 从有序集合中移除一个或者多个元素
		System.out.println(redisTemplate.opsForZSet().add("zset3", "zset-1", 1.0));
		System.out.println(redisTemplate.opsForZSet().add("zset3", "zset-2", 1.0));
		System.out.println(redisTemplate.opsForZSet().range("zset3", 0, -1));
		System.out.println(redisTemplate.opsForZSet().remove("zset3", "zset-2"));
		System.out.println(redisTemplate.opsForZSet().range("zset3", 0, -1));

		return "test34";
	}

	@RequestMapping("/test35")
	public String test35() {
		// 返回有序集中指定成员的排名，其中有序集成员按分数值递增(从小到大)顺序排列
		System.out.println(redisTemplate.opsForZSet().add("zset4", "zset-1", 1.0));
		System.out.println(redisTemplate.opsForZSet().add("zset4", "zset-2", 1.0));
		System.out.println(redisTemplate.opsForZSet().range("zset4", 0, -1));
		System.out.println(redisTemplate.opsForZSet().rank("zset4", "zset-1"));
		return "test35";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/test36")
	public String test36() {
		// 通过索引区间返回有序集合成指定区间内的成员，其中有序集成员按分数值递增(从小到大)顺序排列
		ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-1", 9.6);
		ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-2", 9.1);
		Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
		tuples.add(objectTypedTuple1);
		tuples.add(objectTypedTuple2);
		System.out.println(redisTemplate.opsForZSet().add("zset5", tuples));
		System.out.println(redisTemplate.opsForZSet().range("zset5", 0, -1));
		return "test36";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/test37")
	public String test37() {
		// 通过分数返回有序集合指定区间内的成员个数
		ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-1", 3.6);
		ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-2", 4.1);
		ZSetOperations.TypedTuple<Object> objectTypedTuple3 = new DefaultTypedTuple<>("zset-3", 5.7);
		Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
		tuples.add(objectTypedTuple1);
		tuples.add(objectTypedTuple2);
		tuples.add(objectTypedTuple3);
		System.out.println(redisTemplate.opsForZSet().add("zset6", tuples));
		System.out.println(redisTemplate.opsForZSet().rangeByScore("zset6", 0, 9));
		System.out.println(redisTemplate.opsForZSet().count("zset6", 0, 5));
		return "test37";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/test38")
	public String test38() {
		// 获取有序集合的成员数
		ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-1", 3.6);
		ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-2", 4.1);
		ZSetOperations.TypedTuple<Object> objectTypedTuple3 = new DefaultTypedTuple<>("zset-3", 5.7);
		Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
		tuples.add(objectTypedTuple1);
		tuples.add(objectTypedTuple2);
		tuples.add(objectTypedTuple3);
		System.out.println(redisTemplate.opsForZSet().add("zset7", tuples));
		System.out.println(redisTemplate.opsForZSet().size("zset7"));
		return "test38";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/test39")
	public String test39() {
		// 获取指定成员的score值
		ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-1", 3.6);
		ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-2", 4.1);
		ZSetOperations.TypedTuple<Object> objectTypedTuple3 = new DefaultTypedTuple<>("zset-3", 5.7);
		Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
		tuples.add(objectTypedTuple1);
		tuples.add(objectTypedTuple2);
		tuples.add(objectTypedTuple3);
		System.out.println(redisTemplate.opsForZSet().add("zset8", tuples));
		System.out.println(redisTemplate.opsForZSet().score("zset8", "zset-3"));
		return "test39";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/test40")
	public String test40() {
		// 获取指定成员的score值
		ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-1", 3.6);
		ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-2", 5.1);
		ZSetOperations.TypedTuple<Object> objectTypedTuple3 = new DefaultTypedTuple<>("zset-3", 2.7);
		Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
		tuples.add(objectTypedTuple1);
		tuples.add(objectTypedTuple2);
		tuples.add(objectTypedTuple3);
		System.out.println(redisTemplate.opsForZSet().add("zset9", tuples));
		System.out.println(redisTemplate.opsForZSet().range("zset9", 0, -1));
		System.out.println(redisTemplate.opsForZSet().removeRange("zset9", 1, 2));
		System.out.println(redisTemplate.opsForZSet().range("zset9", 0, -1));
		return "test40";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/test41")
	public String test41() {
		// 遍历zset
		ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-1", 3.6);
		ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-2", 5.1);
		ZSetOperations.TypedTuple<Object> objectTypedTuple3 = new DefaultTypedTuple<>("zset-3", 2.7);
		Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
		tuples.add(objectTypedTuple1);
		tuples.add(objectTypedTuple2);
		tuples.add(objectTypedTuple3);
		System.out.println(redisTemplate.opsForZSet().add("zset10", tuples));
		Cursor<ZSetOperations.TypedTuple<Object>> cursor = redisTemplate.opsForZSet().scan("zset10", ScanOptions.NONE);
		while (cursor.hasNext()) {
			ZSetOperations.TypedTuple<Object> item = cursor.next();
			System.out.println(item.getValue() + ":" + item.getScore());
		}
		return "test41";
	}

	@RequestMapping("/test42")
	public String test42() {
		// 有十个库存
		Integer count = 100;
		// 添加到redis list中

		for (Integer i = 0; i < count; i++) {
			redisTemplate.opsForList().leftPush("slist", 1);
		}
		System.out.println(redisTemplate.opsForList().range("slist", 0, -1));
		return "test42";
	}

	@RequestMapping("/test43")
	public String test43() {
		// 判断计数器
		if (redisTemplate.opsForList().size("slist") > 0) {
			long user_id = 1903;
			redisTemplate.opsForList().leftPush("ulist", user_id);
		}
		System.out.println(redisTemplate.opsForList().range("slist", 0, -1));
		System.out.println(redisTemplate.opsForList().range("ulist", 0, -1));
		return "test43";
	}
	@RequestMapping("/test44")
	public String test44() {
		return "test44";
	}
}