package com.coin.demoes;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SearchController
 * @Description: TODO
 * @Author kh
 * @Date 2020-09-28 11:34
 * @Version V1.0
 **/
@RestController
public class SearchController {

    @Autowired
    EsService esService;

    /**
     * @MethodName search
     * @Description 新闻或附件查询
     * @param keyword
     * @param from
     * @param size
     * @return java.util.Map
     * @throws
     * @author kh
     * @date 2020-09-28 15:33
     */
    @GetMapping("/search")
    public Map search(String keyword, int from, int size) {
        if(from <= 0) {
            from = 0;
        } else {
            from = (from -1) * size;
        }
        List<String> highNames = new ArrayList<>();
        highNames.add("content");
        highNames.add("attachment.content");
        SearchResponse search = esService.search("single-index-00001", from, size, keyword, "attachment.content", "<span class=\"match-word\">", "</span>", "attachment.content", "content");
        int total = search.getSuccessfulShards();

        System.out.println("search = " + search);
        SearchHits hits = search.getHits();
        Map result = new HashMap();
        List<Map> list = new ArrayList<>();
        for(SearchHit hit : hits.getHits()) {

            Map<String, Object> map = hit.getSourceAsMap();
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField highlight = highlightFields.get("attachment.content");
            Text[] fragments = highlight.getFragments();
            map.put("highlight", fragments[0].toString());
            map.put("test", highlightFields);
            map.put("type", "file");
            list.add(map);
        }
        result.put("data", list);
        result.put("total", total);
        return result;
    }
}
