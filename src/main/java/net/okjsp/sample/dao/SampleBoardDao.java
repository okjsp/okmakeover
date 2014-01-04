package net.okjsp.sample.dao;

import net.okjsp.sample.model.Sample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: langerhans
 * Date: 2013. 11. 20.
 * Time: 오전 12:44
 * Description : 샘플 게시판 DAO
 */
@Repository
public interface SampleBoardDao {

    /**
     * 게시물 목록
     * @param categoryId
     * @param offset
     * @param sizePerList
     * @return
     */
    public List<Sample> selectList(
            @Param("categoryId") int categoryId,
            @Param("offset") int offset,
            @Param("sizePerList") int sizePerList);

    /**
     * 게시물 전체 Count
     * @param categoryId
     * @return
     */
    public int selectTotalCount(@Param("categoryId") int categoryId);

    /**
     * 게시물 상세
     * @param id 게시물 id
     * @return SampleBoard
     */
    public Sample selectOne(@Param("id") int id);

    /**
     * 게시물 등록
     * @param sampleBoard 게시물 내용
     * @return int
     */
    public int insert(Sample sampleBoard);

    /**
     * 게시물 수정
     * @param sampleBoard 게시물 내용
     * @return int
     */
    public int update(Sample sampleBoard);

    /**
     * 게시물 삭제
     * @param id 게시물 id
     * @return int
     */
    public int delete(@Param("id") int id);

    /**
     * 게시물 조회수 증가
     * @param id
     * @return
     */
    public int addViewCount(@Param("id") int id);
}
