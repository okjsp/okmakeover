package net.okjsp.layout.service;

import net.okjsp.layout.model.Navigation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: langerhans
 * Date: 2013. 12. 22.
 * Time: 오후 2:46
 * Description : 화면 공통 레이아웃을 위한 Service
 */
@Service
public class LayoutServiceImpl implements LayoutService {

    Logger logger = Logger.getLogger(this.getClass());

    private static List<Navigation> navList;

    /**
     * Getting Global Navigation
     * @return
     */
    @Override
    public List<Navigation> getNav() {

        if(navList == null) {

            navList = new ArrayList<Navigation>();

            navList.add(new Navigation("Community", "/community"));
            navList.add(new Navigation("Tech Q&A", "/qna"));
            navList.add(new Navigation("Job", "/job"));

            logger.debug("Initialize Global Navigation");
        }

        return navList;
    }

    @Override
    public void flushNav() {
        navList = null;
    }

    // TODO 이곳에 광고 배너 서비스 추가
}
