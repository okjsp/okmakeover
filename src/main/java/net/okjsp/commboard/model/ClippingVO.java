package net.okjsp.commboard.model;

public class ClippingVO {

	// 스크랩ID
	private String clippingId;
	
	// 스크랩내용
	private String memo;
	
	// 저장시간
	private String writeDate;

	public String getClippingId() {
		return clippingId;
	}

	public void setClippingId(String clippingId) {
		this.clippingId = clippingId;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}	
	
	
}
