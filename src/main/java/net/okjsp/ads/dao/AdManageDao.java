package net.okjsp.ads.dao;

import net.okjsp.ads.model.AdManage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * 광고 관리 Dao.
 *
 * @author jaeger
 */
@Repository
public interface AdManageDao {

    /**
     * 광고 관리 조회
     *
     * @param adManage 광고 관리
     * @return 광고 관리
     */
    public AdManage selectOne(AdManage adManage);

    /**
     * 광고 관리 목록 조회
     *
     * @param userId 회원 id
     * @param adType 광고 타입
     * @return 광고 목록
     */
    public List<AdManage> selectAdManageList(@Param("userId") String userId,
                                             @Param("adType") String adType);

    /**
     * 광고 등록
     *
     * @param adManage 광고
     * @return
     */
    public Integer insertAdManage(AdManage adManage);

    /**
     * 광고 수정
     *
     * @param adManage 광고
     * @return
     */
    public Integer updateAdManage(AdManage adManage);

    /**
     * 광고 삭제
     *
     * @param adId 광고 id
     * @return
     */
    public Integer deleteAdManage(@Param("adId") String adId);

}
