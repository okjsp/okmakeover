package net.okjsp.techqna.dao;

import java.util.List;

import net.okjsp.techqna.model.TechQna;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * TechQna Dao
 * 
 * @author yjc0703
 *
 */
@Repository
public interface TechQnaDao {
	
	/**
	 * question total count
	 * 	
	 * @return question total count
	 */
	public Integer selectTechQnaTotalCount(@Param("boardId") int boardId, @Param("categoryId") int categoryId);
	
	/**
	 * question total count(by tag)
	 * 	
	 * @return question total count
	 */
	public Integer selectTechQnaByTagTotalCount(@Param("boardId") int boardId, 
			                                    @Param("categoryId") int categoryId, 
			                                    @Param("tagName") String tagName);

    /**
     * Question List(메인 리스트에서는 Question만 보인다)
     * 조회조건 X
     * 
     * @param sort 정렬기준
     * @param offset 시작 offset
     * @param sizePerList 목록에 보여질 row count
     * @return TechQna 목록
     */
    public List<TechQna> selectTechQnaList(@Param("boardId") int boardId,
						            @Param("categoryId") int categoryId, 
						            @Param("sort") String sort,
                                    @Param("offset") Integer offset,
                                    @Param("sizePerList") Integer sizePerList);
    
    /**
     * Question List(메인 리스트에서는 Question만 보인다)
     * 선택된 태그에 대한 목록만 조회
     * 
     * @param tagName 태그명
     * @param sort 정렬기준
     * @param offset 시작 offset
     * @param sizePerList 목록에 보여질 row count
     * @return TechQna 목록
     */
    public List<TechQna> selectTechQnaListByTag(@Param("boardId") int boardId,
                                         @Param("categoryId") int categoryId, 
                                         @Param("tagName") String tagName,
                                         @Param("sort") String sort,
                                         @Param("offset") Integer offset,
                                         @Param("sizePerList") Integer sizePerList);

    /**
     * TechQna 상세보기
     * 한개의 질문과 여러개의 답변이 리스트로 구성 
     * 
     * @param writeNo 게시글번호(질문)
     * @return 리스트
     */
    public List<TechQna> selectTechQnaDetail(@Param("boardId") int boardId,
                                             @Param("categoryId") int categoryId, 
                                             @Param("writeNo") Integer writeNo);
    
    /**
     * TechQna 단일 질문
     * 질문 한개를 가져온다. 
     * 
     * @param writeNo 게시글번호(질문)
     * @return TechQna
     */
    public TechQna selectOneTechQnaQuestion(@Param("boardId") int boardId,
                                             @Param("categoryId") int categoryId, 
                                             @Param("writeNo") Integer writeNo);
    
    /**
     * TechQna 질문
     * 여러개의 답변이 리스트로 구성 
     * 
     * @param writeNo 게시글번호(질문)
     * @return 리스트
     */
    public List<TechQna> selectTechQnaAnswers(@Param("boardId") int boardId,
                                             @Param("categoryId") int categoryId, 
                                             @Param("writeNo") Integer writeNo);
 
    /**
     * TechQna 질문
     * 단일 답변 전달 
     * 
     * @param writeNo 게시글번호(질문)
     * @return 리스트
     */
    public TechQna selectOneTechQnaAnswer(@Param("boardId") int boardId,
                                             @Param("categoryId") int categoryId, 
                                             @Param("writeNo") Integer writeNo,
                                             @Param("parentId") Integer parentId);
    
    
    /**
     * TechQna 등록
     * 
     * @param techQna Tech Qna
     */
    public void insert(TechQna techQna);

    /**
     * TechQna 수정
     *
     * @param techQna Tech Qna
     */
    public void update(TechQna techQna);
    
    /**
     * TechQna 조회수 증가
     *
     * @param techQna Tech Qna
     */
    public void incPostingHit(@Param("writeNo") Integer writeNo);
    
}
