package core.excel.annotation;

/**
 * Created by GD on 2018/5/23.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import core.excel.converter.impl.DefultConverter;
import core.excel.converter.ReadConverter;
import core.excel.converter.WriteConverter;

import java.lang.annotation.*;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/5/23 22:03
 * @Since 1.0V
 */

@Target({ElementType.METHOD,ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Excel {
    /*
    对应的title 名称
     */
    String title();

    int order() default 999;

    Class<? extends ReadConverter> readAdapter() default DefultConverter.class ;

    Class<? extends WriteConverter> writeAdapter() default DefultConverter.class ;


}
