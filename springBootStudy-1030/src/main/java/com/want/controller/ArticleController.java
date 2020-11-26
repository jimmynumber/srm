package com.want.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.want.entity.Article;
import com.want.repository.ArticleRepository;
import com.want.result.ExceptionMsg;
import com.want.result.Response;
import com.want.result.ResponseData;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("article")
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;

	/**
	 * Description: 文章列表
	 */
	@RequestMapping("")
	public ModelAndView articlelist(@RequestParam(value = "start", defaultValue = "0") Integer start,
			@RequestParam(value = "limit", defaultValue = "5") Integer limit) {
		start = start < 0 ? 0 : start;
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		Pageable pageable = PageRequest.of(start, limit, sort);
		Page<Article> page = articleRepository.findAll(pageable);
		ModelAndView mav = new ModelAndView("article/list");
		mav.addObject("page", page);
		return mav;
	}

	/**
	 * Description: 根据id获取文章对象
	 */
	@GetMapping("/{id}")
	public ModelAndView getArticle(@PathVariable("id") Integer id) throws Exception {
		Article articles = articleRepository.findById(id);
		ModelAndView mav = new ModelAndView("article/show");
		mav.addObject("article", articles);
		return mav;
	}

	/**
	 * Description: 新增操作视图
	 */
	@GetMapping("/add")
	public String addArticle() throws Exception {
		return "article/add";
	}

	/**
	 * Description: 新增保存方法
	 */
	@PostMapping("")
	public String saveArticle(Article model) throws Exception {
		articleRepository.save(model);
		return "redirect:/article/";
	}

	/**
	 * Description: 删除
	 */
	@DeleteMapping("/{id}")
	public String del(@PathVariable("id") long id) throws Exception {
		articleRepository.deleteById(id);
		return "redirect:";
	}

	/**
	 * Description: 编辑视图
	 */
	@GetMapping("/edit/{id}")
	public ModelAndView editArticle(@PathVariable("id") long id) throws Exception {
		Article model = articleRepository.findById(id);
		ModelAndView mav = new ModelAndView("article/edit");
		mav.addObject("article", model);
		return mav;
	}

	/**
	 * Description: 修改方法
	 */
	@PutMapping("/{id}")
	public String editArticleSave(Article model, long id) throws Exception {
		model.setId(id);
		articleRepository.save(model);
		return "redirect:";
	}

	/**********************************************/
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	 @ApiOperation(value = "/restful/", notes = "notes ")
	// http://localhost:8081/article/restful/
    @RequestMapping(value = "/restful/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData  getArticleList() {
        List<Article> list = new ArrayList<Article>(articleRepository.findAll());
        return new ResponseData(ExceptionMsg.SUCCESS,list);

    }

	//使用该注解忽略这个API
	@ApiIgnore
    //增 http://localhost:8081/article/restful/add?title=11&body=22
    @RequestMapping(value = "/restful/add", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData add(Article article) {
        articleRepository.save(article);
       // return "{success:true,message: \"添加成功\" }";
        return new ResponseData(ExceptionMsg.SUCCESS,article);
    }

    //删 http://localhost:8081/article/restful/9
    @RequestMapping(value = "/restful/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Response delete(@PathVariable("id") long id) {
       /*
        RestTemplate client= restTemplateBuilder.build();
        String uri = "http://localhost:8081/article/restful" + "/9";
        Map map= new HashMap();
        map. put ("orderid",id);
        //Void article = client.delete(uri,map,id);
        */
        articleRepository.deleteById(id);
        return new Response(ExceptionMsg.SUCCESS);
      }
    
    //改 http://localhost:8081/article/restful/update/7?title=121&body=121
    @RequestMapping(value = "/restful/update/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData update(Article model) {
        articleRepository.save(model);
        return new ResponseData(ExceptionMsg.SUCCESS,model);
    }
    
    //查 http://localhost:8081/article/restful/findArticle/7
    @RequestMapping(value = "/restful/findArticle/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData findArticle(@PathVariable("id") Integer id) {
              Article article = articleRepository.findById(id);
        if (article != null) {
            return new ResponseData(ExceptionMsg.SUCCESS,article);
        }
        return new ResponseData(ExceptionMsg.FAILED,article);
    }
    
    //查 http://localhost:8081/article/restful/findByid/7
    @RequestMapping(value = "/restful/findByid/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Article findByid(@PathVariable("id") Integer id) {
    	return articleRepository.findById(id);
    }
    
    //查  http://localhost:8081/article/restful/findArticle2/7
    @RequestMapping(value = "/restful/findArticle2/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Article findArticled2(@PathVariable("id") Integer id) {
        RestTemplate client= restTemplateBuilder.build();
        String uri = "http://localhost:8081/article/restful/findByid/"+id;
        System.out.println(uri);
        Article article = client.getForObject (uri,Article.class,id) ;

        return article;
    }
    /**/
    
    
}


