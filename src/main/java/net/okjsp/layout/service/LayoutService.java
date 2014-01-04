package net.okjsp.layout.service;

import net.okjsp.layout.model.Navigation;

import java.util.List;

/**
 * User: langerhans
 * Date: 2013. 12. 22.
 * Time: 오후 2:44
 * Description : 화면 공통 레이아웃을 위한 Service
 */
public interface LayoutService {

    public List<Navigation> getNav();
    public void flushNav();
}
