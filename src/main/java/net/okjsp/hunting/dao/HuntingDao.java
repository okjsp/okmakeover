package net.okjsp.hunting.dao;

import net.okjsp.hunting.model.Hunting;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface HuntingDao {

    public List<Hunting> selectList(
            @Param("workRegion") String workRegion,
            @Param("employmentType") String employmentType,
            @Param("sort") String sort,
            @Param("offset") String offset,
            @Param("sizePerList") int sizePerList);

    public int selectTotalCount(
    		@Param("workRegion") String workRegion,
            @Param("employmentType") String employmentType);

    public Hunting selectOne(@Param("writeNo") int writeNo);

    public int insert(Hunting hunting);

    public int update(Hunting hunting);

    public int delete(@Param("writeNo") int writeNo);

    public int addViewCount(@Param("writeNo") int writeNo);

}
