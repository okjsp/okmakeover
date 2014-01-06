package net.okjsp.tag.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 태그 Model.
 *
 * @author jaeger
 */
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;

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


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
