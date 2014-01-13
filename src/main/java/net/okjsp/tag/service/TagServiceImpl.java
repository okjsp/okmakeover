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
    public boolean createTag(Integer boardId, Integer writeId, Tag tag) {
        // 태그 등록 수
        int tagCount = 0;
        // 태그 매핑 등록 수
        int tagMappingCount = 0;

        // 태그 매핑 정보
        TagMapping tagMapping = new TagMapping();
        tagMapping.setBoardId(boardId);
        tagMapping.setTagName(tag.getTagName());
        tagMapping.setWriteId(writeId);

        // TODO : DB 등록시 경쟁 조건이라 고민?
        // 1. DB Table Lock
        // 2. Java Synchronized
/*
        int checkCount = 0;

        // 태그가 존재하는지 체크
        checkCount = tagDao.selectTotalCount(tag.getTagName());

        // 태그가 존재하면
        if (checkCount > 0) {
            // 태그 매핑 테이블에 매핑 정보 등록
            tagMappingDao.insert(tagMapping);
        }
        // 태그가 존재하지 않으면
        else {
            // 태그 테이블에 태그 등록
            tagDao.insert(tag);

            // 태그 매핑 테이블에 매핑 정보 등록
            tagMappingDao.insert(tagMapping);
        }
*/

        try {
            // 태그 테이블에 태그 등록
            tagCount = tagDao.insert(tag);
        } catch (DuplicateKeyException dke) {
            tagCount = 1;

            // PK 중복 예외 무시
            logger.error("### Tag Table, DuplicateKeyException!!");
        }

        if (tagCount == 1) {
            // 태그 매핑 테이블에 매핑 정보 등록
            tagMappingCount = tagMappingDao.insert(tagMapping);

            // 태그 매핑 정보 1건이 등록되었으면 성공!!
            return (tagMappingCount == 1);
        }

        return false;
    }

    @Override
    public boolean createTag(Integer boardId, Integer writeId, List<String> tag) {
        return false;
    }

    @Override
    public boolean modifyTag(Integer boardId, Integer writeId, List<String> tag) {
        return false;
    }

    @Override
    public boolean removeTag(Integer boardId, Integer writeId) {
        return false;
    }

    @Override
    public List<Tag> selectTagMappingList(Integer boardId, Integer writeId) {
        return null;
    }

    @Override
    public List<Tag> selectTagAutoComplete(Tag tag) {
        return null;
    }

    @Override
    public List<Tag> selectTagStatistics(Integer boardId, Integer writeId) {
        return null;
    }
}
