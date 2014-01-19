package net.okjsp.recruit.service;

import java.util.List;
import net.okjsp.recruit.model.Recruit;

public interface RecruitService {

	public List<Recruit> selectList(String workRegion, String employmentType,
			String sort, String offset, int sizePerList);

	public int selectTotalCount(String workRegion, String employmentType);

	public Recruit selectOne(int writeNo);

	public int insert(Recruit recruit);

	public int update(Recruit recruit);

	public int delete(int writeNo);

	public int addViewCount(int writeNo);

}
