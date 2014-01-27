package net.okjsp.tag.model;

import java.io.Serializable;

/**
 * 태그 Model.
 *
 * @author jaeger
 */
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * Tag 생성자 
     */
    public Tag() {
    	this.tagSummary = "";
    	this.tagUrl = "";
    }
    
    /**
     * Tag 생성자
     * 
     * @param tagName 태그명
     */
    public Tag(String tagName) {
    	this.tagName = tagName;
    	this.tagSummary = "";
    	this.tagUrl = "";
    }

    /**
     * 태그명
     */
    private String tagName;
    /**
     * 태그 설명
     */
    private String tagSummary;
    /**
     * 태그 URL
     */
    private String tagUrl;
    /**
     * 태그 개수
     */
    private Integer tagCount;


    /**
     * 태그명 Getter.
     *
     * @return 태그명
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * 태그명 Setter.
     *
     * @param tagName 태그명
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * 태그 설명 Getter.
     *
     * @return 태그 설명
     */
    public String getTagSummary() {
        return tagSummary;
    }

    /**
     * 태그 설명 Setter.
     *
     * @param tagSummary 태그 설명
     */
    public void setTagSummary(String tagSummary) {
        this.tagSummary = tagSummary;
    }

    /**
     * 태그 URL Getter.
     *
     * @return 태그 URL
     */
    public String getTagUrl() {
        return tagUrl;
    }

    /**
     * 태그 URL Setter.
     *
     * @param tagUrl 태그 URL
     */
    public void setTagUrl(String tagUrl) {
        this.tagUrl = tagUrl;
    }

    /**
     * 태그 개수 Getter.
     *
     * @return 태그 개수
     */
    public Integer getTagCount() {
        return tagCount;
    }

    /**
     * 태그 개수 Setter.
     *
     * @param tagCount 태그 개수
     */
    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
    }


    @Override
    public String toString() {
        return this.tagName;
    }

}

