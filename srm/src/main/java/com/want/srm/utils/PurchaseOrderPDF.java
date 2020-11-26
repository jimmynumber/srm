package com.want.srm.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.RectangleReadOnly;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import com.want.srm.webservice.zrfcqqt006.OTHEADType;
import com.want.srm.webservice.zrfcqqt006.OTITEMType;

public class PurchaseOrderPDF extends AbstractPdfView {

	private static BaseFont baseFont = null;
	public static PdfTemplate tpl;

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String fileName = model.get("EBELN") + "PFC.pdf";
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(fileName.getBytes(), "iso8859-1"));
		PurchaseOrderPDFUtils pdfUtil = new PurchaseOrderPDFUtils();
		pdfUtil.createPurchaseOrderPDF(document, writer, model);
	}

	public static class PurchaseOrderPDFUtils {

		static {
			try {
				baseFont = BaseFont.createFont("static/SourceHanSerifSC-Regular.otf", BaseFont.IDENTITY_H,
						BaseFont.NOT_EMBEDDED);
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@SuppressWarnings("unchecked")
		public void createPurchaseOrderPDF(Document document, PdfWriter writer, Map<String, Object> model)
				throws Exception {
			document.setPageSize(new RectangleReadOnly(595F, 842F));
			document.setMargins(20, 20, 45, 15);
			try {
				List<OTHEADType> otHEAD = (List<OTHEADType>) model.get("otHEAD");
				OTHEADType HEAD = otHEAD.get(0);
				PdfExport pe = new PdfExport();
				pe.setEBELN(HEAD.getEBELN());
				writer.setPageEvent(pe);
				document.open();

				String filePath = this.getClass().getResource("/").getPath() + "static/logo.png";
				if ("\\".equals(File.separator)) {
					filePath = filePath.replace("/", "\\");
				} else {
					filePath = filePath.replaceAll("\\\\", "/");
				}
				Image image = Image.getInstance(filePath);
				image.scaleToFit(40, 40);
				image.setAbsolutePosition(66, 750);
				PdfContentByte cb = writer.getDirectContentUnder();
				cb.addImage(image);
				document.add(this.getFont(1, zy1(HEAD.getBUTXT())));
				document.add(this.getFont(1, zy1(HEAD.getBATXT())));
				document.add(this.getFont(2, "TO　    ：" + zy1(HEAD.getNAME1())));
				document.add(this.getFont(2, "ATTN  ：" + zy1(HEAD.getUATTN())));
				document.add(this.getFont(2, "FAX     ：" + zy1(HEAD.getTELFX())));
				document.add(this.getFont(2, "FROM ：" + zy1(HEAD.getNAME2())));
				document.add(this.getFont(2, "DATE  ：" + zy(HEAD.getBEDAT())));
				document.add(this.getFont(2, "现我司以与贵司确认之价格向贵司订购，具体情况如下："));
				document.add(this.createTable(writer, (List<OTITEMType>) model.get("otITEM")));
				document.add(this.getFont(4, "交货地点：" + zy1(HEAD.getSTREET())));
				document.add(this.createTable2(writer, HEAD));
				document.add(this.getFont(2, "1、质量要求：按照旺旺公司验收标准执行。"));
				document.add(this.getFont(2, "2、上述货物实际交货、到货时间以工厂采购通知为准。"));
				document.add(this.getFont(2, "3、所供产品生产日期与到货日期的时间差不能超过保质期的1/3。"));

				if (HEAD.getZ009() != null && !"".equals(HEAD.getZ009().trim())) {
					document.add(
							this.getFont(2, "4、1）每逾期1日，我司将按照贵司未到货款总额的0.3%向贵司收取违约金，逾期2日按照未到货款总额的0.6%向贵司收取违约金，以此类推；"));
					document.add(this.getFont(2,
							"2）如逾期超过5日，我司有权取消贵司承做的该笔订单及后续其他订单。我司按未到货货款总额的10%向贵司收取违约金，同时我司可直接向其他第三方采购，贵司无条件承担包括我司转包第三方形成差价在内的一切损失；"));
					document.add(this.getFont(2,
							"3）如逾期超过10日，我司有权取消贵司承做的该笔订单及后续其他订单。我司按未到货货款总额的20%向贵司收取违约金，同时我司可直接向其他第三方采购，贵司无条件承担包括我司转包第三方形成差价在内的一切损失；如以上不足以弥补我司断货损失的，贵司应继续赔偿。"));
					document.add(this.getFont(2, "5、本订单涂改无效，因本订单事项产生争议交由我司所在地法院管辖。"));

					if ("".equals(zy1(HEAD.getURFAX()))) {
						document.add(this.getFont(2,
								"6、本订单发出后请贵司于二个工作日内签名盖公章回传______________，如在二个工作日内贵司未表示异议，我司将视同贵司默认本订单所有条款。"));
					} else {
						document.add(this.getFont(2,
								"6、本订单发出后请贵司于二个工作日内签名盖公章回传 " + HEAD.getURFAX() + "，如在二个工作日内贵司未表示异议，我司将视同贵司默认本订单所有条款。"));
					}

					document.add(this.getFont(2, "7、本订单传真有效。"));
					document.add(this.getFont(2, "8、其他（原 _____________订单作废）。"));
				} else {
					document.add(this.getFont(2, "4、汽运到交货地点允许±1天误差，火车、船运允许±3天误差。"));
					document.add(this.getFont(2,
							"5、如贵司逾期交货，则每逾期1日，贵司应按未按时到货货款之0.1%支付违约金给我司。逾期 超过10日，我司有权取消该笔订单，按贵司未到货货款之5%向贵司收取违约金或不征求贵司意 见，直接向第三方采购，贵司应赔偿我司损失及二者差价。如以上不足以弥补我司断货损失的， 贵司应继续赔偿。"));
					document.add(this.getFont(2, "6、本订单涂改无效，因本订单事项产生争议交由我司所在地法院管辖。"));

					if ("".equals(zy1(HEAD.getURFAX()))) {
						document.add(this.getFont(2,
								"7、本订单发出后请贵司于二个工作日内签名盖公章回传 ______________，如在二个工作日内 贵司未表示异议，我司将视同贵司默认本订单所有条款。"));
					} else {
						document.add(this.getFont(2, "7、本订单发出后请贵司于二个工作日内签名盖公章回传  " + HEAD.getURFAX()
								+ "，如在二个工作日内 贵司未表示异议，我司将视同贵司默认本订单所有条款。"));
					}

					document.add(this.getFont(2, "8、本订单传真有效。"));
					document.add(this.getFont(2, "9、其他（原 _____________订单作废）。"));
				}

				document.add(this.getFont(5, "公  章_________   签  名（日 期）_________________"));
				document.add(this.getFont(3,
						"-------------------------------------------------------以下为我方工厂填写-------------------------------------------------------"));
				document.add(this.getFont(2, "工厂请购单号：" + zy1(HEAD.getBANFN())));
				document.add(this.getFont(7, "收本订单时,采购主管确认签回:_________________"));
				document.add(this.createTable3(writer, HEAD));
			} catch (DocumentException e) {
				e.printStackTrace();
			} finally {
				document.close();
			}
		}

		public PdfPTable createTable(PdfWriter write, List<OTITEMType> otITEM) throws DocumentException, IOException {
			PdfPTable table = new PdfPTable(6);// 生成表格
			float[] columnWidths = { 90, 90, 90, 90, 90, 90 };
			table.setWidths(columnWidths);
			table.addCell(setCellCenter(this.getFont(3, "料号")));
			table.addCell(setCellCenter(this.getFont(3, "品名")));
			table.addCell(setCellCenter(this.getFont(3, "规格/质量标准")));
			table.addCell(setCellCenter(this.getFont(3, "数量 ")));
			table.addCell(setCellCenter(this.getFont(3, "价格")));
			table.addCell(setCellCenter(this.getFont(3, "到货日期")));

			if (otITEM != null && otITEM.size() > 0) {
				for (int i = 0; i < otITEM.size(); i++) {
					table.addCell(setCell(this.getFont(4, zy1(otITEM.get(i).getMATNR()))));
					table.addCell(setCell(
							this.getFont(4, zy1(otITEM.get(i).getTXZ01()) + "\r\n" + zy1(otITEM.get(i).getOITXT()))));
					table.addCell(setCell(
							this.getFont(4, zy1(otITEM.get(i).getLTEX1()) + "\r\n" + zy1(otITEM.get(i).getLTEX2()))));
					table.addCell(setCell(this.getFont(4, zy1(otITEM.get(i).getMENGE()))));
					table.addCell(setCell(this.getFont(4, zy1(otITEM.get(i).getNETPR()))));
					table.addCell(setCell(this.getFont(4, zy(otITEM.get(i).getEINDT()))));
				}
			}

			table.setSpacingBefore(4f);
			table.setTotalWidth(556F);
			table.setLockedWidth(true);
			return table;
		}

		public PdfPTable createTable2(PdfWriter write, OTHEADType HEAD) throws DocumentException, IOException {
			PdfPTable table = new PdfPTable(2);// 生成表格
			float[] columnWidths = { 270, 270 };
			table.setWidths(columnWidths);
			table.addCell(setCellBorder(this.getFont(4, "付款条件：" + zy1(HEAD.getVTEXT()))));
			table.addCell(setCellBorder(this.getFont(4, "税率：" + zy1(HEAD.getTEXT1()))));
			table.addCell(setCellBorder(this.getFont(4, "运输方式：" + zy1(HEAD.getEVTXT()))));
			table.addCell(setCellBorder(this.getFont(4, "价格含税、含送货到交货地点运费，不含卸货费用")));
			table.addCell(setCellBorder(this.getFont(4, "到货后联系人：" + zy1(HEAD.getZQNAM()))));
			table.addCell(setCellBorder(this.getFont(4, "电话：" + zy1(HEAD.getZQTEL()))));
			PdfPCell cell = setCellBorder(this.getFont(4, "其他要求：" + zy1(HEAD.getOTTXT())));
			cell.setColspan(2);
			table.addCell(cell);

			table.setSpacingBefore(14f);
			table.setTotalWidth(556F);
			table.setLockedWidth(true);
			return table;
		}

		public PdfPTable createTable3(PdfWriter write, OTHEADType HEAD) throws DocumentException, IOException {
			PdfPTable table = new PdfPTable(3);// 生成表格
			float[] columnWidths = { 180, 180, 180 };
			table.setWidths(columnWidths);
			table.addCell(setCellBorder(this.getFont(4, "最高主管：" + zy1(HEAD.getZNAME3()))));
			table.addCell(setCellBorder(this.getFont(4, "主管：" + zy1(HEAD.getZNAME2()))));
			table.addCell(setCellBorder(this.getFont(4, "经办：" + zy1(HEAD.getUNAME()))));

			table.setSpacingBefore(4f);
			table.setTotalWidth(556F);
			table.setLockedWidth(true);
			return table;
		}

		public static String zy(XMLGregorianCalendar str) {
			if (str != null && !"0000-00-00".equals(str.toString())) {
				return str.toString();
			} else {
				return "";
			}
		}

		public static String zy1(String str) {
			if (str != null) {
				return str.toString();
			} else {
				return "";
			}
		}

		public static PdfPCell setCellBorder(Paragraph para) {
			PdfPCell cell = new PdfPCell(para);
			cell.setFixedHeight(24);
			cell.setBorderWidth(0);
			return cell;
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

		public Paragraph getFont(int type, String text) {
			Font font = new Font(baseFont);
			if (1 == type) {
				font.setSize(14f);
				font.setStyle(Font.BOLD);
			} else if (8 == type) {
				font.setSize(10f);
			} else {
				font.setSize(12f);
			}
			// 注： 字体必须和 文字一起new
			Paragraph paragraph = new Paragraph(text, font);
			if (1 == type) {
				paragraph.setAlignment(Paragraph.ALIGN_CENTER);// 居中
				paragraph.setSpacingBefore(2f);// 上间距
				paragraph.setSpacingAfter(2f);// 下间距
			} else if (2 == type) {
				paragraph.setSpacingBefore(2f);// 上间距
				paragraph.setAlignment(Element.ALIGN_LEFT);
			} else if (3 == type) {
				paragraph.setAlignment(Element.ALIGN_CENTER);
			} else if (4 == type) {// 4-标题三
				paragraph.setAlignment(Element.ALIGN_LEFT);
			} else if (5 == type) {
				paragraph.setFirstLineIndent(260);// 首行缩进
				paragraph.setSpacingBefore(2f);// 上间距
				paragraph.setSpacingAfter(2f);// 下间距
			} else if (6 == type) {// 左对齐
				paragraph.setAlignment(Element.ALIGN_LEFT);
			} else if (7 == type) {
				paragraph.setFirstLineIndent(24);// 首行缩进
				paragraph.setSpacingBefore(2f);// 上间距
				paragraph.setSpacingAfter(2f);// 下间距
			} else if (8 == type) {
				paragraph.setSpacingBefore(2f);// 上间距
			}
			return paragraph;
		}
	}

}
