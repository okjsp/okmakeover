package net.okjsp.common.model;

import java.util.Map;

/**
 * User: langerhans
 * Date: 2013. 11. 20.
 * Time: 오전 1:18
 * Description : Paging Parameter Model
 */
public class Paging {
    int page = 1;
    int sizePerList = 20;
    int offset;
    int listCount = 0;
    int totalCount = 0;
    Map<String, Object> params;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSizePerList() {
        return sizePerList;
    }

    public void setSizePerList(int sizePerList) {
        this.sizePerList = sizePerList;
    }

    public int getOffset() {

        offset = (page-1) * sizePerList;

        return offset;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getListCount() {
        return listCount;
    }

    public void setListCount(int listCount) {
        this.listCount = listCount;
    }

    public int getLastIndex() {
        if(totalCount == 0) {
            return 0;
        }

        int lastIndex = listCount+getOffset();

        return lastIndex;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
