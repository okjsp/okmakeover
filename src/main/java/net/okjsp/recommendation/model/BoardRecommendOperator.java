package net.okjsp.recommendation.model;

import java.util.List;

// TODO : model위치가 아닌 util 쪽으로 가는게 나을듯 보임.
public class BoardRecommendOperator {
	
	/**
     * 블라인드 처리 만족 갯수
     */
	private static final int SatisfactionBlindCount = 5;
	
    /**
     * 추천/신고/반대 리스트
     */
    private List<BoardRecommend> boardRecommendList = null;
    
    /**
     * 추천 count
     */
    private int recommendCount = 0;
    
    /**
     * 반대 count
     */
    private int opposeCount = 0;
    
    /**
     * 신고 count
     */
    private int accuseCount = 0;
    
	public List<BoardRecommend> getBoardRecommendList() {
		return boardRecommendList;
	}

	public void setBoardRecommendList(List<BoardRecommend> boardRecommendList) {
		this.boardRecommendList = boardRecommendList;
		setCounts();
	}
    
	public Boolean isRecommend() {
		return (recommendCount >= opposeCount);
	}
	
	public Boolean isOppose() {
		return (opposeCount > recommendCount);
	}
	
	public Boolean isAccuse() {
		return (accuseCount >= SatisfactionBlindCount);
	}
	
	public Integer getRecommendOpposeCount() {
		return Math.abs(recommendCount - opposeCount);
	}
    
	// TODO : 함수명이 별로 마음에 들지 않음... 리펙토링 할 때 변경해야 한다.
	private void setCounts() {
		for (BoardRecommend recommend : boardRecommendList) {
			if (recommend.getTypeId().equals(BoardRecommend.Type.RECOMMEND)) {
				recommendCount++;
			} else if (recommend.getTypeId().equals(BoardRecommend.Type.OPPOSE)) {
				opposeCount++;
			} else if (recommend.getTypeId().equals(BoardRecommend.Type.ACCUSE)) {
				accuseCount++;
			}
		}
	}
}
