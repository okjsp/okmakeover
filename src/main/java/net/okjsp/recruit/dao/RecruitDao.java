package net.okjsp.recruit.dao;

import java.util.List;
import net.okjsp.recruit.model.Recruit;
import org.apache.ibatis.annotations.Param;

public interface RecruitDao {
    public List<Recruit> selectList(
            @Param("workRegion") String workRegion,
            @Param("employmentType") String employmentType,
            @Param("sort") String sort,
            @Param("offset") String offset,
            @Param("sizePerList") int sizePerList);

    public int selectTotalCount(
    		@Param("workRegion") String workRegion,
            @Param("employmentType") String employmentType);

    public Recruit selectOne(@Param("writeNo") int writeNo);

    public int insert(Recruit recruit);

    public int update(Recruit recruit);

    public int delete(@Param("writeNo") int writeNo);

    public int addViewCount(@Param("writeNo") int writeNo);
}
