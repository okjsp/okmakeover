package net.okjsp.hunting.service;

import java.util.List;

import net.okjsp.hunting.model.Hunting;

public interface HuntingService {

	public List<Hunting> selectList(String workRegion, String employmentType,
			String sort, String offset, int sizePerList);

	public int selectTotalCount(String workRegion, String employmentType);

	public Hunting selectOne(int writeNo);

	public int insert(Hunting hunting);

	public int update(Hunting hunting);

	public int delete(int writeNo);

	public int addViewCount(int writeNo);

}
