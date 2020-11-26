package com.want.srm.po;

import java.io.Serializable;

import lombok.Data;

@Data
public class FileInofPO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fileName;  //文件名
	private String gysfkxm;   //供应商反馈附件行项目
	private String lineNum;   //附件行项目返回
	private String qmnum;     //通知单号
	private String fileDesc;  //文件描述
	private String filePath;  //文件路径
	private String upDate;    //日期
	private String upTime;    //时间
}
