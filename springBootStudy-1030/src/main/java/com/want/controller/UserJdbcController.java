package com.want.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.entity.UserJdbc;

@RestController
@RequestMapping("userJdbc")
public class UserJdbcController {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	// http://localhost:8081/userJdbc/createUserTable
	//创建数据表
    @GetMapping("createUserTable")
    public String createUserTable() throws Exception {
        String sql = "CREATE TABLE `userJdbc` (\n" +
                "  `id` int(10) NOT NULL AUTO_INCREMENT,\n" +
                "  `username` varchar(100) DEFAULT NULL,\n" +
                "  `password` varchar(100) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\n" +
                "\n";
            jdbcTemplate.execute(sql);
            return "创建表成功";
    }
    
    // http://localhost:8081/userJdbc/saveUserTest
    //saveUserTest
    //添加一个测试数据
    @GetMapping("saveUserTest")
    public String saveUserTest()throws Exception  {
        String sql = "INSERT INTO userJdbc (USERNAME,PASSWORD) VALUES ('longzhiran','123456')";
        int rows = jdbcTemplate.update(sql);
        return "执行成功，影响" + rows + "行";
    }
    
    //http://localhost:8081/userJdbc/batchSave
    //batchSaveUser
    //批量添加测试数据
    @GetMapping("batchSave")
    public String batchSaveUser()throws Exception  {
        String sql = "INSERT INTO userJdbc (USERNAME,PASSWORD) VALUES (?,?)";
        List<Object[]> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String[] arr = new String[2];
            arr[0] = "longzhiran" + i;
            arr[1] = "123456" + i;
            arrayList.add(arr);
        }
        jdbcTemplate.batchUpdate(sql, arrayList);
        return "执行成功";
    }
    
    // http://localhost:8081/userJdbc/add?userName=longzhiran&passWord=123456
    //
    @GetMapping("add")
    public String addUser(String userName, String passWord) throws Exception {
        String sql = "INSERT INTO userJdbc (USERNAME,PASSWORD) VALUES (?,?)";
        int rows = jdbcTemplate.update(sql, userName, passWord);
        return "执行成功，影响" + rows + "行";
    }
    
    //http://localhost:8081/userJdbc/updateUserPassword?id=1&passWord=12345678
    @GetMapping("updateUserPassword")
    public String updateUserPassword(int id, String passWord) throws Exception {
        String sql = "UPDATE userJdbc SET PASSWORD = ? WHERE ID = ?";
        int rows = jdbcTemplate.update(sql, passWord, id);
        return "执行成功，影响" + rows + "行";
    }
    
    //http://localhost:8081/userJdbc/deleteUserById?id=1
    @GetMapping("deleteUserById")
    public String deleteUserById(int id) throws Exception {
        String sql = "DELETE FROM  userJdbc  WHERE ID = ?";
        int rows = jdbcTemplate.update(sql, id);
        return "执行成功，影响" + rows + "行";
    }
    

    //http://localhost:8081/userJdbc/getUserByName?userName=longzhiran
    @GetMapping("getUserByName")
    public List<UserJdbc> getUserByName(String userName)throws Exception {
        String sql = "SELECT * FROM userJdbc WHERE USERNAME = ?";
        List<UserJdbc> list = jdbcTemplate.query(sql, new UserJdbc(), new Object[]{userName});
        return list;
    }
    
    //http://localhost:8081/userJdbc/getMapById?id=2
    @GetMapping("getMapById")
    public Map<String, Object> getMapById(Integer id) throws Exception {
        String sql = "SELECT * FROM userJdbc WHERE ID = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, id);
        return map;
    }
    
    //http://localhost:8081/userJdbc/getUserById?id=2
    @GetMapping("getUserById")
    public UserJdbc getUserById(Integer id) throws Exception {
        String sql = "SELECT * FROM userJdbc WHERE ID = ?";
        UserJdbc user = jdbcTemplate.queryForObject(sql, new UserJdbc(), new Object[]{id});
        return user;
    }

    //http://localhost:8081/userJdbc/list
    @SuppressWarnings("unchecked")
	@GetMapping("list")
    public List<UserJdbc> list() throws Exception {
        String sql = "SELECT * FROM userJdbc";

        List<UserJdbc> userList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(UserJdbc.class));
        return userList;
    }
    
}
