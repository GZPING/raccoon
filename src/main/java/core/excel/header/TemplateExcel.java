package core.excel.header;

/**
 * Created by GD on 2018/6/9.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.awt.*;
import java.util.List;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/6/9 13:05
 * @Since 1.0V
 */

public class TemplateExcel<T> {

    private HSSFWorkbook workbook;

    private HSSFSheet sheet;

    private HSSFCellStyle titleCellStyle;

    private HSSFCellStyle dataCellStyle;

    public TemplateExcel(HSSFWorkbook workbook) {
        this.workbook = workbook;
        this.sheet = setDefaultSheetStyle("sheet");
        this.titleCellStyle = setTitleCellDefaultStyle();
        this.dataCellStyle = setDataCellDefaultStyle();
    }

    /*
            excel data
         */
    private List<T> data;

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(HSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    public HSSFSheet getSheet() {
        return sheet;
    }

    public void setSheet(HSSFSheet sheet) {
        this.sheet = sheet;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    private HSSFSheet setDefaultSheetStyle(String sheetName){
        HSSFSheet sheet = workbook.createSheet(sheetName);
        return sheet;
    }

    private HSSFCellStyle setTitleCellDefaultStyle(){
        HSSFPalette palette = workbook.getCustomPalette();
        Color rgb = Color.GREEN;
        short colorIndex = 10;
        short bgIndex = colorIndex ++;
        palette.setColorAtIndex(bgIndex, (byte) rgb.getRed(), (byte) rgb.getGreen(), (byte) rgb.getBlue());
        short bdIndex = colorIndex ++;
        rgb = Color.BLACK;
        palette.setColorAtIndex(bdIndex, (byte) rgb.getRed(), (byte) rgb.getGreen(), (byte) rgb.getBlue());

        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //bdIndex 边框颜色下标值
        cellStyle.setBottomBorderColor(bdIndex);
        cellStyle.setLeftBorderColor(bdIndex);
        cellStyle.setRightBorderColor(bdIndex);
        cellStyle.setTopBorderColor(bdIndex);

        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return cellStyle;
    }

    private HSSFCellStyle setDataCellDefaultStyle(){
        HSSFPalette palette = workbook.getCustomPalette();
        Color rgb = Color.GREEN;
        short colorIndex = 10;
        short bgIndex = colorIndex ++;
        palette.setColorAtIndex(bgIndex, (byte) rgb.getRed(), (byte) rgb.getGreen(), (byte) rgb.getBlue());
        short bdIndex = colorIndex ++;
        rgb = Color.BLACK;
        palette.setColorAtIndex(bdIndex, (byte) rgb.getRed(), (byte) rgb.getGreen(), (byte) rgb.getBlue());

        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //bdIndex 边框颜色下标值
        cellStyle.setBottomBorderColor(bdIndex);
        cellStyle.setLeftBorderColor(bdIndex);
        cellStyle.setRightBorderColor(bdIndex);
        cellStyle.setTopBorderColor(bdIndex);

        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return cellStyle;
    }
}
