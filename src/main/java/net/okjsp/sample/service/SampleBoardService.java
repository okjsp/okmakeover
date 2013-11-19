package net.okjsp.sample.service;

import net.okjsp.common.model.Paging;
import net.okjsp.sample.model.SampleBoard;

import java.util.List;

/**
 * User: langerhans
 * Date: 2013. 11. 20.
 * Time: 오전 1:17
 * Description :
 */
public interface SampleBoardService {

    public List<SampleBoard> getList(int categoryId, Paging paging);

    public SampleBoard getOne(int id);

    public boolean create(SampleBoard sampleBoard);

    public boolean edit(SampleBoard sampleBoard);

    public boolean remove(int id);
}
