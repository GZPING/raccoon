package core.excel.sl;

/**
 * Created by GD on 2018/5/23.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import core.excel.header.ExcelHeader;
import core.excel.header.HeaderFactory;
import core.excel.header.TemplateExcel;
import core.excel.utils.BeanUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author GD
 * @Date 2018/5/23 21:20
 * @Since 1.0V
 */

public abstract class AbstractExportReader {

    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    public static <T> List<T> readExcel2Object(File file, Class<T> clazz, int beginLine,
                                               int titleRow, int sheetIndex) throws Exception {
        if (!file.exists() || file.length() == 0) {
            return null;
        }
        String fileName = file.getName();
        Workbook workbook;

        if (fileName.endsWith(EXCEL_XLSX)) {
            workbook = new XSSFWorkbook(new FileInputStream(file));
            //兼容老版本的excel 表格
        } else if (fileName.endsWith(EXCEL_XLS)) {
            workbook = new HSSFWorkbook(new FileInputStream(file));
        } else {
            return null;
        }
        return readExcel2Object(workbook, clazz, beginLine, titleRow, sheetIndex);
    }

    /**
     * 1. 读取表头数据存在Map 中
     * 2. 读取每一行数据，将每一行数据实例化到相应对象
     * 3. 给每一个实例化的数据赋值，将元素的值从excel 表格中的每一列读取出来
     * 4. 将数据封装在List 中返回
     *
     * @date: 2018/6/4 22:08
     * @author:GD
     */
    public static <T> List<T> readExcel2Object(Workbook workbook, Class<T> clazz, int beginLine,
                                               int titleRowIndex, int sheetIndex) throws Exception {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row titleRow = sheet.getRow(titleRowIndex);
        //获取表头对应的列
        Map<Integer, ExcelHeader> headerMap = HeaderFactory.newInstense().getHeader(clazz, titleRow);
        //存储读取信息，返回
        List<T> objects = new LinkedList<T>();
        int rowCountNum = sheet.getLastRowNum();
        //遍历每一行数据
        for (int i = beginLine; i < rowCountNum; i++) {
            T object = clazz.newInstance();
            Row rowDate = sheet.getRow(i);
            int cellCountNum = rowDate.getPhysicalNumberOfCells();
            for (int j = 0; j < cellCountNum; j++) {
                // 将数据转换
                ExcelHeader header = headerMap.get(j);
                String value = null;
                if (header != null) {
                    Cell cell = rowDate.getCell(j);
                    value = BeanUtil.getCellVelue(cell);
                    BeanUtils.copyProperty(object, header.getField(), value);
                }
            }
            objects.add(object);
        }
        return null;
    }

    public static <T> Workbook writeObject2Excel(TemplateExcel<T> tTemplateExcel,
                                                 Class<T> clazz) throws Exception {
        HSSFWorkbook workbook = tTemplateExcel.getWorkbook();
        HSSFSheet sheet = tTemplateExcel.getSheet();
        List<T> data = tTemplateExcel.getData();
        Map<String, ExcelHeader> headerMap = HeaderFactory.newInstense().getHeader(clazz);
        for (T rowData : data) {

        }
        return workbook;

    }

}
