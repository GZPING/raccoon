package core.excel.header;

/**
 * Created by GD on 2018/5/23.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import core.excel.converter.ReadConverter;
import core.excel.converter.WriteConverter;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/5/23 22:02
 * @Since 1.0V
 */

public class ExcelHeader implements Comparable<ExcelHeader> {

    public ExcelHeader(){};
    public ExcelHeader(String title) {
        super();
        this.title = title;
    }

    public ExcelHeader(String title, int order, String field, Class clazzObject, Class clazzField, ReadConverter readAdapter, WriteConverter writeConverter) {
        this.title = title;
        this.order = order;
        this.field = field;
        this.clazzObject = clazzObject;
        this.clazzField = clazzField;
        this.readAdapter = readAdapter;
        this.writeConverter = writeConverter;
    }

    public ExcelHeader(String title, int order, ReadConverter readAdapter, WriteConverter writeConverter) {
        this.title = title;
        this.order = order;
        this.readAdapter = readAdapter;
        this.writeConverter = writeConverter;
    }

    /**
     * excel title

     */
    private String title;

    private int order;

    private String field;

    private Class clazzObject;

    private Class clazzField;

    private ReadConverter readAdapter;

    private WriteConverter writeConverter;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Class getClazzObject() {
        return clazzObject;
    }

    public void setClazzObject(Class clazzObject) {
        this.clazzObject = clazzObject;
    }

    public Class getClazzField() {
        return clazzField;
    }

    public void setClazzField(Class clazzField) {
        this.clazzField = clazzField;
    }

    public int compareTo(ExcelHeader o) {
        return order - o.getOrder();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public ReadConverter getReadAdapter() {
        return readAdapter;
    }

    public void setReadAdapter(ReadConverter readAdapter) {
        this.readAdapter = readAdapter;
    }

    public WriteConverter getWriteConverter() {
        return writeConverter;
    }

    public void setWriteConverter(WriteConverter writeConverter) {
        this.writeConverter = writeConverter;
    }

}
