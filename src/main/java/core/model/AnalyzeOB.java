package core.model;/**
 * Created by GD on 2018/4/18.
 */

import java.util.List;

/**
 * @Description TODO
 * @Author GD
 * @Date 2018/4/18 20:19
 * @Version 1.0V
 */
public class AnalyzeOB {

    private List titles;

    private List fieldsMothedName;

    public AnalyzeOB() {
    }

    public AnalyzeOB(List titles, List dataFields) {
        this.titles = titles;
        this.fieldsMothedName = dataFields;
    }

    public List getTitles() {
        return titles;
    }

    public void setTitles(List titles) {
        this.titles = titles;
    }

    public List getFieldsMothedName() {
        return fieldsMothedName;
    }

    public void setFieldsMothedName(List fieldsMothedName) {
        this.fieldsMothedName = fieldsMothedName;
    }
}
