package com.alan.community;

import com.alan.community.dao.DiscussPostMapper;
import com.alan.community.elasticsearch.DiscussPostRepository;
import com.alan.community.entity.DiscussPost;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/10/12 13:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = NowcoderCommunityApplication.class)
class ElasticsearchTests {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private DiscussPostRepository discussRepository;

//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void testInsert() {
        discussRepository.save(discussPostMapper.selectDiscussPostById(241));
        discussRepository.save(discussPostMapper.selectDiscussPostById(242));
        discussRepository.save(discussPostMapper.selectDiscussPostById(243));
    }

    @Test
    public void testInsertList() {
        discussRepository.saveAll(discussPostMapper.selectDiscussPosts(101, 0, 100));
        discussRepository.saveAll(discussPostMapper.selectDiscussPosts(102, 0, 100));
        discussRepository.saveAll(discussPostMapper.selectDiscussPosts(103, 0, 100));
        discussRepository.saveAll(discussPostMapper.selectDiscussPosts(111, 0, 100));
        discussRepository.saveAll(discussPostMapper.selectDiscussPosts(112, 0, 100));
        discussRepository.saveAll(discussPostMapper.selectDiscussPosts(131, 0, 100));
        discussRepository.saveAll(discussPostMapper.selectDiscussPosts(132, 0, 100));
        discussRepository.saveAll(discussPostMapper.selectDiscussPosts(133, 0, 100));
        discussRepository.saveAll(discussPostMapper.selectDiscussPosts(134, 0, 100));
    }

    @Test
    public void testUpdate() {
        DiscussPost discussPost = discussPostMapper.selectDiscussPostById(231);
        discussPost.setContent("im new,lalalala!");
        discussRepository.save(discussPost);
    }

    @Test
    public void testDelete() {
        discussRepository.deleteById(231);
    }

    @Test
    public void testSearchByRepository() {

    }

    @Test
    public void testSearchByTemplate(){

    }
}

