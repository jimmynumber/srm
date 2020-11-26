/**
 * 
 */
package com.want.srm.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.RectangleReadOnly;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.want.srm.entity.ZT008;
import com.want.srm.entity.ZT009;
import com.want.srm.entity.ZT034;
import com.want.srm.entity.ZT038;
import com.want.srm.vo.ZT003VO;

/**  
* 类说明   
* @author 00323707  
* @date 2020年10月19日 下午7:41:06  
*/
/**
 * @author 00323707
 *
 */
public class PdfUtils {

	// 字体
    private static BaseFont baseFont = null;
    
    static{
        try {
            /**
             * 设置字体
             * 
             * windows路径字体
             * FONT_TYPE=C:/Windows/fonts/simsun.ttc
             * linux路径字体 宋体 (如果没有这个字体文件，就将windows的字体传上去)
             * FONT_TYPE=/usr/share/fonts/win/simsun.ttc
             */
            //可以用配置文件读取
            //获取配置
            //PropertiesLoader pl = new PropertiesLoader("/config/config.properties");  
            //拼接文件web访问路径
            //String FONT_TYPE = pl.getProperty("FONT_TYPE");  
            //解决中文问题  幼圆
        	//baseFont = BaseFont.createFont("C:/Windows/Fonts/simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            baseFont = BaseFont.createFont("static/SourceHanSerifSC-Regular.otf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            //baseFont = BaseFont.createFont( "/usr/share/fonts/siyuan/SourceHanSerifSC-Bold.otf,1",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
            
    /**
     * 文档超级  排版
     * @param type 1-标题 2-标题一  3-标题二 4-标题三  5-正文  6-左对齐
     */
    public static Paragraph getFont(int type, String text){
        Font font = new Font(baseFont);
        if(1 == type){
            font.setSize(17f);
            font.setStyle(Font.BOLD);
        } else if(2 == type){
            font.setSize(9f);
        } else if(3 == type){
            font.setSize(9f);
        } else if(4 == type){
            font.setSize(9f);
        } else if(5 == type){
            font.setSize(10.5f);
        } else if(6 == type){
            font.setSize(9f);
        } else {
            font.setSize(10.5f);
        }
        //注： 字体必须和 文字一起new
        Paragraph paragraph = new Paragraph(text, font);
        if(1 == type){
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);//居中
            paragraph.setSpacingBefore(5f);//上间距
            //paragraph.setSpacingAfter(-25f);//下间距
        } else if(2 == type){
            paragraph.setAlignment(Element.ALIGN_CENTER);
        } else if(3 == type){
        	paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.setSpacingBefore(4f);//上间距
        } else if(4 == type){//4-标题三
        	paragraph.setAlignment(Element.ALIGN_LEFT);
            paragraph.setFirstLineIndent(2);//首行缩进
        } else if(5 == type){
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED); 
            paragraph.setFirstLineIndent(24);//首行缩进
            paragraph.setSpacingBefore(1f);//上间距
            paragraph.setSpacingAfter(1f);//下间距
        } else if(6 == type){//左对齐
            paragraph.setAlignment(Element.ALIGN_LEFT); 
        }
        //paragraph.setIndentationLeft(50);//整体缩进左边
        //paragraph.setFirstLineIndent(40);//首行缩进
        return paragraph;
    }
    
    public static PdfPTable createTable(PdfWriter writer,ZT008 zt008) throws DocumentException, ParseException{
    	float[] columnWidths = {50,30,30,30,30,40,40,25,65,40};
	    PdfPTable table = new PdfPTable(10);//生成表格
	    table.setWidths(columnWidths);
	    PdfPCell cell = new PdfPCell();
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"对账表单号：")));
	    table.addCell(setCell(PdfUtils.getFont(6,zt008.getDzbdh().toString())));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"收货方：")));
	    table.addCell(setCell(PdfUtils.getFont(6,zt008.getWerks())));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"收货方名称：")));
	    cell = setCell(PdfUtils.getFont(6,zt008.getName1()));
	    cell.setColspan(3);
	    table.addCell(cell);
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"价税合计总价：")));
	    table.addCell(setCell(PdfUtils.getFont(6,zt008.getTtlam()+"")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"对账表状态：")));
	    table.addCell(setCell(PdfUtils.getFont(6,zt008.getConfs())));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"供应商代码： ")));
	    table.addCell(setCell(PdfUtils.getFont(6,zy3(zt008.getLifnr()))));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"供应商名称：")));
	    cell = setCell(PdfUtils.getFont(6,zt008.getName()));
	    cell.setColspan(3);
	    table.addCell(cell);
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"未税合计总价：")));
	    table.addCell(setCell(PdfUtils.getFont(6,zt008.getTtlam2()+"")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"过帐日期：")));
	    table.addCell(setCell(PdfUtils.getFont(6,zy(zt008.getBedat()))));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"至")));
	    table.addCell(setCell(PdfUtils.getFont(6,zy(zt008.getEndat()))));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"单价币别：")));
	    cell = setCell(PdfUtils.getFont(6,zt008.getWaers()));
	    cell.setColspan(3);
	    table.addCell(cell);
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"异常处理未完成项目价税合计：")));
	    table.addCell(setCell(PdfUtils.getFont(6,zt008.getTtlmi()+"")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"进料异常处理完成日期：")));
	    table.addCell(setCell(PdfUtils.getFont(6,zy(zt008.getYcsdat()))));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"至")));
	    table.addCell(setCell(PdfUtils.getFont(6,zy(zt008.getYcedat()))));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"付款条件：")));
	    cell = setCell(PdfUtils.getFont(6,zt008.getText1()));
	    cell.setColspan(3);
	    table.addCell(cell);
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"本期可开票价税合计总价：")));
	    table.addCell(setCell(PdfUtils.getFont(6,zt008.getTtleq()+"")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"制程异常处理完成日期：")));
	    table.addCell(setCell(PdfUtils.getFont(6,zy(zt008.getCycsdat()))));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"至")));
	    table.addCell(setCell(PdfUtils.getFont(6,zy(zt008.getCycedat()))));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"扣款方式：")));
	    cell = setCell(PdfUtils.getFont(6,zt008.getZzgbz()));
	    cell.setColspan(3);
	    table.addCell(cell);
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"本期扣款金额：")));
	    table.addCell(setCell(PdfUtils.getFont(6,zt008.getTtlfi()+"")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"UD完成日期：")));
	    table.addCell(setCell(PdfUtils.getFont(6,zy(zt008.getUdbdate()))));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"至")));
	    table.addCell(setCell(PdfUtils.getFont(6,zy(zt008.getUdedate()))));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"实际收货方：")));
	    table.addCell(setCell(PdfUtils.getFont(6,zt008.getZsjwerks())));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"实际收货方名称：")));
	    cell = setCell(PdfUtils.getFont(6,zt008.getZsjwerksDesc()));
	    cell.setColspan(3);
	    table.addCell(cell);
	    table.setSpacingAfter(36f);
	    //table.setSpacingBefore(-10);
	    table.setTotalWidth(812F);
	    table.setLockedWidth(true);
	    return table;
	  }
	
	public static PdfPTable createTable1(PdfWriter writer,List<ZT009> zt009) throws DocumentException, IOException, ParseException{
		float[] columnWidths = {50,120,90,180,100,100,100,100,100,70,120,100,100,80,80,80,50};
	    PdfPTable table = new PdfPTable(17);//生成表格
	    table.setWidths(columnWidths);
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"序号")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"采购订单编号")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"物料号码")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"物料描述")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"过帐日期")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"UD过账日期")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"本期到货数量")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"计量单位描述")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"换算到货数量")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"辅助计量单位")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"本期到货金额（价税合计）")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"异常单号")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"异常日期")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"异常数量")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"扣款金额")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"异常处理状态")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"税率")));
	    
	    if(zt009 != null && zt009.size()>0) {
		    for(int i=0;i<zt009.size();i++) {
		    	table.addCell(setCell(PdfUtils.getFont(6,(i+1)+"")));
			    table.addCell(setCell(PdfUtils.getFont(6,zt009.get(i).getEbeln())));
			    table.addCell(setCell(PdfUtils.getFont(6,zy2(zt009.get(i).getMatnr()))));
			    table.addCell(setCell(PdfUtils.getFont(6,zt009.get(i).getMaktx())));
			    table.addCell(setCell(PdfUtils.getFont(6,zy(zt009.get(i).getBudat()))));
			    table.addCell(setCell(PdfUtils.getFont(6,zy(zt009.get(i).getVaedatum()))));
			    table.addCell(setCell(PdfUtils.getFont(6,zt009.get(i).getBpmng()+"")));
			    table.addCell(setCell(PdfUtils.getFont(6,zt009.get(i).getMsehl())));
			    table.addCell(setCell(PdfUtils.getFont(6,zt009.get(i).getMenge())));
			    table.addCell(setCell(PdfUtils.getFont(6,zt009.get(i).getMsehs())));
			    table.addCell(setCell(PdfUtils.getFont(6,zt009.get(i).getDmbtr()+"")));
			    table.addCell(setCell(PdfUtils.getFont(6,zy1(zt009.get(i).getQmnum()))));
			    table.addCell(setCell(PdfUtils.getFont(6,zy(zt009.get(i).getErdat()))));
			    if((zt009.get(i).getMgeig()+"").equals("0.0")) {
			    	table.addCell(setCell(PdfUtils.getFont(6,"0.000")));
			    }else {
			    	table.addCell(setCell(PdfUtils.getFont(6,zt009.get(i).getMgeig()+"")));
			    }
			    if((zt009.get(i).getPcje()+"").equals("0.0")) {
			    	table.addCell(setCell(PdfUtils.getFont(6,"0.00")));
			    }else {
			    	table.addCell(setCell(PdfUtils.getFont(6,zt009.get(i).getPcje()+"")));
			    }
			    table.addCell(setCell(PdfUtils.getFont(6,zt009.get(i).getGysfkzt())));
			    table.addCell(setCell(PdfUtils.getFont(6,zt009.get(i).getMwskz())));
		    }
	    }
	    
	    table.setSpacingAfter(4f);
	    table.setSpacingBefore(4f);
	    table.setTotalWidth(812F);
	    table.setLockedWidth(true);
	    return table;
	  }
	
	public static PdfPTable createTable2(PdfWriter writer,List<ZT034> zt034) throws DocumentException, IOException, ParseException{
	    PdfPTable table = new PdfPTable(6);//生成表格
	    float[] columnWidths = {30,60,60,60,60,60};
	    table.setWidths(columnWidths);
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"序号")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"异常单号")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"异常日期")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"表单完成日期")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"异常数量")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"扣款金额")));
	    
	    if(zt034 != null && zt034.size()>0) {
		    for(int i=0;i<zt034.size();i++) {
		    	table.addCell(setCell(PdfUtils.getFont(6,(i+1)+"")));
			    table.addCell(setCell(PdfUtils.getFont(6,zy1(zt034.get(i).getQmnum()))));
			    table.addCell(setCell(PdfUtils.getFont(6,zy(zt034.get(i).getErdat()))));
			    table.addCell(setCell(PdfUtils.getFont(6,zy(zt034.get(i).getBdwcdat()))));
			    table.addCell(setCell(PdfUtils.getFont(6,zt034.get(i).getMgeig()+"")));
			    table.addCell(setCell(PdfUtils.getFont(6,zt034.get(i).getPcje()+"")));
		    }
	    }
	    
	    table.setSpacingAfter(4f);
	    table.setSpacingBefore(4f);
	    table.setTotalWidth(420);
	    table.setLockedWidth(true);
	    table.setHorizontalAlignment(table.ALIGN_LEFT);
	    return table;
	  }
	
	public static PdfPTable createTable3(PdfWriter writer,List<ZT038> zt038) throws DocumentException, IOException{
	    PdfPTable table = new PdfPTable(9);//生成表格
	    float[] columnWidths = {20,80,120,60,60,60,60,60,60};
	    table.setWidths(columnWidths);
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"序号")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"物料编号")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"物料描述")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"本期到货数量")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"计量单位描述 ")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"换算到货数量")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"辅助计量单位")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"本期到货金额（未税合计） ")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"本期到货金额（价税合计）")));
	    
	    if(zt038 != null && zt038.size()>0) {
		    for(int i=0;i<zt038.size();i++) {
		    	table.addCell(setCell(PdfUtils.getFont(6,(i+1)+"")));
			    table.addCell(setCell(PdfUtils.getFont(6,zy2(zt038.get(i).getMatnr()))));
			    table.addCell(setCell(PdfUtils.getFont(6,zt038.get(i).getMaktx())));
			    table.addCell(setCell(PdfUtils.getFont(6,zt038.get(i).getBpmng()+"")));
			    table.addCell(setCell(PdfUtils.getFont(6,zt038.get(i).getMsehl())));
			    table.addCell(setCell(PdfUtils.getFont(6,zt038.get(i).getMenge()+"")));
			    table.addCell(setCell(PdfUtils.getFont(6,zt038.get(i).getMsehs())));
			    table.addCell(setCell(PdfUtils.getFont(6,zt038.get(i).getDmbtr1()+"")));
			    table.addCell(setCell(PdfUtils.getFont(6,zt038.get(i).getDmbtr()+"")));
		    }
	    }
	    
	    table.setSpacingAfter(4f);
	    table.setSpacingBefore(4f);
	    table.setTotalWidth(640);
	    table.setLockedWidth(true);
	    table.setHorizontalAlignment(table.ALIGN_LEFT);
	    return table;
	  }
	
	public static PdfPTable createTable4(PdfWriter write,List<ZT003VO> zt003) throws DocumentException, IOException{
	    PdfPTable table = new PdfPTable(10);//生成表格
	    float[] columnWidths = {60,60,80,60,60,80,160,60,60,120};
	    table.setWidths(columnWidths);
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"SRM异常单号")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"BPM异常单号")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"SRM异常单状态")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"异常类别 ")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"扣款金额")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"最终处理结果")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"最终处理结果备注 ")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"采购订单")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"物料号")));
	    table.addCell(setCellCenter(PdfUtils.getFont(2,"物料描述")));
	    
	    if(zt003 != null && zt003.size()>0) {
		    for(int i=0;i<zt003.size();i++) {
		    	table.addCell(setCell(PdfUtils.getFont(6,zy1(zt003.get(i).getQmnum()))));
			    table.addCell(setCell(PdfUtils.getFont(6,zt003.get(i).getBycd())));
			    table.addCell(setCell(PdfUtils.getFont(6,zt003.get(i).getGysfkzt())));
			    table.addCell(setCell(PdfUtils.getFont(6,zt003.get(i).getQmart())));
			    table.addCell(setCell(PdfUtils.getFont(6,zt003.get(i).getPcje()+"")));
			    table.addCell(setCell(PdfUtils.getFont(6,zt003.get(i).getClfsDes())));
			    table.addCell(setCell(PdfUtils.getFont(6,zt003.get(i).getClfs())));
			    table.addCell(setCell(PdfUtils.getFont(6,zt003.get(i).getEbeln())));
			    table.addCell(setCell(PdfUtils.getFont(6,zy2(zt003.get(i).getMatnr()))));
			    table.addCell(setCell(PdfUtils.getFont(6,zt003.get(i).getMaktx())));
		    }
	    }
	    
	    table.setSpacingBefore(4f);
	    table.setTotalWidth(812F);
	    table.setLockedWidth(true);
	    return table;
	  }
	
	public static PdfPCell setCell(Paragraph para) {
		  PdfPCell cell = new PdfPCell(para);
		  return cell;
	  }
	  
	  public static PdfPCell setCellCenter(Paragraph para) {
		  PdfPCell cell = new PdfPCell(para);
		  cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		  cell.setFixedHeight(20);
		  return cell;
	  }
	  
	  public void createStatementPDF(Document document, PdfWriter writer,Map<String, Object> model) throws Exception  {
		  		document.setPageSize(new RectangleReadOnly(842F,595F));
		  		document.setMargins(15,15,40,0);
			try {
				ZT008 zt008 = (ZT008)model.get("ZT008");
				Phrase headerPara = new Phrase();
				headerPara.add(PdfUtils.getFont(1, zt008.getName1() + " 原物料对账表"));
				headerPara.add(PdfUtils.createTable(writer,zt008));
				HeaderFooter header=new HeaderFooter(headerPara,false);
				header.setBorder(Rectangle.NO_BORDER); 
				header.setAlignment(HeaderFooter.ALIGN_CENTER);
				document.setHeader(header);
				document.open();
				
		        document.add(PdfUtils.createTable1(writer,(List<ZT009>)model.get("ZT009")));
		        document.add(PdfUtils.getFont(4, "本期制程异常明细"));
		        document.add(PdfUtils.createTable2(writer,(List<ZT034>)model.get("ZT034")));
		        document.add(PdfUtils.getFont(4, "本期到货数量汇总"));
		        document.add(PdfUtils.createTable3(writer,(List<ZT038>)model.get("ZT038")));
		        document.add(PdfUtils.getFont(4, "SRM异常单号和BPM异常文号对应信息（以下信息仅供我司内部使用）"));
		        document.add(PdfUtils.createTable4(writer,(List<ZT003VO>)model.get("ZT003")));
		    } catch (DocumentException e) {
		        e.printStackTrace();
		    } finally {
		        document.close();
		    }
		}
	  
	  public static String zy(String str) throws ParseException {
		  	SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		  	SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyyMMdd");
			if(str == null || "00000000".equals(str) || "0000-00-00".equals(str) || "null".equals(str) || "".equals(str)) {
				return "";
			}else {
				if(str.length()==8) {
					return dateFormat.format(dateFormat1.parse(str));
				}else {
					return dateFormat.format(dateFormat.parse(str));
				}
			}
		}
	  
	  public static String zy1(String str) {
		  if(str != null && !"".equals(str)) {
				return str.substring(3);
		  }else {
			  return str;
		  }
		}
	  
	  public static String zy2(String str) {
		  if(str != null && !"".equals(str)) {
				return str.substring(4);
		  }else {
			  return str;
		  }
	}
	  
	  public static String zy3(String str) {
		  if(str != null && "00".equals(str.substring(0,2))) {
				return str.substring(2);
		  }else {
			  return str;
		  }
		}

    
}
