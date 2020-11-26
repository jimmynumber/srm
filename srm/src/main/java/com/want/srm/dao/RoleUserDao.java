package com.want.srm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.want.srm.entity.RoleUser;
import com.want.srm.entity.RoleUserKey;
import com.want.srm.vo.RoleInfoVo;

@Mapper
public interface RoleUserDao {
    int deleteByPrimaryKey(RoleUserKey key);

    int insert(RoleUser record);

    int insertSelective(RoleUser record);

    RoleUser selectByPrimaryKey(RoleUserKey key);

    int updateByPrimaryKeySelective(RoleUser record);

    int updateByPrimaryKey(RoleUser record);
    
    List<RoleInfoVo> selectRoleInfoById(RoleUserKey key);
    
    List<RoleUser> selectRoleByUserId(RoleUserKey key);
}