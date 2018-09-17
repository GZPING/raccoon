package core.excel.converter.impl;
/**
 * Created by GD on 2018/5/29.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import core.excel.converter.ReadConverter;
import core.excel.converter.WriteConverter;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/5/29 21:42
 * @Since 1.0V
 */
public class DefultConverter implements ReadConverter,WriteConverter {

    public Object excelRead(Object object) {
        return object;
    }

    public Object excelWrite(Object object) {
        return object;
    }
}
