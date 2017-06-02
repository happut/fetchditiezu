package com.github.happut;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bjwangfei3 on 2017/6/2.
 */
@Service
public class DitiezuService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DitiezuService.class);

    @Autowired
    DitiezuPostRepository ditiezuPostRepository;

    public Long saveCity(DitiezuPost city) {

        DitiezuPost cityResult = ditiezuPostRepository.save(city);
        return cityResult.getId();
    }

    public List<DitiezuPost> searchCity(Integer pageNumber,
                                        Integer pageSize,
                                        String searchContent) {
        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);

        // Function Score Query
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("cityname", searchContent)),
                        ScoreFunctionBuilders.weightFactorFunction(1000))
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("description", searchContent)),
                        ScoreFunctionBuilders.weightFactorFunction(100));

        // 创建搜索 DSL 查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();

        LOGGER.info("\n searchCity(): searchContent [" + searchContent + "] \n DSL  = \n " + searchQuery.getQuery().toString());

        Page<DitiezuPost> searchPageResults = ditiezuPostRepository.search(searchQuery);
        return searchPageResults.getContent();
    }
}
