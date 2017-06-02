package com.github.happut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bjwangfei3 on 2017/6/2.
 */
@Controller
public class DitiezuPostControllar {

    @Autowired
    private DitiezuService ditiezuService;

    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    @ResponseBody
    public Long createCity(@RequestBody DitiezuPost city) {
        return ditiezuService.saveCity(city);
    }

    @RequestMapping(value = "/api/city/search", method = RequestMethod.GET)
    @ResponseBody
    public List<DitiezuPost> searchCity(@RequestParam(value = "pageNumber") Integer pageNumber,
                                        @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                        @RequestParam(value = "searchContent") String searchContent) {
        return ditiezuService.searchCity(pageNumber,pageSize,searchContent);
    }
}
