package com.want.srm.controller;

import java.util.Map;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.want.srm.po.FileInofPO;
import com.want.srm.service.IAbnormalOrderService;
import com.want.srm.service.IBaseDataService;
import com.want.srm.service.StatementService;
import com.want.srm.utils.FileUtil;
import com.want.srm.vo.CommonReturnType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "附件上传")
@RestController
@CrossOrigin
@RequestMapping("/fileUpload")
public class FileUploadController {

	@Autowired
	private IAbnormalOrderService service;
	
	@Autowired
	private IBaseDataService baseDataService;
	
	@ApiOperation(value = "删除附件", nickname="deleteZT005", notes = "post获取")
	@PostMapping("/deleteZT005") 
	public CommonReturnType deleteZT005(@RequestBody(required=true)Map<String, String> map) {
		return service.deleteZT005(map.get("qmnum"), map.get("gysfkxm"));
	}
	
	@Value("${RealPath}")
    private String realPath;
	
	@RequestMapping(value="/uploadFile",method = RequestMethod.POST)//MultipartFile,CommonsMultipartFile
    public CommonReturnType uploadFile( MultipartFile file,
    		@RequestParam("noticeCode")String noticeCode,
    		@RequestParam("fileName")String fileName,
    		@RequestParam("fileDesc")String fileDesc    		
    		) throws IOException {
		List<FileInofPO> fileInfoList=new ArrayList<FileInofPO>();
    	try {
    		System.out.println("MultipartFile="+file+"file.getSize()="+file.getSize()+",fileInfo="+fileName);
        	System.out.println("realPath="+realPath);
        	SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyy-MM-dd");
    		SimpleDateFormat dateFormat2= new SimpleDateFormat("HH:mm:ss");
    		Date date = new Date();
        	//1、磁盘保存文件
    		//String newFileName = FileUtil.getSaveFileName(fileName);
    		List<Map<String, String>> maps = baseDataService.checkFileName(noticeCode);
    		for (Map<String, String> map : maps) {
	    		if(map.get("FILE_NAME").substring(19).equals(fileName)) {
	    			return CommonReturnType.create(null, "附件名称重复", "E");
	    		}
    		}
    		
        	String gysfkxm = baseDataService.checkFile(noticeCode);
        	if(gysfkxm == null) {
        		gysfkxm = "00001";
        	}else {
        		gysfkxm = String.format("%05d",Integer.parseInt(gysfkxm)+1);
        	}
    		String newFileName = noticeCode+"_"+gysfkxm+"_"+fileName;
    		String fileSavePath = FileUtil.getFileSavePath();
    		String filePath = realPath + fileSavePath;
    		//String filePath = "D:/"+realPath + fileSavePath;
    		//windows下
    		if("\\".equals(File.separator)){
    			filePath = filePath.replace("/", "\\");
    		}else{
    			//linux下
    			filePath = filePath.replaceAll("\\\\", "/");
    		}
    		File targetFile = new File(filePath);
    		if (!targetFile.exists()) {
    			targetFile.mkdirs();
    		}
    		File targetFile1 = new File(filePath,newFileName);
    		file.transferTo(targetFile1);
    		// 2、保存数据到DB
    		FileInofPO fileInfo=new FileInofPO();
    		fileInfo.setFileName(newFileName);
    		fileInfo.setFilePath(filePath);
    		fileInfo.setQmnum(noticeCode);
    		fileInfo.setFileDesc(fileDesc);
    		fileInfo.setGysfkxm(gysfkxm);
    		fileInfo.setLineNum(Integer.parseInt(gysfkxm)+"");
    		fileInfo.setUpDate(dateFormat1.format(date));
    		fileInfo.setUpTime(dateFormat2.format(date));
    		baseDataService.uploadFile(fileInfo);
    		fileInfoList.add(fileInfo);
		} catch (Exception e) {
			System.out.print(e.toString());
			return CommonReturnType.create(e.getCause(), "上传附件失败", "E");
		}
    	return CommonReturnType.create(fileInfoList, "上传成功");
    }
	
}
