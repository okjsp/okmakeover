package net.okjsp.sample.service;

import net.okjsp.common.model.Paging;
import net.okjsp.sample.model.Sample;

import java.util.List;

/**
 * User: langerhans
 * Date: 2013. 11. 20.
 * Time: 오전 1:17
 * Description :
 */
public interface SampleBoardService {

    public List<Sample> getList(int categoryId, Paging paging);

    public Sample getOne(int id);

    public boolean create(Sample sampleBoard);

    public boolean edit(Sample sampleBoard);

    public boolean remove(int id);
}
