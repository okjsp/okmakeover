package net.okjsp.sample.service;

import net.okjsp.common.model.Paging;
import net.okjsp.sample.dao.SampleBoardDao;
import net.okjsp.sample.model.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: langerhans
 * Date: 2013. 11. 20.
 * Time: 오전 1:23
 * Description : 샘플 게시판 Service
 */  
@Service
public class SampleBoardServiceImpl implements SampleBoardService {


    @Autowired
    SampleBoardDao sampleBoardDao;

    @Override
    public List<Sample> getList(int categoryId, Paging paging) {

        List<Sample> list = sampleBoardDao.selectList(categoryId, paging.getOffset(), paging.getSizePerList());

        return list;
    }

    @Override
    public int getTotalCount(int categoryId) {

        int count = sampleBoardDao.selectTotalCount(categoryId);

        return count;
    }

    @Override
    public Sample getOne(int id) {

        Sample sampleBoard = sampleBoardDao.selectOne(id);

        return sampleBoard;
    }

    @Override
    public boolean create(Sample sampleBoard) {

        boolean result = false;

        int count = sampleBoardDao.insert(sampleBoard);

        if(count > 0) {
            result = true;
        }

        return result;
    }

    @Override
    public boolean modify(Sample sampleBoard) {

        boolean result = false;

        int count = sampleBoardDao.update(sampleBoard);

        if(count > 0) {
            result = true;
        }

        return result;
    }

    @Override
    public boolean addViewCount(int id) {

        int count = sampleBoardDao.addViewCount(id);

        return false;
    }

    @Override
    public boolean destroy(int id) {

        boolean result = false;

        int count = sampleBoardDao.delete(id);

        if(count > 0) {
            result = true;
        }

        return result;
    }
}
