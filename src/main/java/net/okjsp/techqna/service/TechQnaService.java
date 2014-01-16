package net.okjsp.techqna.service;

import java.util.List;

import net.okjsp.common.model.Paging;
import net.okjsp.techqna.model.Revision;
import net.okjsp.techqna.model.TechQna;

/**
 * Tech QNA service
 * 
 * @author yjc0703
 *
 */
public interface TechQnaService {
	/**
	 * Tech QNA 리스트(질문목록)
	 * 
	 * @param paging 페이징
	 * @param sortType 정렬기준(최근순, 답변많은순 등등...)
	 * @return Tach QNA 리스트
	 */
	List<TechQna> selectTechQnaList(Paging paging, String sortType);
	
	/**
	 * Tech QNA 리스트(질문목록)
	 * 
	 * @param paging 페이징
	 * @param sortType 정렬기준(최근순, 답변많은순 등등...)
	 * @param tagName 특정 Tag가 포함된 목록만 조회
	 * @return Tach QNA 리스트
	 */
	List<TechQna> selectTechQnaList(Paging paging, String sortType, String tagName);
	
	/**
	 * Tech QNA Detail
	 * 질문 클릭 후 내용보기 화면에서 사용
	 * 	
	 * @param WriteNo 게시글번호(Question 기준)
	 * @return Tech QNA 리스트(1 Question + N Answers.. LinkedList로 순서 섞이지 않게)
	 */
	List<TechQna> selectTechQnaDetail(Integer WriteNo);
	
	/**
	 * Tech QNA 생성
	 * 
	 * @param techQna
	 */
	void createTechQna(TechQna techQna);
	
	/**
	 * Tech QNA 수정
	 * 
	 * @param techQna
	 */
	void updateTechQna(TechQna techQna);
	
	/**
	 * Tech QNA Revision List
	 * 변경이력 조회 화면에서 사용
	 * 
	 * @param techQna 
	 */
	List<Revision> selectRevisionList(Integer writeNo);
}
