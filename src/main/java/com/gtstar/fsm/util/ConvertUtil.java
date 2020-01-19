package com.gtstar.fsm.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

/**
 * @ClassName ConvertUtil
 * @Description TODO
 * @Author yuxiang
 * @Date 2020/1/2 14:49
 **/
public class ConvertUtil {

    private static final String FONT = "C:\\Users\\gtstar\\Desktop\\1.txt";
    public static void text2pdf(String text, String pdf) throws DocumentException, IOException {
        Document document = new Document();
        OutputStream os = new FileOutputStream(new File(pdf));
        PdfWriter.getInstance(document, os);
        document.open();
        //方法一：使用Windows系统字体(TrueType)
        BaseFont baseFont = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font font = new Font(baseFont);
        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(text)), "GBK");
        BufferedReader bufferedReader = new BufferedReader(isr);
        String str = "";
        while ((str = bufferedReader.readLine()) != null) {
            document.add(new Paragraph(str, font));
        }
        document.close();
    }
    public static void main(String[] args) throws Exception {
        String PDFTIMEDIR = "F:/pdf/";
        String text = PDFTIMEDIR + "1.txt";
        String pdf = PDFTIMEDIR + "1.txt.pdf";

        text2pdf(text, "C:\\Users\\gtstar\\Desktop\\1.pdf");
    }

}
