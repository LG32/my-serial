package com.example.springboot.demo.controller;

import com.example.springboot.demo.datebase.Model_info;
import com.example.springboot.demo.datebase.Model_info_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping
public class Model_info_Controller {

    private final Model_info_Repository model_info_repository;

    @Autowired
    public Model_info_Controller(Model_info_Repository model_info_repository){
        this.model_info_repository = model_info_repository;
    }

    //获取整个Model_info表
    @RequestMapping(value = "/getModelInfo",method = RequestMethod.GET)
    @ResponseBody
    public Object getAllOrders() {
        System.out.println("进入获取整个model表");
        Map<Object, Object> map  = new HashMap<>();
        try {
            List<Model_info> machines;
            machines = model_info_repository.findAll();
            map.put("code",1);
            map.put("msg","获取数据成功");
            map.put("data",machines);
        } catch (Exception e) {
            map.put("code",0);
            map.put("msg","获取数据失败");
            e.printStackTrace();
        } finally {
            return map;
        }
    }

    /**
     * 新增初始化设备
     * @param serial_number 设备序列号
     * @return {code:1/0,msg:成功/失败}
     */
    @RequestMapping(value = "/initModel", params = {"serial_number", "model_kind", "model_kind_name", "firmware_version", "pcb_version"},method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> initModel(String serial_number, int model_kind, String model_kind_name, String firmware_version, String pcb_version){
        System.out.println("进入插入model新数据");
        Map<String, Object> response = new HashMap<>();

        List<Model_info> modelInfos ;
        modelInfos = model_info_repository.findAll();
        String lastId = String.valueOf(modelInfos.get(modelInfos.size() - 1).getModel_id());
        if (lastId.equals(serial_number)){
            response.put("code", 2);
            response.put("msg", "该模块id已存在");
        }else {
//            long date = Calendar.getInstance().getTimeInMillis();
            Model_info model_info = new Model_info();
//            System.out.println(date);
            try{
                model_info.setModel_date(getTodayDate());
                model_info.setSerial_number(serial_number);
                model_info.setModel_kind(model_kind);
                model_info.setModel_kind_name(model_kind_name);
                model_info.setFirmware_version(firmware_version);
                model_info.setPcb_version(pcb_version);
            }catch (Exception e) {
                System.out.println(e.toString());
            }


            if (model_info_repository.save(model_info) != null){
                response.put("code", 1);
                response.put("msg", "序列号初始成功");
            }else {
                response.put("code", 0);
                response.put("msg", "初始化失败");
            }
        }
        return response;
    }

    private String getTodayDate() {

        SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd" );
        try {
            String date = format.format ( new Date() );
            System.out.println("getTodayDate" + date);
            return date;
        } catch (Exception e) {
            e.printStackTrace ();
            return null;
        }
    }
}
