package net.okjsp.recommendation.service;

import net.okjsp.recommendation.model.Recommendation;
import java.util.List;

/**
 *
 *
 * @author yjc0703
 */
public interface RecommendationService {

    void setRecommendation(int userId, int boardId, int writeNo, String type);

    void setRecommendation(int userId, int boardId, int writeNo, int commentId, String type);

    void setRecommendation(Recommendation r);

    List<Recommendation> getRecommendation(int boardId, int writeNo);

    List<Recommendation> getRecommendation(int boardId, int writeNo, int commentId);

    List<Recommendation> getRecommendationByGuboon(int boardId, int writeNo, String type);

    List<Recommendation> getRecommendationByGuboon(int boardId, int writeNo, int commentId, String type);

}
