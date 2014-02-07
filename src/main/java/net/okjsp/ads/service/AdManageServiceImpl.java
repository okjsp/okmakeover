package net.okjsp.ads.service;

import net.okjsp.ads.dao.AdManageDao;
import net.okjsp.ads.model.AdManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 광고 관리 Service 인터페이스.
 *
 * @author jaeger
 */
@Service
public class AdManageServiceImpl implements AdManageService {

    @Autowired
    private AdManageDao adManageDao;


    @Override
    public AdManage selectAdManage(AdManage adManage) {
        return adManageDao.selectOne(adManage);
    }

    @Override
    public List<AdManage> selectAdManageList(AdManage adManage) {
        return adManageDao.selectAdManageList(adManage.getUserId(), adManage.getAdType());
    }

    @Override
    public boolean insertAdManage(AdManage adManage) {
        int insertCount = adManageDao.insertAdManage(adManage);
        return (insertCount == 0) ? false : true;
    }

    @Override
    public boolean updateAdManage(AdManage adManage) {
        int updateCount = adManageDao.updateAdManage(adManage);
        return (updateCount == 0) ? false : true;
    }

    @Override
    public boolean deleteAdManage(AdManage adManage) {
        int deleteCount = adManageDao.deleteAdManage(adManage.getAdId());
        return (deleteCount == 0) ? false : true;
    }

}
