package com.example.springbootdemo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author lizhen created on 2021-10-22 14:16
 */
@Slf4j
public class SimpleApp {

    //判断该对象是否: 返回ture表示所有属性为null  返回false表示不是所有属性都是null
    public static boolean isAllFieldNull(Object obj) throws IllegalAccessException {
        Class<?> aClass = obj.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        boolean flag = true;
        for (Field f : declaredFields){
            f.setAccessible(true);
            Object o = f.get(obj);
            if (o != null){
                flag = false;
            }
        }
        return flag;
    }

    public static Map<String, String> sortMapByValue(Map<String, String> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        List<Map.Entry<String, String>> entryList = new ArrayList<Map.Entry<String, String>>(
                oriMap.entrySet());
        entryList.sort(new MapValueComparator());

        Iterator<Map.Entry<String, String>> iter = entryList.iterator();
        Map.Entry<String, String> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }
    static class MapValueComparator implements Comparator<Map.Entry<String, String>> {
//        @Override
//        public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
//            return o1.getValue().compareTo(o2.getValue());
//        }

        @Override
        public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
            Integer oo1 = Integer.valueOf(o1.getKey());
            Integer oo2 = Integer.valueOf(o2.getKey());
            return oo1.compareTo(oo2);
        }
    }

    public static void main(String[] args) {

        String a = "\n" +
                "可点击key和value值进行编辑\n" +
                "{\n" +
                "    \"sign\":\"ftP/1O6AjHbCpt9J3cthu4aFsvgh46y3jDJQJCdKOUm5KGrsxQRAE1A8+7kHYAvbieIp8z+DQ/uHS+NCjExQTMapu0L95bpcJjf/v8fq/3rNfthGKELDIndepkWeRdb8jW5K53jKE77qIYGQu84JKlrJPZGupCHD/O0phn6ffXY=\",\n" +
                "    \"ysepay_merchant_register_token_get_response\":{\n" +
                "        \"code\":\"10000\",\n" +
                "        \"msg\":\"Success\",\n" +
                "        \"token\":\"TK20211027155522124BRSoOUUD\",\n" +
                "        \"token_status\":\"TOKEN_GET_SUCCESS\"\n" +
                "    }\n";

        JSONObject jsonObject = JSON.parseObject(a, JSONObject.class);
        System.out.println(jsonObject.get("token"));
    }

}
