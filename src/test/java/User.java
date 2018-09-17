/**
 * Created by GD on 2018/6/4.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import core.excel.annotation.Excel;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/6/4 21:35
 * @Since 1.0V
 */

public class User {

    @Excel(title = "Name")
    private String name;
    @Excel(title = "Sex")
    private String sex;
    @Excel(title = "Age")
    private Integer age;
    @Excel(title = "Phone")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
