package cn.chendahai.html2pdf;/**
 * @author lql
 * @date 2020/9/18 0018 上午 11:25
 * Description：
 */

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/9/18 0018
 */
public class JavaToPdfHtml {

    private static final String DEST = "target/HelloWorld_CN_HTML.pdf";
    private static final String HTML = "src/main/resources/" + "/static/hello.html";
    private static final String FONT = "simhei.ttf";


    public static void main(String[] args) throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
        // step 3
        document.open();
        // step 4
        XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
//        fontImp.register(FONT);
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
            new FileInputStream(HTML), null, Charset.forName("UTF-8"), fontImp);
        // step 5

        addImage(document);
        document.close();
    }

    private static void addImage(Document document) throws IOException, DocumentException {
        Image image = Image
            .getInstance("https://img-blog.csdn.net/20180801174617455?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNzg0ODcxMA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70");
        image.setAlignment(Image.ALIGN_CENTER);
        image.scalePercent(40); //依照比例缩放
        document.add(image);
    }
}
