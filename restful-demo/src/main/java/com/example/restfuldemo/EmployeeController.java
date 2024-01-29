package com.example.restfuldemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class EmployeeController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello restful";
    }

    /**
     * 获取所有的员工
     * 1>请求路径 --- 确认资源 --- 员工 --- /employees
     * 2>请求方法 --- 查询 --- GET
     * 3>请求参数 --- 无
     * 4>请求响应 --- 多个员工 --- List<Employee>/JsonResult --- Json
     *
     */
//    @RequestMapping(value = "/employees",method = RequestMethod.GET)
//    @ResponseBody
//    public List<Employee> list(){
//        // 查询mysql数据库，得到员工列表信息
//        //假装查询了数据库的到了list集合
//        List<Employee> list = Arrays.asList(new Employee(1L, "dafei", 18), new Employee(2L, "xiaofei", 17));
//        return list;
//    }
    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult list(){
        // 查询mysql数据库，得到员工列表信息
        //假装查询了数据库的到了list集合
        List<Employee> list = Arrays.asList(new Employee(1L, "dafei", 18), new Employee(2L, "xiaofei", 17));
        return JsonResult.success(list);
    }


    /**
     * 获取某个员工
     * 1>请求路径 --- 确认资源 --- 员工 --- /employees
     * 2>请求方法 --- 查询 --- GET
     * 3>请求参数 --- id
     * 4>请求响应 --- 某个员工 --- Employee --- Json
     *
     */

    /**
     * 查询所有员工接口：/employees    GET
     * 查询单个员工接口： /employees    GET
     * 上面2个接口映射路径与请求方法完全相同， springmvc 认为是同一个接口，不能同时存在，此时怎么办？
     * 方案1：使用多级路径方式   比如：  /employees/detail
     *
     * 方案2：使用参数路径方式   比如： /employees/{id}
     * 将请求参数作为路径一部分，进行url区分。
     *
     * 参数路径： /employees/{id}     其中 {id}   参数占位符
     * 客户端访问：   http://localhost:80/employees/1     1就是id参数值
     * 注意点：
     * 接口要获取参数路径中参数必须使用注释@PathVariable ，目的是让springmvc参数解析器从路径中解析出参数并进行赋值。
     * 如果参数路径中的占位符名称与请求映射方法形式参数名称不一致时，必须明确的指定映射
     * "/employees/{eid}" ----->@PathVariable("eid") Long id
     *
     */
    @RequestMapping(value = "/employees/{eid}",method = RequestMethod.GET)
    @ResponseBody
    public Employee detail(@PathVariable("eid") Long id){
        return new Employee(id,"dafei",18);
    }

//    多个参数
//    @RequestMapping(value = "/employees/{id}/{name}/{age}",method = RequestMethod.GET)
//    @ResponseBody
//    public Employee Moredetail(@PathVariable() Long id,@PathVariable() String name,@PathVariable() int age){
//        return new Employee(id,name,age);
//    }

//也可以对象封装
    @RequestMapping(value = "/employees/{id}/{name}/{age}",method = RequestMethod.GET)
    @ResponseBody
    public Employee info(Employee employee){
        return employee;
    }


    /**
     * 新增一个员工
     * 1>请求路径 --- 确认资源 --- 员工 --- /employees
     * 2>请求方法 --- 添加 --- POST
     * 3>请求参数 --- 员工相关属性 --- name,age
     * 4>请求响应 --- 新增员工对象 --- Employee --- Json
     *
     */



    @RequestMapping(value = "/employees",method = RequestMethod.POST)
    @ResponseBody
    public Employee save(Employee employee){
        //假装添加数据成功，返回自动增长id值
        employee.setId(1L);
        return employee;
    }

    /**
     * 更新一个员工
     * 1>请求路径 --- 确认资源 --- 员工 --- /employees
     * 2>请求方法 --- 更新 --- PUT
     * 3>请求参数 --- 员工相关属性 --- id name,age
     * 4>请求响应 --- 改后员工对象 --- Employee --- Json
     *
     */
    @RequestMapping(value = "/employees",method = RequestMethod.PUT)
    @ResponseBody
    public Employee update(Employee employee){
        //假装添加数据成功，返回自动增长id值
        employee.setName(employee.getName()+"_update");
        return employee;
    }

    /**
     * 删除一个员工
     * 1>请求路径 --- 确认资源 --- 员工 --- /employees
     * 2>请求方法 --- 删除 --- DELETE
     * 3>请求参数 --- 员工相关属性 --- id name,age
     * 4>请求响应 --- 删除后状态 --- JsonResult --- Json

     * JsonResult:统一的响应返回值

     * {
     *     code:200,
     *     msg:“操作成功”
     *     data:null
     * }
     */
    @RequestMapping(value = "/employees",method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult delete(Employee employee){
        //假装删除数据成功，返回JsonResult
        employee.setName(employee.getName()+"_update");
        return JsonResult.success();
    }


}
