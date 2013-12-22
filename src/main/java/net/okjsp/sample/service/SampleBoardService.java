package net.okjsp.sample.service;

import net.okjsp.common.model.Paging;
import net.okjsp.sample.model.Sample;

import java.util.List;

/**
 * User: langerhans
 * Date: 2013. 11. 20.
 * Time: 오전 1:17
 * Description : 샘플 게시판 Service
 */
public interface SampleBoardService {

    public List<Sample> getList(int categoryId, Paging paging);

    public int getTotalCount(int categoryId);

    public Sample getOne(int id);

    public boolean create(Sample sampleBoard);

    public boolean modify(Sample sampleBoard);

    public boolean addViewCount(int id);

    public boolean remove(int id);
}
