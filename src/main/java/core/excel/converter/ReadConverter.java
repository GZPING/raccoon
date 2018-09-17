package core.excel.converter;
/**
 * Created by GD on 2018/5/24.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

/**
 *
 * @Description 将读取的数据转换成相应的类型
 * @Author GD
 * @Date 2018/5/24 22:48
 * @Since 1.0V
 */
public interface ReadConverter {

    Object excelRead(Object object);

}
