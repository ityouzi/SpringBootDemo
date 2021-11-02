package com.example.springbootdemo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.springbootdemo.em.IdTypeEnum;
import com.example.springbootdemo.em.IndustryCategoryEnum;
import com.example.springbootdemo.em.PictureFileTypeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhen created on 2021-10-21 17:00
 */
public class test {

    public static Map<String, String> getAll(Integer id){
        Map<String, String> allMap = new HashMap<>();
        if (id == 1){
            for (IdTypeEnum em : IdTypeEnum.values()){
                Map<String, String> map = new HashMap<>();
                map.put(em.getValue(), em.getDesc());
                allMap.putAll(map);
            }
        }
        if (id == 2){
            for (IndustryCategoryEnum em : IndustryCategoryEnum.values()){
                Map<String, String> map = new HashMap<>();
                map.put(em.getValue(), em.getDesc());
                allMap.putAll(map);
            }
        }
        if (id == 3){
            for (PictureFileTypeEnum em : PictureFileTypeEnum.values()){
                Map<String, String> map = new HashMap<>();
                map.put(em.getValue(), em.getDesc());
                allMap.putAll(map);
            }
        }
        return allMap;
    }

    public static void main(String[] args) {
//        Map<String, String> all = getAll(2);
////        List<Map.Entry<String, String>> infoIds = new ArrayList<>(all.entrySet());
////        // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
////        infoIds.sort(Map.Entry.comparingByKey());
//
//        String s = JSON.toJSONString(all);
//        JSONObject jsonObject = JSON.parseObject(s, JSONObject.class);
//        String s1 = JSON.toJSONString(jsonObject, SerializerFeature.MapSortField);



        String a ="{\n" +
                "    \"a\":\"服饰鞋包\",\n" +
                "    \"c\":\"数码家电\",\n" +
                "    \"f\":\"鲜花礼品\",\n" +
                "    \"e\":\"美容护肤\",\n" +
                "    \"x\":\"团购\",\n" +
                "    \"y\":\"机票旅游\",\n" +
                "    \"b\":\"商务办公\",\n" +
                "    \"k\":\"文体用品\"}";
        JSONObject jsonObject1 = JSON.parseObject(a, JSONObject.class);
        String s2 = JSON.toJSONString(jsonObject1, SerializerFeature.MapSortField);
        System.out.println(s2);

    }
}
