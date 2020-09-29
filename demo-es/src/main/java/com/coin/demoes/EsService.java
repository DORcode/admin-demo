package com.coin.demoes;

import com.coin.base.config.JacksonUtil;
import com.coin.demoes.es.config.RestClientCallback;
import com.coin.demoes.es.config.RestClientTemplate;
import com.fasterxml.jackson.core.JsonParser;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.script.mustache.SearchTemplateRequest;
import org.elasticsearch.script.mustache.SearchTemplateResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EsService
 * @Description: TODO
 * @Author kh
 * @Date 2020-09-16 17:27
 * @Version V1.0
 **/
@Service
public class EsService {

    @Autowired
    RestClientTemplate restClientTemplate;

    /**
     * @MethodName createIndex
     * @Description 创建索引
     * @param index
     * @return void
     * @throws
     * @author kh
     * @date 2020-09-16 17:49
     */
    public void createIndex(String index, String map) throws Exception {

        if(existsIndex(index)) {
            System.out.println("\"索引已存在\" = " + "索引已存在");
            return;
        }
        CreateIndexRequest request = new CreateIndexRequest(index);
        request.settings(Settings.builder()
                .put("index.number_of_shards", 1)
                .put("index.number_of_replicas", 1)
        );
        request.mapping(map, XContentType.JSON);
        CreateIndexResponse createIndexResponse = restClientTemplate.execute(client -> {
            return client.indices().create(request, RequestOptions.DEFAULT);
        });

        // CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println("createIndexResponse = " + JacksonUtil.toJSONString(createIndexResponse));
    }

    /**
     * @MethodName existsIndex
     * @Description 查询索引是否存在
     * @param index
     * @return boolean
     * @throws
     * @author kh
     * @date 2020-09-16 17:49
     */
    public boolean existsIndex(String index) throws IOException {
        GetIndexRequest request = new GetIndexRequest(index);
        boolean exists = restClientTemplate.execute(new RestClientCallback<Boolean>() {
            @Override
            public Boolean request(RestHighLevelClient client) throws IOException {
                return client.indices().exists(request, RequestOptions.DEFAULT);
            }
        });
        // boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        return exists;
    }

    public boolean deleteIndex(String index) throws Exception {
        if(!existsIndex(index)) {
            throw new Exception("索引不存在");
        }
        DeleteIndexRequest request = new DeleteIndexRequest(index);
        AcknowledgedResponse execute = restClientTemplate.execute(client -> {
            return client.indices().delete(request, RequestOptions.DEFAULT);
        });
        return true;
    }

    public void update() {

    }

    public void delete() {

    }

    public SearchResponse search(String index, int from, int size, String keyWord, String highlightName, String preTags, String postTags, String... fieldNames) {
        SearchRequest searchRequest = new SearchRequest(index);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.multiMatchQuery(keyWord, fieldNames));
        sourceBuilder.from(from);
        sourceBuilder.size(size);
        searchRequest.source(sourceBuilder);
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        HighlightBuilder.Field highlightField = new HighlightBuilder.Field(highlightName);
        // highlightField.highlighterType("");
        highlightField.preTags(preTags);
        highlightField.postTags(postTags);
        highlightBuilder.fragmentSize(100000);
        highlightBuilder.numOfFragments(1);
        highlightBuilder.field(highlightField);
        sourceBuilder.highlighter(highlightBuilder);
        SearchResponse searchResponse = restClientTemplate.execute(client -> {
            return client.search(searchRequest, RequestOptions.DEFAULT);
        });

        return searchResponse;
//
    }

    public SearchResponse search(String index, int from, int size, String keyWord, List<String> highlightNames, String preTags, String postTags, String... fieldNames) {
        SearchRequest searchRequest = new SearchRequest(index);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.multiMatchQuery(keyWord, fieldNames));
        sourceBuilder.from(from);
        sourceBuilder.size(size);
        searchRequest.source(sourceBuilder);
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        for(String hln : highlightNames) {
            HighlightBuilder.Field highlightField = new HighlightBuilder.Field(hln);
            // highlightField.highlighterType("");
            highlightField.preTags(preTags);
            highlightField.postTags(postTags);
            highlightBuilder.fragmentSize(100000);
            highlightBuilder.numOfFragments(1);
            highlightBuilder.field(highlightField);
        }

        sourceBuilder.highlighter(highlightBuilder);
        SearchResponse searchResponse = restClientTemplate.execute(client -> {
            return client.search(searchRequest, RequestOptions.DEFAULT);
        });

        return searchResponse;
//
    }

    public SearchTemplateResponse search(String index, String script,  Map<String, Object> param) {
        SearchTemplateRequest request = new SearchTemplateRequest();
        request.setRequest(new SearchRequest(index));
        request.setScriptType(ScriptType.INLINE);
        request.setScript(script);
        request.setScriptParams(param);
        SearchTemplateResponse templateResponse = restClientTemplate.execute(client -> {
            return client.searchTemplate(request, RequestOptions.DEFAULT);
        });
//        "{" +
//                "  \"query\": { \"match\" : { \"{{field}}\" : \"{{value}}\" } }," +
//                "  \"size\" : \"{{size}}\"" +
//                "}");
        return templateResponse;
    }

    /**
     * @MethodName insertDoc
     * @Description 插入文档
     * @param index
     * @param source
     * @return void
     * @throws
     * @author kh
     * @date 2020-09-22 14:17
     */
    public void insertDoc(String index, Map<String, ?> source) {
        IndexRequest indexRequest = new IndexRequest(index);
        indexRequest.source(source);
        IndexResponse indexResponse = restClientTemplate.execute(restHighLevelClient -> {
            return restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        });
    }

    /**
     * @MethodName insertDoc
     * @Description 插入文档
     * @param index 索引名称
     * @param pipeline 管理，可以做一些处理，如果附件base64处理为文字
     * @param source 文档数据
     * @return void
     * @throws
     * @author kh
     * @date 2020-09-22 14:18
     */
    public void insertDoc(String index, String pipeline, Map<String, ?> source) {
        IndexRequest indexRequest = new IndexRequest(index);
        indexRequest.setPipeline(pipeline);
        indexRequest.source(source);
        IndexResponse indexResponse = restClientTemplate.execute(restHighLevelClient -> {
            return restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        });
    }

    public void bulk() {
        BulkRequest bulkRequest = new BulkRequest();
        List<IndexRequest> requests = new ArrayList<>();
        for (IndexRequest ir : requests) {
            bulkRequest.add(ir);
        }

        restClientTemplate.execute(client -> {
            return client.bulk(bulkRequest, RequestOptions.DEFAULT);
        });
    }

}
