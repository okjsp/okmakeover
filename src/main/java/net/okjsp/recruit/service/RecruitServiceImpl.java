package net.okjsp.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.okjsp.recruit.dao.RecruitDao;
import net.okjsp.recruit.model.Recruit;

@Service
public class RecruitServiceImpl implements RecruitService {

	@Autowired
	private RecruitDao recruitDao;

	@Override
	public List<Recruit> selectList(String workRegion, String employmentType,
			String sort, String offset, int sizePerList) {
		return recruitDao.selectList(workRegion, employmentType, sort, offset, sizePerList);
	}

	@Override
	public int selectTotalCount(String workRegion, String employmentType) {
		return recruitDao.selectTotalCount(workRegion, employmentType);
	}

	@Override
	public Recruit selectOne(int writeNo) {
		return recruitDao.selectOne(writeNo);
	}

	@Override
	public int insert(Recruit recruit) {
		return recruitDao.insert(recruit);
	}

	@Override
	public int update(Recruit recruit) {
		return recruitDao.update(recruit);
	}

	@Override
	public int delete(int writeNo) {
		return recruitDao.delete(writeNo);
	}

	@Override
	public int addViewCount(int writeNo) {
		return recruitDao.addViewCount(writeNo);
	}

}
