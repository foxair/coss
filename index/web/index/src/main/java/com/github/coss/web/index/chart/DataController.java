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

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping("amount.json")
    @ResponseBody
    public List<IndexLineData> amount(@RequestParam(value = "start", required = false) Long start,
                                      @RequestParam(value = "end", required = false) Long end) {
        //TODO 将时间段内数据取出,再通过程序处理成段合计
        //?start=1152371895652&end=1262430156522
        Date startTime = DateUtils.parse("2012-03-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date endTime = DateUtils.parse("2012-03-15 00:00:00", "yyyy-MM-dd HH:mm:ss");
        List<IndexData> indexDataList = indexDataService
                .findByBankIdAndDate(0L, startTime, endTime);//统计了bankId为0的数据
        //TODO 以下处理数据成chart控件格式
        List<IndexLineData> indexLineList = new ArrayList<IndexLineData>();
        List<List<?>> data = new ArrayList<List<?>>(indexDataList.size());
        for (int i = 0; i < indexDataList.size(); i++) {
            List dataNode = new ArrayList();
            IndexData indexData = indexDataList.get(i);
            dataNode.add(indexData.getPartDate().getTime());
            dataNode.add(indexData.getTransCount());
            data.add(dataNode);
        }
        indexLineList.add(new IndexLineData("金额", data));
        //[{"name":"金额","data":[[1330531200000,862],[1330617600000,715],[1330704000000,660],[1330790400000,720],[1330876800000,891],[1330963200000,887],[1331049600000,869],[1331136000000,799],[1331222400000,796],[1331308800000,894],[1331395200000,789],[1331481600000,703],[1331568000000,615],[1331654400000,728]]}]
        return indexLineList;
    }
}
