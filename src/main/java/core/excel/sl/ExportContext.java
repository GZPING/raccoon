package core.excel.sl;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.Map;

/**
 * Created by GD on 2018/4/15.
 */
public interface ExportContext {

    Object readExcel2Object(File file, Class<T> clazz, int beginLine, int endLine, int sheetIndex) throws  Exception;

    Object readExcel2Object(Workbook workbook, Class<T> clazz, int beginLine, int endLine, int sheetIndex)throws  Exception;


}
