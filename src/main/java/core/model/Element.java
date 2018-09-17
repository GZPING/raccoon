package core.model;/**
 * Created by GD on 2018/4/15.
 */



import java.util.List;

/**
 * @Description TODO
 * @Author GD
 * @Date 2018/4/15 22:13
 * @Version 1.0V
 */
public class Element<E> {

    private Integer col;

    private Integer row;

    private String sheelName;

    /*
         *  excel title list
         */
    private List<String> titleList;

    /*
     * data list
     */
    private List<E> dataList;

    public Element() {
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public List<String> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<String> titleList) {
        this.titleList = titleList;
    }

    public List<E> getDataList() {
        return dataList;
    }

    public void setDataList(List<E> dataList) {
        this.dataList = dataList;
    }

    public String getSheelName() {
        return sheelName;
    }

    public void setSheelName(String sheelName) {
        this.sheelName = sheelName;
    }
}
