package com.coin.demoes;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.lucene.search.TotalHits;
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
@Api(tags="搜索")
@RestController
@RequestMapping("/fulltext")
public class SearchController {

    @Autowired
    EsService esService;

    /**
     * @MethodName search
     * @Description 新闻或附件查询
     * @param keyword
     * @param page
     * @param size
     * @return java.util.Map
     * @throws
     * @author kh
     * @date 2020-09-28 15:33
     */
    @GetMapping("/all/search")
    @ApiOperation(value = "搜索", notes = "搜索结果根据type区分：file文件，artical文章，相应的字段不同")
    public Map search(String keyword, int page, int size) {
        int from = 0;
        if(page <= 0) {
            from = 0;
        } else {
            from = (page -1) * size;
        }
        List<String> highNames = new ArrayList<>();
        highNames.add("content");
        highNames.add("attachment.content");
        SearchResponse search = esService.search("single-index-00001", from, size, keyword, highNames,
                "<span class=\"match-word\">", "</span>",
                "attachment.content", "content");

        SearchHits hits = search.getHits();
        Map result = new HashMap();
        List<Map> list = new ArrayList<>();
        for(SearchHit hit : hits.getHits()) {
            Map<String, Object> map = hit.getSourceAsMap();
            if(map.containsKey("attachment")) {
                Map attachment = (Map) map.get("attachment");
                map.put("content", attachment.get("content"));
                map.remove("attachment");
            }
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField attachhighlight = highlightFields.get("attachment.content");
            Map hightMap = new HashMap();
            if(attachhighlight != null) {
                Text[] attachfragments = attachhighlight.getFragments(); // 拼接
                hightMap.put("content", getHighlight(attachfragments));
            }

            HighlightField contenthighlight = highlightFields.get("content");
            if(contenthighlight != null) {
                Text[] contentfragments = contenthighlight.getFragments(); // 拼接
                hightMap.put("content", getHighlight(contentfragments));

            }
            map.put("id", hit.getId());
            map.put("highlight", hightMap);

            list.add(map);
        }
        result.put("data", list);
        TotalHits totalHits = search.getHits().getTotalHits();
        result.put("total", totalHits.value);
        return result;
    }

    private String getHighlight(Text[] fragments) {
        StringBuffer sb = new StringBuffer();

        for(Text f : fragments) {
            sb.append(f.toString());
        }
        return sb.toString();
    }
}
