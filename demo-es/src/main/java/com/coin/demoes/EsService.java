package com.coin.demoes;

import com.coin.base.config.JacksonUtil;
import com.fasterxml.jackson.core.JsonParser;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    RestHighLevelClient restHighLevelClient;

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
            throw new Exception("索引已存在");
        }
        CreateIndexRequest request = new CreateIndexRequest(index);
        request.settings(Settings.builder()
                .put("index.number_of_shards", 1)
                .put("index.number_of_replicas", 1)
        );
        request.mapping(map, XContentType.JSON);
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
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
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        return exists;
    }

    public boolean deleteIndex(String index) throws Exception {
        if(!existsIndex(index)) {
            throw new Exception("索引不存在");
        }
        DeleteIndexRequest request = new DeleteIndexRequest(index);
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println("JacksonUtil.toJSONString(delete) = " + JacksonUtil.toJSONString(delete));
        return true;
    }

    public void insert() {

    }

    public void update() {

    }

    public void delete() {

    }

    public void bulk() {

    }

    public void search() {

    }

}
