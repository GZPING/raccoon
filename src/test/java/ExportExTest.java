/**
 * Created by GD on 2018/4/15.
 */

import core.excel.sl.AbstractExportReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @Description TODO
 * @Author GD
 * @Date 2018/4/15 22:48
 * @Version 1.0V
 */
public class ExportExTest {


    @Test
    public void ExcelTest(){
        File file = new File("F://test.xlsx");

        try {
            List<User> users = AbstractExportReader.readExcel2Object(file,User.class,1,0,0);
            System.out.println(users);
       } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
