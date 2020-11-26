package com.want.srm.utils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.itextpdf.text.PageSize;
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
import com.want.srm.vo.ZT003VO;

public class AbnormalorderPdf extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileName = "异常反馈单_" + new Date().getTime() + ".pdf";
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(fileName.getBytes(), "iso8859-1"));
		AbnormalorderPdfUtils pdfUtil = new AbnormalorderPdfUtils();
		pdfUtil.createPDF(document, writer, model);
	}

	public static class AbnormalorderPdfUtils {
		// 字体
		private BaseFont baseFont = null;
		private Map<String, String> feqklasMap = null; // 异常类别
		private Map<String, String> exceptionTypeMap = null; // 异常类别2

		AbnormalorderPdfUtils() {
			try {
				feqklasMap = new HashMap<String, String>();
				feqklasMap.put("01", "关键缺陷");
				feqklasMap.put("02", "主要缺陷A");
				feqklasMap.put("03", "主要缺陷B");
				feqklasMap.put("04", "次要缺陷A");
				feqklasMap.put("05", "次要缺陷B");
				exceptionTypeMap = new HashMap<String, String>();
                exceptionTypeMap.put("F2", "进厂检验异常");
                exceptionTypeMap.put("F4", "生产发生异常");
                exceptionTypeMap.put("F5", "仓库抽检中发现异常");
				baseFont = BaseFont.createFont("static/SourceHanSerifSC-Regular.otf", BaseFont.IDENTITY_H,
						BaseFont.NOT_EMBEDDED);
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void createPDF(Document document, PdfWriter writer, Map<String, Object> model) throws Exception {
			document.setPageSize(new RectangleReadOnly( 595F,842F));
			//document.setPageSize(new RectangleReadOnly(283.0F, 425.0F));
			//document.setPageSize(com.lowagie.text.PageSize.A4);
			//document.setMargins(5, 5, 40, 0);
			document.setMargins(15,15,40,0);
			try {
				Phrase headerPara = new Phrase();
				headerPara.add(this.createTable(writer, model));
				HeaderFooter header = new HeaderFooter(headerPara, false);
				header.setBorder(Rectangle.NO_BORDER);
				header.setAlignment(HeaderFooter.ALIGN_CENTER);
				document.setHeader(header);
				document.open();

			} catch (DocumentException e) {
				e.printStackTrace();
			} finally {
				document.close();
			}
		}

		public PdfPTable createTable(PdfWriter writer, Map<String, Object> map)
				throws DocumentException, ParseException {

			PdfPTable table = new PdfPTable(10);// 生成表格
			table.setWidths(new float[] {60F, 60F, 56.5F, 56.5F, 56.5F, 56.5F, 56.5F, 56.5F, 56.5F, 56.5F});

			ZT003VO zt003VO = (ZT003VO) map.get("zt003VO");
			String tdline=(String) map.get("tdline");
			String feqklas=(String) map.get("feqklas");
			
			PdfPCell cell = null;
			// 第1行
			cell = setCellCenter(this.getFont(2, "原物料异常反馈单"));
			cell.setColspan(5);
			table.addCell(cell);

			cell = new PdfPCell(this.getFont(6, "通知单:" + this.lTrim(zt003VO.getQmnum())));
			cell.setColspan(5);
			table.addCell(cell);

			// 第2行
			table.addCell(new PdfPCell(this.getFont(2, "工厂代码")));
			table.addCell(new PdfPCell(this.getFont(6, zt003VO.getWerks())));

			table.addCell(new PdfPCell(this.getFont(2, "工厂描述")));
			cell = new PdfPCell(this.getFont(6, zt003VO.getWerksName()));
			cell.setColspan(2);
			table.addCell(cell);

			table.addCell(new PdfPCell(this.getFont(2, "实际工厂")));
			table.addCell(new PdfPCell(this.getFont(6, zt003VO.getZsjwerks())));

			table.addCell(new PdfPCell(this.getFont(2, "实际工厂描述")));
			cell = new PdfPCell(this.getFont(6, zt003VO.getZsjwerksDesc()));
			cell.setColspan(2);
			table.addCell(cell);

			// 第3行
			table.addCell(new PdfPCell(this.getFont(2, "物料号")));
			table.addCell(new PdfPCell(this.getFont(6, this.lTrim(zt003VO.getMatnr()))));

			table.addCell(new PdfPCell(this.getFont(2, "物料描述")));
			cell = new PdfPCell(this.getFont(6, zt003VO.getMaktx()));
			cell.setColspan(7);
			table.addCell(cell);

			// 第4行
			table.addCell(new PdfPCell(this.getFont(2, "供应商代码")));
			table.addCell(new PdfPCell(this.getFont(6, this.lTrim(zt003VO.getLifnr()))));

			table.addCell(new PdfPCell(this.getFont(2, "供应商全称")));
			cell = new PdfPCell(this.getFont(6, zt003VO.getLifnrName()));
			cell.setColspan(7);
			table.addCell(cell);

			// 第5行
			cell =new PdfPCell(this.getFont(2, "大小/量纲(规格)"));
			cell.setColspan(2);
			table.addCell(cell);

			cell = new PdfPCell(this.getFont(6, zt003VO.getGroes()));
			cell.setColspan(8);
			table.addCell(cell);

			// 第6行
			cell =new PdfPCell(this.getFont(2, "收货过账日期"));
			cell.setColspan(2);
			table.addCell(cell);
						
			cell = new PdfPCell(this.getFont(6, zt003VO.getBudat()));
			cell.setColspan(2);
			table.addCell(cell);

			table.addCell(new PdfPCell(this.getFont(2, "意见数量")));
			cell = new PdfPCell(this.getFont(6, zt003VO.getRkmng()));
			cell.setColspan(2);
			table.addCell(cell);

			cell = new PdfPCell(this.getFont(2, "收货物料凭证号"));
			cell.setColspan(2);
			table.addCell(cell);
			cell = new PdfPCell(this.getFont(6, zt003VO.getMblnr()));
			cell.setColspan(1);
			table.addCell(cell);

			// 第7行
			cell =new PdfPCell(this.getFont(2, "异常创建日期"));
			cell.setColspan(2);
			table.addCell(cell);
			
			cell = new PdfPCell(this.getFont(6, zt003VO.getErdat()));
			cell.setColspan(2);
			table.addCell(cell);

			table.addCell(new PdfPCell(this.getFont(2, "原厂批号")));
			cell = new PdfPCell(this.getFont(6, zt003VO.getLichn()));
			cell.setColspan(2);
			table.addCell(cell);

			cell = new PdfPCell(this.getFont(2, "批次"));
			cell.setColspan(2);
			table.addCell(cell);
			cell = new PdfPCell(this.getFont(6, zt003VO.getCharg()));
			cell.setColspan(1);
			table.addCell(cell);

			// 第8行
			cell =new PdfPCell(this.getFont(2, "异常数量"));
			cell.setColspan(2);
			table.addCell(cell);
			
			cell = new PdfPCell(this.getFont(6, zt003VO.getMgeig()));
			cell.setColspan(2);
			table.addCell(cell);

			table.addCell(new PdfPCell(this.getFont(2, "数量单位")));
			cell = new PdfPCell(this.getFont(6, zt003VO.getMgein()));
			cell.setColspan(2);
			table.addCell(cell);

			cell = new PdfPCell(this.getFont(2, "扣款金额"));
			cell.setColspan(2);
			table.addCell(cell);
			cell = new PdfPCell(this.getFont(6, zt003VO.getPcje()));
			cell.setColspan(1);
			table.addCell(cell);

			// 第9行
			cell =new PdfPCell(this.getFont(2, "采购订单"));
			cell.setColspan(2);
			table.addCell(cell);
			
			cell = new PdfPCell(this.getFont(6, zt003VO.getEbeln()));
			cell.setColspan(2);
			table.addCell(cell);

			table.addCell(new PdfPCell(this.getFont(2, "行项目")));
			cell = new PdfPCell(this.getFont(6, zt003VO.getEbelp()));
			cell.setColspan(2);
			table.addCell(cell);

			cell = new PdfPCell(this.getFont(2, "异常单状态"));
			cell.setColspan(2);
			table.addCell(cell);
			cell = new PdfPCell(this.getFont(6, StringUtils.trimToEmpty(zt003VO.getGysfkzt())+StringUtils.trimToEmpty(zt003VO.getGysfkztDesc())));
			cell.setColspan(1);
			table.addCell(cell);

			// 第10行
			cell =new PdfPCell(this.getFont(2, "异常类别1"));
			cell.setColspan(2);
			table.addCell(cell);

			cell = new PdfPCell(this.getFont(6, mapToString(feqklasMap, feqklas)));
			cell.setColspan(8);
			table.addCell(cell);

			// 第11行
			cell =new PdfPCell(this.getFont(2, "异常类别2"));
			cell.setColspan(2);
			table.addCell(cell);

			// 异常类别2
			cell = new PdfPCell(this.getFont(6, mapToString(exceptionTypeMap, zt003VO.getQmart())));
			cell.setColspan(8);
			table.addCell(cell);

			// 第12行
			cell =new PdfPCell(this.getFont(2, "异常描述/品保部意见"));
			cell.setColspan(2);
			table.addCell(cell);

			cell = new PdfPCell(this.getFont(6, tdline));
			cell.setColspan(8);
			table.addCell(cell);

			// 第13行
			cell =new PdfPCell(this.getFont(2, "供应商反馈异常分析"));
			cell.setColspan(2);
			table.addCell(cell);

			cell = new PdfPCell(this.getFont(6, zt003VO.getYcfx()));
			cell.setColspan(8);
			table.addCell(cell);

			// 第14行
			cell =new PdfPCell(this.getFont(2, "供应商反馈处理意见"));
			cell.setColspan(2);
			table.addCell(cell);

			cell = new PdfPCell(this.getFont(6, zt003VO.getYccl()));
			cell.setColspan(8);
			table.addCell(cell);

			// 第15行
			cell =new PdfPCell(this.getFont(2, "供应商反馈改善措施"));
			cell.setColspan(2);
			table.addCell(cell);

			cell = new PdfPCell(this.getFont(6, zt003VO.getGsfs()));
			cell.setColspan(8);
			table.addCell(cell);

			// 第16行
			cell =new PdfPCell(this.getFont(2, "驳回原因"));
			cell.setColspan(2);
			table.addCell(cell);

			cell = new PdfPCell(this.getFont(6, zt003VO.getPhyy()));
			cell.setColspan(8);
			table.addCell(cell);

			// 第17行
			cell =new PdfPCell(this.getFont(2, "最终处理结果"));
			cell.setColspan(2);
			table.addCell(cell);

			cell = new PdfPCell(this.getFont(6, StringUtils.trimToEmpty(zt003VO.getClfsDes())+StringUtils.trimToEmpty(zt003VO.getClfsDesName())));
			cell.setColspan(8);
			table.addCell(cell);

			// 第18行
			cell =new PdfPCell(this.getFont(2, "最终处理结果备注"));
			cell.setColspan(2);
			table.addCell(cell);

			cell = new PdfPCell(this.getFont(6, zt003VO.getClfs()));
			cell.setColspan(8);
			table.addCell(cell);

			// 第19行
			cell =new PdfPCell(this.getFont(2, "备注"));
			cell.setColspan(2);
			table.addCell(cell);

			cell = new PdfPCell(this.getFont(6, zt003VO.getBz()));
			cell.setColspan(8);
			table.addCell(cell);

			//table.setSpacingAfter(36f);
			table.setSpacingBefore(4f);
			// table.setSpacingBefore(-10);
			table.setTotalWidth(565F);
			table.setLockedWidth(true);
			return table;
		}

		public PdfPCell setCellCenter(Paragraph para) {
			PdfPCell cell = new PdfPCell(para);
			cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cell.setFixedHeight(20);
			return cell;
		}

		/**
		 * 文档超级 排版
		 * 
		 * @param type 1-标题 2-标题一 3-标题二 4-标题三 5-正文 6-左对齐
		 */
		public Paragraph getFont(int type, String text) {
			Font font = new Font(baseFont);
			if (1 == type) {
				font.setSize(20f);
				font.setStyle(Font.BOLD);
			} else if (2 == type) {
				font.setSize(12f);
			} else if (3 == type) {
				font.setSize(10f);
			} else if (4 == type) {
				font.setSize(9f);
			} else if (5 == type) {
				font.setSize(10.5f);
			} else if (6 == type) {
				font.setSize(9f);
			} else {
				font.setSize(10.5f);
			}
			// 注： 字体必须和 文字一起new
			Paragraph paragraph = new Paragraph(text, font);
			if (1 == type) {
				paragraph.setAlignment(Paragraph.ALIGN_CENTER);// 居中
				paragraph.setSpacingBefore(5f);// 上间距
				// paragraph.setSpacingAfter(-25f);//下间距
			} else if (2 == type) {
				paragraph.setAlignment(Element.ALIGN_CENTER);
			} else if (3 == type) {
				paragraph.setAlignment(Element.ALIGN_CENTER);
				paragraph.setSpacingBefore(4f);// 上间距
			} else if (4 == type) {// 4-标题三
				paragraph.setAlignment(Element.ALIGN_LEFT);
				paragraph.setFirstLineIndent(2);// 首行缩进
			} else if (5 == type) {
				paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
				paragraph.setFirstLineIndent(24);// 首行缩进
				paragraph.setSpacingBefore(1f);// 上间距
				paragraph.setSpacingAfter(1f);// 下间距
			} else if (6 == type) {// 左对齐
				paragraph.setAlignment(Element.ALIGN_LEFT);
			}
			// paragraph.setIndentationLeft(50);//整体缩进左边
			// paragraph.setFirstLineIndent(40);//首行缩进
			return paragraph;
		}

		public String lTrim(String str) {
			if (StringUtils.isBlank(str)) {
				return "";
			}
			return str.replaceAll("^(0+)", "");
		}

		public String rTrim(String str) {
			if (StringUtils.isBlank(str)) {
				return "";
			}
			return str.replaceAll("(0+)$", "");
		}

		public String mapToString(Map<String, String> map, String searchStr) {
			String result = "";
			for (Map.Entry<String, String> it : map.entrySet()) {
				String value = it.getValue();
				if (searchStr.contains(it.getKey())) {
					value ="["+"\u221A"+"]" + value;
				} else {
					value = "[ ]" + value;
				}
				result = result + value + "          ";
			}
			return result;
		}
		//
	}

}
