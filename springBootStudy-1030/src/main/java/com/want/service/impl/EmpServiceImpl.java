package com.want.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.want.entity.Emp;
import com.want.repository.IEmpRepository;

@Service
public class EmpServiceImpl {
    @Autowired  
    private IEmpRepository empDao;  

    public List<Emp> queryEmpAll() {  
         return empDao.findAll(); 
}
}
