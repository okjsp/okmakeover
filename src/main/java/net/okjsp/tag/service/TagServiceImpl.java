package net.okjsp.tag.service;

import net.okjsp.tag.dao.TagDao;
import net.okjsp.tag.dao.TagMappingDao;
import net.okjsp.tag.model.Tag;
import net.okjsp.tag.model.TagMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * 태그 매핑 Service 구현체.
 *
 * @author jaeger
 */
@Service
public class TagServiceImpl implements TagService {
    private final Logger logger = LoggerFactory.getLogger(TagServiceImpl.class);

    @Autowired
    public TagDao tagDao;

    @Autowired
    public TagMappingDao tagMappingDao;


    @Override
    public boolean createTag(Integer boardId, Integer writeNo, String[] tagList) {
        // 태그 등록 수
        int tagCount = 0;
        // 태그 매핑 등록 수
        int tagMappingCount = 0;

        // 태그 매핑 테이블에 태그 전부 삭제
        tagMappingDao.delete(boardId, writeNo);

        for (String tagString : tagList) {
            // 태그 정보 세팅
            Tag tag = new Tag();
            tag.setTagName(tagString);
            // TODO : PK 라서 대/소문자 구분을 해야 하지 않을까?
            // tag.setTagName(tagString.toUpperCase());

            try {
                // 태그 테이블에 태그 등록
                tagCount = tagDao.insert(tag);
            } catch (DuplicateKeyException dke) {
                tagCount = 1;

                // PK 중복 예외 무시
                logger.error("### Tag Table, DuplicateKeyException!!");
            }

            if (tagCount == 1) {
                // 태그 매핑 정보
                TagMapping tagMapping = new TagMapping();
                tagMapping.setBoardId(boardId);
                tagMapping.setTagName(tag.getTagName());
                tagMapping.setWriteNo(writeNo);

                // 태그 매핑 테이블에 매핑 정보 등록
                tagMappingCount += tagMappingDao.insert(tagMapping);
            }
            // 실패일때??
            else {
                throw new RuntimeException("Tag Failed.");
            }
        }

        if (tagMappingCount == tagList.length) {
            return true;
        } else {
            throw new RuntimeException("Tag Mapping Failed.");
        }
    }

    @Override
    public List<TagMapping> selectTagMappingList(Integer boardId, Integer writeNo) {
        return tagMappingDao.selectList(boardId, writeNo);
    }

    @Override
    public List<Tag> selectTagAutoComplete(String tag) {
        return tagDao.selectList(tag);
    }

    @Override
    public List<Tag> selectTagStatistics(Integer boardId) {
        return tagMappingDao.selectStatisticsList(boardId);
    }

}
