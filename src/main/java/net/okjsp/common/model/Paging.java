package net.okjsp.common.model;

import java.util.Map;

/**
 * User: langerhans
 * Date: 2013. 11. 20.
 * Time: 오전 1:18
 * Description :
 */
public class Paging {
    int page = 1;
    int listSize = 10;
    int offset;
    Map<String, Object> params;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }

    public int getOffset() {

        offset = (page-1) * listSize;

        return offset;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
