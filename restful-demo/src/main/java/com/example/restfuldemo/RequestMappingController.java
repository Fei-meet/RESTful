package com.example.restfuldemo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@Controller
public class RequestMappingController {


    /**
     * @RequestMapping(value="test1", method=RequestMethod.GET,params = "name")  请求里面必有有个name参数
     * @RequestMapping(value="test1", method=RequestMethod.GET,params = "name=dafei")  请求里面必有有个name参数并且值为dafei
     */
    @RequestMapping(value="test1", method=RequestMethod.GET,params = "name=dafei")
    @ResponseBody
    public String test1(){
        return "ok";
    }


    /**
     *  @RequestMapping(value="test2", method=RequestMethod.GET,headers = "myheader=dafei")   必须带上请求头"myheader=dafei"
     */
    @RequestMapping(value="test2", method=RequestMethod.GET,headers = "myheader=dafei")
    @ResponseBody
    public String test2(){
        return "ok";
    }

    //客户端要求返回数据是：json
    //@RequestMapping(value="test3", method=RequestMethod.GET,headers = "accept=application/json")
    @RequestMapping(value="test3", method=RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public String test3(){
        return "ok--json";
    }
    //客户端要求返回数据是：xml
    @RequestMapping(value="test3", method=RequestMethod.GET,headers = "accept=application/xml")
    @ResponseBody
    public String test3_3(){
        return "ok--xml";
    }


    //客户端发送请求带上参数是：json
    //@RequestMapping(value="test4", method=RequestMethod.GET,headers = "content-type=application/json")
    @RequestMapping(value="test4", method=RequestMethod.GET,consumes = "application/json")
    @ResponseBody
    public String test4(){
        return "ok--json";
    }
    //客户端发送请求带上参数是：xml
    @RequestMapping(value="test4", method=RequestMethod.GET,headers = "content-type=application/xml")
    @ResponseBody
    public String test4_4(){
        return "ok--xml";
    }

}
