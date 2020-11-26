package com.want.srm.service;

import com.want.srm.utils.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * redisTemplate封装
 * @ClassName: RedisService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 00418053
 * @date Oct 27, 2020
 *
 */
@Component
public class RedisService {

	@Autowired
	private JedisConnectionFactory connectionFactory;
	@Autowired
    private RedisTemplate<String, String> redisTemplate;

	public RedisService() {
	}

	private <T> T execute(Function<T, RedisConnection> fun) {
		RedisConnection conn = null;
		try {
			conn = connectionFactory.getConnection();
			return fun.callback(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != conn) {
				// 检测连接是否有效，有效则放回到连接池中，无效则重置状态
				conn.close();
			}
		}
		return null;
	}

	/**
	 * <执行redis的SET操作>
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public String set(final String key, final String value) {
		return execute(new Function<String, RedisConnection>() {

			@Override
			public String callback(RedisConnection e) {

				e.set(key.getBytes(), value.getBytes());
				return "true";
			}
		});
	}

	/**
	 * <执行redis的get方法>
	 *
	 * @param key
	 * @return
	 */
	public byte[] get(final String key) {
		return execute(new Function<byte[], RedisConnection>() {

			@Override
			public byte[] callback(RedisConnection e) {
				return e.get(key.getBytes());
			}
		});
	}

	/**
	 * <执行redis的删除>
	 *
	 * @param key
	 * @return
	 */
	public Long delete(final String key) {
		return execute(new Function<Long, RedisConnection>() {

			@Override
			public Long callback(RedisConnection e) {
				return e.del(key.getBytes());
			}
		});
	}

	/**
	 * <根据key模糊匹配并删除满足条件的数据>
	 *
	 * @param key
	 * @return
	 */
	public Long batchDel(final String key) {
		return execute(new Function<Long, RedisConnection>() {

			@Override
			public Long callback(RedisConnection e) {
				long num = 0;
				Set<byte[]> keys = e.keys(("*" + key + "*").getBytes());
				for (byte[] key : keys) {
					num += e.del(key);
				}
				return num;
			}
		});
	}

	/**
	 * <设置生存时间，单位为秒>
	 *
	 * @param key
	 * @param seconds
	 * @return
	 */
	public Boolean expire(final String key, final Integer seconds) {
		return execute(new Function<Boolean, RedisConnection>() {

			@Override
			public Boolean callback(RedisConnection e) {
				return e.expire(key.getBytes(), seconds);
			}
		});
	}

	/**
	 * <执行SET操作，并且设置生存时间，单位为秒>
	 *
	 * @param key
	 * @param value
	 * @param seconds
	 * @return
	 */
	public String set(final String key, final String value, final Integer seconds) {
		return execute(new Function<String, RedisConnection>() {

			@Override
			public String callback(RedisConnection e) {
				e.set(key.getBytes(), value.getBytes());
				// 设置生存时间
				e.expire(key.getBytes(), seconds);
				return "true";
			}
		});
	}

    public void deleteByPrex(String prex) {
        Set<String> keys=redisTemplate.keys(prex+"*");
        redisTemplate.delete(keys);
    }

    public void deleteBySuffix(String suffix) {
        Set<String> keys=redisTemplate.keys("*"+suffix);
        redisTemplate.delete(keys);
    }

    public void deleteByMidfix(String midfix) {
        Set<String> keys=redisTemplate.keys("*"+midfix+"*");
        redisTemplate.delete(keys);
    }
}