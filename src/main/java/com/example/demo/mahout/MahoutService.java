package com.example.demo.mahout;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.ReloadFromJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class MahoutService {
    @Autowired
    private DataSource dataSource;

    public List<RecommendedItem> recommend(long userId) throws TasteException {
        //interest table column명에 맞게 수정
        JDBCDataModel model=new MySQLJDBCDataModel(dataSource,"interest","user_id",
                "merchandise_id","prefer","null");
        ReloadFromJDBCDataModel dataModel=new ReloadFromJDBCDataModel(model);
        UserSimilarity similarity=new PearsonCorrelationSimilarity(dataModel);
        UserNeighborhood neighborhood=new ThresholdUserNeighborhood(0,similarity,dataModel);
        UserBasedRecommender recommender=new GenericUserBasedRecommender(dataModel,neighborhood,similarity);
        List<RecommendedItem> recommendedItems=recommender.recommend(userId,1);
        for(RecommendedItem recommendedItem:recommendedItems){
            System.out.println(recommendedItem);
        }
        return recommendedItems;
    }
}
