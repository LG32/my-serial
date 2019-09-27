package com.example.springboot.demo.controller;


import com.example.springboot.demo.datebase.Model_kind;
import com.example.springboot.demo.datebase.Model_kind_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class Model_kind_Controller {

    private final Model_kind_Repository model_kind_repository;

    @Autowired
    public Model_kind_Controller(Model_kind_Repository model_kind_repository){
        this.model_kind_repository = model_kind_repository;
    }

    /**
     * 获取整个model_kind数据
     * @return {code:1/0,msg:成功/失败}
     */
    @RequestMapping(value = "/getModelKind", method = RequestMethod.GET)
    @ResponseBody
    public Object getModelKind(){
        System.out.println("进入获取整个model_kind表");
        Map<Object, Object> map = new HashMap<>();
        try{
            List<Model_kind> kinds;
            kinds = model_kind_repository.findAll();
            map.put("code", 1);
            map.put("msg", "获取kind数据成功");
            map.put("data", kinds);
        } catch(Exception e){
            map.put("code", 0);
            map.put("msg", "获取kinds数据失败");
            e.printStackTrace();
        }
        return map;
    }
}
