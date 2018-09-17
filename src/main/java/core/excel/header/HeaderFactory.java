package core.excel.header;

/**
 * Created by GD on 2018/5/29.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import core.excel.annotation.Excel;
import core.excel.utils.BeanUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @Description
 * @Author GD
 * @Date 2018/5/29 21:52
 * @Since 1.0V
 */

public class HeaderFactory {

    private static HeaderFactory headerFactory;

    public static HeaderFactory newInstense() {
        if (headerFactory != null) {
            return headerFactory;
        }
        return new HeaderFactory();
    }

    public Map<Integer, ExcelHeader> getHeader(Class clazz, Row row) throws Exception {

        Map<String, ExcelHeader> headerClazzMap = getHeader(clazz);
        Map<Integer, ExcelHeader> headerMap = new HashMap<Integer, ExcelHeader>();
        // 获取excel的列
        int colNum = row.getPhysicalNumberOfCells();

        for (int i = 0; i < colNum; i++) {
            Cell cell = row.getCell(i);
            String title = BeanUtil.getCellVelue(cell);
            ExcelHeader excelHeader = headerClazzMap.get(title);
            if (excelHeader != null) {
                headerMap.put(i, excelHeader);
            }
        }
        return headerMap;
    }

    public Map<String, ExcelHeader> getHeader(Class clazz) throws Exception {

        List<Field> fields = new ArrayList<Field>();
        for (Class clz = clazz; clz != Object.class; clz = clz.getSuperclass()) {
            fields.addAll(Arrays.asList(clz.getDeclaredFields()));
        }
        // 存储title 对应的Header
        Map<String, ExcelHeader> headerClazzMap = new HashMap<String, ExcelHeader>();
        for (Field field : fields) {
            Excel annotation = field.getAnnotation(Excel.class);
            if (annotation != null) {
                String title = annotation.title();
                ExcelHeader header = new ExcelHeader(title, annotation.order(),
                        field.getName(),field.getType().getClass(),clazz,
                        annotation.readAdapter().newInstance(),
                        annotation.writeAdapter().newInstance());
                headerClazzMap.put(title, header);
                annotation.order();
            }
        }
        return headerClazzMap;
    }
}
