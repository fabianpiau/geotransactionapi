package com.hack.geojson.team.six.controller;

import com.hack.geojson.team.six.model.RegionTransactionStat;
import com.hack.geojson.team.six.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RequestMapping("/api")
@Controller
public class RestApiController {

    @Autowired
    private StatsService statsService;

    @RequestMapping(value = "/aggregate")
    public
    @ResponseBody
    List<RegionTransactionStat> aggregate(@RequestParam(value = "from", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate, @RequestParam(value = "to", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

        if (beginDate == null) {
            beginDate = new Date(Timestamp.valueOf("2014-02-01 00:00:00").getTime());
        }
        if (endDate == null) {
            endDate = new Date();
        }

        return statsService.getAggregatedTransactionsPerRegion(beginDate, endDate);
    }

}
