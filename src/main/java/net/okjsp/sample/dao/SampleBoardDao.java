package net.okjsp.sample.dao;

import net.okjsp.sample.model.SampleBoard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: langerhans
 * Date: 2013. 11. 20.
 * Time: 오전 12:44
 * Description :
 */
@Repository
public interface SampleBoardDao {

    /**
     * 게시물 목록
     * @param page 페이지
     * @param listSize 리스트 사이즈
     * @return List<SampleBoard>
     */
    public List<SampleBoard> selectList(
            @Param("categoryId") int categoryId,
            @Param("offset") int offset,
            @Param("listSize") int listSize);

    /**
     * 게시물 상세
     * @param id 게시물 id
     * @return SampleBoard
     */
    public SampleBoard selectOne(@Param("id") int id);

    /**
     * 게시물 등록
     * @param sampleBoard 게시물 내용
     * @return int
     */
    public int insert(SampleBoard sampleBoard);

    /**
     * 게시물 수정
     * @param sampleBoard 게시물 내용
     * @return int
     */
    public int update(SampleBoard sampleBoard);

    /**
     * 게시물 삭제
     * @param id 게시물 id
     * @return int
     */
    public int delete(@Param("id") int id);

}
