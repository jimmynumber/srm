/**
 * 
 */
package com.want.srm.utils;

import java.io.IOException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

/**  
* 类说明   
* @author 00323707  
* @date 2020年11月16日 上午11:18:14  
*/
/**
 * @author 00323707
 *
 */
public class PdfExport extends PdfPageEventHelper {

	public PdfTemplate tpl = null;
	private static BaseFont bf = null;

	private String EBELN;

	public String getEBELN() {
		return EBELN;
	}

	public void setEBELN(String eBELN) {
		EBELN = eBELN;
	}

	static {
		try {
			bf = BaseFont.createFont("static/SourceHanSerifSC-Regular.otf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public void onOpenDocument(PdfWriter writer, Document document) {  
//		try {  
//			tpl = writer.getDirectContent().createTemplate(100,100); 
//		}  
//		catch(Exception e) {  
//			throw new ExceptionConverter(e);  
//		} 
//	}  

	public void onStartPage(PdfWriter writer, Document document) {
		if ((writer.getPageNumber() - 1) == 1) {
			try {
				tpl = writer.getDirectContent().createTemplate(100, 100);
			} catch (Exception e) {
				throw new ExceptionConverter(e);
			}
		}
	}

	public void onEndPage(PdfWriter writer, Document document) {
		// 在每页结束的时候把“第x页”信息写道模版指定位置
		PdfContentByte cb = writer.getDirectContent();
		cb.saveState();
		String text = "ORDER NO:  " + EBELN + "       PAGE: " + (writer.getPageNumber() - 1) + "/";
		cb.beginText();
		cb.setFontAndSize(bf, 10f);
		cb.setTextMatrix(382, 812);// 定位“第x页,共” 在具体的页面调试时候需要更改这xy的坐标
		cb.showText(text);
		cb.endText();
		cb.addTemplate(tpl, 560, 812);// 定位“y页” 在具体的页面调试时候需要更改这xy的坐标

		// cb.saveState();
		cb.stroke();
		cb.restoreState();
		cb.closePath();
	}

	public void onCloseDocument(PdfWriter writer, Document document) {
		// 关闭document的时候获取总页数，并把总页数按模版写道之前预留的位置
		tpl.beginText();
		tpl.setFontAndSize(bf, 10f);
		tpl.showText(Integer.toString(writer.getPageNumber() - 2));
		tpl.endText();
		tpl.closePath();
	}

}
