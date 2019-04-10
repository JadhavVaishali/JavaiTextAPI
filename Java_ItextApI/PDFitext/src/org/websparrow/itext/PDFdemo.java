package org.websparrow.itext;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFdemo {

	public static void main(String[] args) {
		try {
			// creation of the document with a certain size and certain margins
			Document document = new Document(PageSize.A4, 20, 20, 20, 20);
			//document.addTitle("Employee Table");
			
			

			// creating table and set the column width
			PdfPTable table = new PdfPTable(4);
			float widths[] = { 3, 6, 3, 3};
			table.setWidths(widths);
			table.setHeaderRows(1);
			
			

			// add cell of table - header cell
			PdfPCell cell = new PdfPCell(new Phrase("Emp Id"));
			cell.setBackgroundColor(new BaseColor(0, 173, 239));
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Emp Name"));
			cell.setBackgroundColor(new BaseColor(0, 173, 239));
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Salary"));
			cell.setBackgroundColor(new BaseColor(0, 173, 239));
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase("Country"));
			cell.setBackgroundColor(new BaseColor(0, 173, 239));
			table.addCell(cell);

			Phrase ph;
			// looping the table cell for adding definition
			for (int ctr = 1; ctr <= 4; ctr++) {

				cell = new PdfPCell();
				ph = new Phrase("101" + ctr);
				cell.addElement(ph);
				table.addCell(cell);

				cell = new PdfPCell();
				ph = new Phrase("Vaishali Jadhav " + ctr);
				cell.addElement(ph);
				table.addCell(cell);

				cell = new PdfPCell();
				ph = new Phrase("100000" + ctr);
				cell.addElement(ph);
				table.addCell(cell);
				
				cell = new PdfPCell();
				ph = new Phrase("India" + ctr);
				cell.addElement(ph);
				table.addCell(cell);
			}

			// write the all into a file and save it.
			PdfWriter.getInstance(document, new FileOutputStream("d:/MyFirstitext.pdf"));
			document.open();
			//document.add(new Paragraph("Employee table"));
			
			document.add(table);
			
			document.close();
			System.out.println(" PDF created Successfull");
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
