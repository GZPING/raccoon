package core.excel.utils;

/**
 * Created by GD on 2018/5/24.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import core.excel.annotation.Excel;
import org.apache.poi.ss.usermodel.*;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author GD
 * @Date 2018/5/24 23:08
 * @Since 1.0V
 */

public class BeanUtil {

    public static String getCellVelue(Cell cell) {
        int cellType = cell.getCellType();
        String cellValue = "";
        switch (cellType) {
            case Cell.CELL_TYPE_STRING:     // 文本
                cellValue = cell.getRichStringCellValue().getString() ;
                break;
            case Cell.CELL_TYPE_NUMERIC:    // 数字、日期
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    cellValue = cell.getDateCellValue().toString() ;
                } else {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cellValue = String.valueOf(cell.getRichStringCellValue().getString());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:    // 布尔型
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_BLANK: // 空白
                cellValue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_ERROR: // 错误
                cellValue = "";
                break;
            case Cell.CELL_TYPE_FORMULA:    // 公式
                // 得到对应单元格的公式
                //cellValue = cell.getCellFormula() + "#";
                // 得到对应单元格的字符串
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cellValue = String.valueOf(cell.getRichStringCellValue().getString()) + "#";
                break;
            default:
                cellValue = "";
        }
        //字符串修剪  去除所有空白符号 ， 问号 ， 中文空格
        return cellValue.replaceAll("[\\s\\?]", "").replace("　", "");
    }

    public static Byte parseByte(String value) {
        try {
            value = value.trim();
            return Byte.valueOf(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("parseByte but input illegal input=" + value, e);
        }
    }

    public static Boolean parseBoolean(String value) {
        value = value.trim();
        if (Boolean.TRUE.toString().equalsIgnoreCase(value)) {
            return Boolean.TRUE;
        } else if (Boolean.FALSE.toString().equalsIgnoreCase(value)) {
            return Boolean.FALSE;
        } else {
            throw new RuntimeException("parseBoolean but input illegal input=" + value);
        }
    }

    public static Integer parseInt(String value) {
        try {
            value = value.trim();
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("parseInt but input illegal input=" + value, e);
        }
    }

    public static Short parseShort(String value) {
        try {
            value = value.trim();
            return Short.valueOf(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("parseShort but input illegal input=" + value, e);
        }
    }

    public static Long parseLong(String value) {
        try {
            value = value.trim();
            return Long.valueOf(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("parseLong but input illegal input=" + value, e);
        }
    }

    public static Float parseFloat(String value) {
        try {
            value = value.trim();
            return Float.valueOf(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("parseFloat but input illegal input=" + value, e);
        }
    }

    public static Double parseDouble(String value) {
        try {
            value = value.trim();
            return Double.valueOf(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("parseDouble but input illegal input=" + value, e);
        }
    }

    public static Date parseDate(String value, Excel excelField) {
        try {
            String datePattern = "yyyy-MM-dd HH:mm:ss";
            if (excelField != null) {
                //  datePattern = excelField.dateformat();
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
            return dateFormat.parse(value);
        } catch (ParseException e) {
            throw new RuntimeException("parseDate but input illegal input=" + value, e);
        }
    }

    /**
     * 参数解析 （支持：Byte、Boolean、String、Short、Integer、Long、Float、Double、Date）
     *
     * @param field
     * @param value
     * @return
     */
    public static Object parseValue(Field field, String value) {
        Class<?> fieldType = field.getType();

        Excel excelField = field.getAnnotation(Excel.class);
        if (value == null || value.trim().length() == 0)
            return null;
        value = value.trim();

		/*if (Byte.class.equals(fieldType) || Byte.TYPE.equals(fieldType)) {
            return parseByte(value);
		} else */
        if (Boolean.class.equals(fieldType) || Boolean.TYPE.equals(fieldType)) {
            return parseBoolean(value);
        }/* else if (Character.class.equals(fieldType) || Character.TYPE.equals(fieldType)) {
			 return value.toCharArray()[0];
		}*/ else if (String.class.equals(fieldType)) {
            return value;
        } else if (Short.class.equals(fieldType) || Short.TYPE.equals(fieldType)) {
            return parseShort(value);
        } else if (Integer.class.equals(fieldType) || Integer.TYPE.equals(fieldType)) {
            return parseInt(value);
        } else if (Long.class.equals(fieldType) || Long.TYPE.equals(fieldType)) {
            return parseLong(value);
        } else if (Float.class.equals(fieldType) || Float.TYPE.equals(fieldType)) {
            return parseFloat(value);
        } else if (Double.class.equals(fieldType) || Double.TYPE.equals(fieldType)) {
            return parseDouble(value);
        } else if (Date.class.equals(fieldType)) {
            return parseDate(value, excelField);

        } else {
            throw new RuntimeException("request illeagal type, type must be Integer not int Long not long etc, type=" + fieldType);
        }
    }

    /**
     * 参数格式化为String
     *
     * @param field
     * @param value
     * @return
     */
    public static String formatValue(Field field, Object value) {
        Class<?> fieldType = field.getType();

        Excel excelField = field.getAnnotation(Excel.class);
        if (value == null) {
            return null;
        }

        if (Boolean.class.equals(fieldType) || Boolean.TYPE.equals(fieldType)) {
            return String.valueOf(value);
        } else if (String.class.equals(fieldType)) {
            return String.valueOf(value);
        } else if (Short.class.equals(fieldType) || Short.TYPE.equals(fieldType)) {
            return String.valueOf(value);
        } else if (Integer.class.equals(fieldType) || Integer.TYPE.equals(fieldType)) {
            return String.valueOf(value);
        } else if (Long.class.equals(fieldType) || Long.TYPE.equals(fieldType)) {
            return String.valueOf(value);
        } else if (Float.class.equals(fieldType) || Float.TYPE.equals(fieldType)) {
            return String.valueOf(value);
        } else if (Double.class.equals(fieldType) || Double.TYPE.equals(fieldType)) {
            return String.valueOf(value);
        } else if (Date.class.equals(fieldType)) {
            String datePattern = "yyyy-MM-dd HH:mm:ss";
           /* if (excelField != null && excelField.dateformat()!=null) {
                datePattern = excelField.dateformat();
            }*/
            SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
            return dateFormat.format(value);
        } else {
            throw new RuntimeException("request illeagal type, type must be Integer not int Long not long etc, type=" + fieldType);
        }
    }

}
