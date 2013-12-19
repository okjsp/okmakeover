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
 * Description :
 */
@Service
public class SampleBoardServiceImpl implements SampleBoardService {


    @Autowired
    SampleBoardDao sampleBoardDao;

    @Override
    public List<Sample> getList(int categoryId, Paging paging) {

        List<Sample> list = sampleBoardDao.selectList(categoryId, paging.getOffset(), paging.getListSize());

        return list;
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
    public boolean edit(Sample sampleBoard) {

        boolean result = false;

        int count = sampleBoardDao.update(sampleBoard);

        if(count > 0) {
            result = true;
        }

        return result;
    }

    @Override
    public boolean remove(int id) {

        boolean result = false;

        int count = sampleBoardDao.delete(id);

        if(count > 0) {
            result = true;
        }

        return result;
    }
}
