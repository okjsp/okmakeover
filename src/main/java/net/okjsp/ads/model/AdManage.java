package net.okjsp.ads.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * 광고 관리 Model.
 *
 * @author jaeger
 */
public class AdManage implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 회원 아이디
     */
    private String userId;

    /**
     * 광고 아이디
     */
    private String adId;

    /**
     * 광고 타입
     */
    private String adType;

    /**
     * 배너 이미지
     */
    private String bannerImg;

    /**
     * 배너 내용
     */
    private String bannerText;

    /**
     * 광고 링크
     */
    private String linkUrl;

    /**
     * 광고 조회수
     */
    private Integer hitCount;

    /**
     * 광고 시작일
     */
    private Date startDate;

    /**
     * 광고 종료일
     */
    private Date endDate;


    /**
     * 회원 아이디 Getter.
     *
     * @return 회원 아이디
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 회원 아이디 Setter.
     *
     * @param userId 회원 아이디
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 광고 아이디 Getter.
     *
     * @return 광고 아이디
     */
    public String getAdId() {
        return adId;
    }

    /**
     * 광고 아이디 Setter.
     *
     * @param adId 광고 아이디
     */
    public void setAdId(String adId) {
        this.adId = adId;
    }

    /**
     * 광고 타입 Getter.
     *
     * @return 광고 타입
     */
    public String getAdType() {
        return adType;
    }

    /**
     * 광고 타입 Setter.
     *
     * @param adType 광고 타입
     */
    public void setAdType(String adType) {
        this.adType = adType;
    }

    /**
     * 배너 이미지 Getter.
     *
     * @return 배너 이미지
     */
    public String getBannerImg() {
        return bannerImg;
    }

    /**
     * 배너 이미지 Setter.
     *
     * @param bannerImg 배너 이미지
     */
    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    /**
     * 배너 내용 Getter.
     *
     * @return 배너 내용
     */
    public String getBannerText() {
        return bannerText;
    }

    /**
     * 배너 내용 Setter.
     *
     * @param bannerText 배너 내용
     */
    public void setBannerText(String bannerText) {
        this.bannerText = bannerText;
    }

    /**
     * 광고 링크 Getter.
     *
     * @return 광고 링크
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * 광고 링크 Setter.
     *
     * @param linkUrl 광고 링크
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    /**
     * 광고 조회수 Getter.
     *
     * @return 광고 조회수
     */
    public Integer getHitCount() {
        return hitCount;
    }

    /**
     * 광고 조회수 Setter.
     *
     * @param hitCount 광고 조회수
     */
    public void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }

    /**
     * 광고 시작일 Getter.
     *
     * @return 광고 시작일
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 광고 시작일 Setter.
     *
     * @param startDate 광고 시작일
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 광고 종료일 Getter.
     *
     * @return 광고 종료일
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 광고 종료일 Setter.
     *
     * @param endDate 광고 종료일
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
