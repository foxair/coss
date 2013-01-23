package com.github.coss.web.index.chart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.github.coss.app.index.service.IndexDataService;
import com.github.coss.app.index.vo.IndexData;
import com.github.coss.common.utils.lang.DateTime.DateUtils;
import com.github.coss.web.index.vo.IndexLineData;

@Controller
@RequestMapping("/data")
public class DataController {

    @Resource
    IndexDataService indexDataService;

    @RequestMapping("index.htm")
    public Model indexPage(Model model) {
        return model;
    }

    @RequestMapping("amount.json")
    @ResponseBody
    public JSONArray amount(@RequestParam(value = "start", required = false) Long start,
                                      @RequestParam(value = "end", required = false) Long end) {
        //TODO 将时间段内数据取出,再通过程序处理成段合计
        Date startTime = DateUtils.parse("2012-03-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date endTime = DateUtils.parse("2012-03-15 00:00:00", "yyyy-MM-dd HH:mm:ss");
        List<IndexData> indexDataList = indexDataService
                .findByBankIdAndDate(0L, startTime, endTime);//统计了bankId为0的数据
        //TODO 以下处理数据成chart控件格式
        //?start=1152371895652&end=1262430156522
        //{name: 'test1',data: [7.0, 6.9, 9.5, 14.5]}
        List<IndexLineData> indexLineList = new ArrayList<IndexLineData>();
        Float[][] data = new Float[indexDataList.size()][2];
        for (int i = 0; i < indexDataList.size(); i++) {
            IndexData indexData = indexDataList.get(i);
            data[i][0] = (float) indexData.getPartDate().getTime();
            data[i][1] = (float) i;
        }
        indexLineList.add(new IndexLineData("银行合计", data));
        //return indexLineList;
        String text = "[{'name':'金额','data':[[1330531200000,3],[1333209600000,2],[1335801600000,1],[1338480000000,7],[1341072000000,2],[1343750400000,1],[1346428800000,1],[1349020800000,6],[1351699200000,3],[1354291200000,2]]}]";
        return JSONArray.parseArray(text);
        //"[{'name':'金额','data':[[1330531200000,3],[1333209600000,2],[1335801600000,1],[1338480000000,7],[1341072000000,2],[1343750400000,1],[1346428800000,1],[1349020800000,6],[1351699200000,3],[1354291200000,2]]}]";
        //"[{'name':'金额','data':[[1331136040000,0],[1331308790000,1],[1330876780000,2],[1331568050000,3],[1331049660000,4],[1331395170000,5],[1330790400000,6],[1330531140000,7],[1331222410000,8],[1330617650000,9],[1330704020000,10],[1330963150000,11],[1331654430000,12],[1331481540000,13]]}]";
    }
}
