package com.want.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.want.entity.Emp;

public interface IEmpRepository extends JpaRepository<Emp, Integer>{

    /**
     * jpa的第一种查询方式 根据命名规范来查询
     * @return 单个员工或者null
     */
    Emp findByEnameAndSex(String ename,String sex);
 
    /**
     * HQL 查询，说白了就是根据实体进行查询
     * @return 单个员工或者null
     */
    @Query(value = "select e from Emp e where ename =?1 and sex=?2")
    Emp findQueryHql(String ename,String sex);
    
    @Query(value = "select e from Emp e where ename = :ename and sex= :sex")
    Emp findQueryHql1(@Param("ename")String ename,@Param("sex")String sex);
    
    /*
    * 删除  必须加入@Modifying和@Transactional
    * */
    @Modifying
    @Transactional
    @Query("delete from Emp u where u.eid= :eid")
    int deleteUserByEid(@Param("eid") Integer eid);
    
    
    @Modifying
    @Transactional
    @Query("update Emp u set u.ename = :ename where u.eid=:eid")
    int modfifyUserById(@Param("eid") Integer eid,@Param("ename") String ename);
    
    @Modifying
    @Transactional
    @Query(value = "insert into Emp value(?,?,?)", nativeQuery = true)
    int countUserBy(@Param("eid")Integer eid,@Param("ename") String ename,@Param("sex") String sex);
    
    /**
     * 原生sql进行查询
     * @return 单个员工或者null
     */
    @Query(value = "select * from  emp2  where ename =?1 and sex=?2",nativeQuery =true)
    Emp findByQuery(String ename,String sex);
 
    /**
     * 复杂查询
     * @param spec 拼接的条件语句 如果有很复杂的语句比如 select * from a where a.name ='' ,
     *             a.password ='' or a.name ='' or a.name ='' or a.name in  ('','')
     * @param pageable 分页加排序 Pageable已经将这些事情做好了。
     * @return Page 形式的员工列表
     */
    Page<Emp> findAll(Specification<Emp> spec,Pageable pageable);

}
