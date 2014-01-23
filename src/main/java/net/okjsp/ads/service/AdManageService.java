package net.okjsp.ads.service;

import net.okjsp.ads.model.AdManage;

import java.util.List;


/**
 * 광고 관리 Service 인터페이스.
 *
 * @author jaeger
 */
public interface AdManageService {

    /**
     * 광고 관리 상세 조회
     *
     * @param adManage 광고 관리
     * @return 광고 관리
     */
    public AdManage selectAdManage(AdManage adManage);

    /**
     * 광고 관리 목록 조회
     *
     * @param adManage 광고 관리
     * @return 광고 목록
     */
    public List<AdManage> selectAdManageList(AdManage adManage);

    /**
     * 광고 등록
     *
     * @param adManage 광고
     * @return 등록 여부
     */
    public boolean insertAdManage(AdManage adManage);

    /**
     * 광고 수정
     *
     * @param adManage 광고
     * @return 수정 여부
     */
    public boolean updateAdManage(AdManage adManage);

    /**
     * 광고 삭제
     *
     * @param adManage 광고
     * @return 삭제 여부
     */
    public boolean deleteAdManage(AdManage adManage);

}

