package com.want.redis.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.want.redis.model.RedisUser;

@Repository
@Mapper
public interface RedisUserMapper {
	@Insert("insert into redisuser(name,age) values(#{name},#{age})")
	int addUser(@Param("name") String name, @Param("age") String age);

	@Select("select * from redisuser where id =#{id}")
	RedisUser findById(@Param("id") String id);

	@Update("update redisuser set name=#{name},age=#{age}  where id=#{id}")
	// void updataById(@Param("id")String id,@Param("name")String name);
	// void updataById(@Param("id")String id,@Param("name")String name);
	int updateById(RedisUser user);

	@Delete("delete from redisuser where id=#{id}")
	void deleteById(@Param("id") String id);
}