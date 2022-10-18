package com.alan.community.elasticsearch;

import com.alan.community.entity.DiscussPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/10/15 19:06
 */
// 此接口只需继承ElasticsearchRepository，标明查询的实体类和主键类型，即可实现crud
@Repository
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost,Integer> {
}
