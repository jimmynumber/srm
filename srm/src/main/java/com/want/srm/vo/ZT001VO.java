package com.want.srm.vo;

import java.io.Serializable;
import java.util.List;

import com.want.srm.po.FileInofPO;

import lombok.Data;

@Data
public class ZT001VO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String tdline;    //质量通知单的长文本
	private List<ZT001> zt001List;
	private List<FileInofPO> fileinoList;
	
	@Data
	public static class ZT001{
		private String qmnum;     //通知单号
		private String fenum;     //通知单行项目
		private String fecod;     //缺陷代码
		private String fegrp;     //缺陷代码组
		private String feqklas;   //缺陷类别
		private String feqklasDesc; //缺陷类别描述
		private String fegrpName; //缺陷代码组描述
		private String fecodName; //缺陷描述
		private String upUser;    //用户名
		private String upDate;    //日期
		private String upTime;    //时间
		
	}
	
}
