package core.excel.utils;

/**
 * Created by GD on 2018/6/7.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

/**
 *
 * @Description 字符串工具类
 * @Author GD
 * @Date 2018/6/7 22:16
 * @Since 1.0V
 */

public class StringUtil {

    public static boolean isNotEmpty(String str){

        if(str == null || "".equals(str)){
            return false;
        }
        return true;
    }

    public static boolean isEmpty(String str){

        if(str == null || "".equals(str)){
            return true;
        }
        return false;
    }
}
