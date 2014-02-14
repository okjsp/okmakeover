package net.okjsp.community.service;

import java.util.List;

import net.okjsp.community.dao.CommunityDao;
import net.okjsp.community.model.Article;
import net.okjsp.community.model.Board;
import net.okjsp.common.model.Paging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommunityServiceImple implements CommunityService {
	@Autowired
    CommunityDao communityDao;
	
	@Override
	public List<Article> getArticles(int boardId, int categoryId,
                                     Paging paging) {
		
		List<Article> list = communityDao.selectAticles(boardId, categoryId, paging.getOffset(), paging.getSizePerList());
		
	    return list;
	}

	@Override
	public int getTotalCount(int boardId, int categoryId) {
		int count = communityDao.selectTotalCount(boardId, categoryId);

        return count;
	}
	
	@Override
	public Article getArticle(int writeNo) {
		return communityDao.selectArticle(writeNo);
	}

	@Override
    @Transactional
	public boolean addArticleHit(int writeNo) {
		int count = communityDao.addArticleHit(writeNo);

		if (count > 0 ) {
			return true;
		}
        return false;
	}

	@Override
    @Transactional
	public boolean create(Article article) {
		boolean result = false;

        int count = communityDao.insertArticle(article);

        if(count > 0) {
            result = true;
        }

        return result;
	}

	@Override
    @Transactional
	public boolean modify(Article article) {
		boolean result = false;

        int count = communityDao.updateArticle(article);

        if(count > 0) {
            result = true;
        }

        return result;
	}

	@Override
    @Transactional
	public boolean delete(int writeNo) {
		boolean result = false;

        int count = communityDao.deleteArticle(writeNo);

        if(count > 0) {
            result = true;
        }

        return result;
	}

}
