package com.github.happut;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bjwangfei3 on 2017/6/2.
 */
@Repository
public interface DitiezuPostRepository extends ElasticsearchRepository<DitiezuPost, Long> {
}
