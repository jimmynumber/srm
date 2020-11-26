package com.want.controller;

import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.entity.Emp;
import com.want.repository.IEmpRepository;
import com.want.vo.CommonResult;

@RestController
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private IEmpRepository empDao;

	@RequestMapping("/queryEmpAll")
	public CommonResult queryEmpAll() {
		CommonResult result = new CommonResult();
		List<Emp> empList = empDao.findAll();
		for (Emp emp : empList) {
			System.out.println(emp);
		}
		result.setData(empList);
		return result;
	}
	
	@PostMapping("/SaveOrUpdate")
    public Emp save(@RequestBody Emp emp){
        return empDao.save(emp);
    }
	
    @GetMapping("/findByNameAndPassword")
    public Emp findByNameAndPassword(String ename,String sex){
        return empDao.findByEnameAndSex(ename,sex);
    }
    
    @GetMapping("/findQueryHql")
    public Emp findQueryHql(String ename,String sex){
        return empDao.findQueryHql(ename,sex);
    }
    
    @GetMapping("/findByQuery")
    public Emp findByQuery(String ename,String sex){
        return empDao.findByQuery(ename,sex);
    }
    @GetMapping("/findAll")
    public Page<Emp> findAll(int page,int size,int eid){
        page =page -1;
        Pageable pageable =PageRequest.of(page,size,Sort.by(Sort.Direction.DESC,"eid"));
        return empDao.findAll(
        		 (Specification<Emp>) (root, query, cb) -> {
            Predicate p1 = cb.like(root.get("eid").as(String.class),"%"+eid+"%");
            return cb.and(p1);
        },pageable);
        
    }  
    
}
