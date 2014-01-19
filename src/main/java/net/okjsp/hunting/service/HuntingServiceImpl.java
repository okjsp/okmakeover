package net.okjsp.hunting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.okjsp.hunting.dao.HuntingDao;
import net.okjsp.hunting.model.Hunting;

@Service
public class HuntingServiceImpl implements HuntingService {

	@Autowired
	private HuntingDao huntingDao;

	@Override
	public List<Hunting> selectList(String workRegion, String employmentType,
			String sort, String offset, int sizePerList) {
		return huntingDao.selectList(workRegion, employmentType, sort, offset, sizePerList);
	}

	@Override
	public int selectTotalCount(String workRegion, String employmentType) {
		return huntingDao.selectTotalCount(workRegion, employmentType);
	}

	@Override
	public Hunting selectOne(int writeNo) {
		return huntingDao.selectOne(writeNo);
	}

	@Override
	public int insert(Hunting hunting) {
		return huntingDao.insert(hunting);
	}

	@Override
	public int update(Hunting hunting) {
		return huntingDao.update(hunting);
	}

	@Override
	public int delete(int writeNo) {
		return huntingDao.delete(writeNo);
	}

	@Override
	public int addViewCount(int writeNo) {
		return huntingDao.addViewCount(writeNo);
	}

}
