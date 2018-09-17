package core.excel.converter;
/**
 * Created by GD on 2018/5/24.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

/**
 *
 * @Description 将对象按照特定特使写入excel 表格中
 * @Author GD
 * @Date 2018/5/24 22:49
 * @Since 1.0V
 */
public interface WriteConverter {

    Object excelWrite(Object object);
}
