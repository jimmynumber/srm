package com.want.srm.utils;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

public class StatementPDF extends AbstractPdfView {
	
	  protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
	          HttpServletRequest request, HttpServletResponse response) throws Exception {
	      String fileName = "对账表_" + new Date().getTime()+".pdf"; 
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType("application/pdf");
	      response.setHeader("Content-Disposition","attachment;filename=" + new String(fileName.getBytes(), "iso8859-1"));
	      PdfUtils pdfUtil = new PdfUtils();
	      pdfUtil.createStatementPDF(document, writer,model);
	  }
	  
	  
	  
	  
	  
}
