package net.okjsp.common.model;

import java.util.List;

/**
 * User: langerhans
 * Date: 2013. 12. 22.
 * Time: 오후 5:37
 * Description : Paging List Model
 */
public class PagingList {
    private Paging paging;
    private List<?> list;

    public PagingList(Paging paging, List<?> list) {
        this.list = list;
        this.paging = paging;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
