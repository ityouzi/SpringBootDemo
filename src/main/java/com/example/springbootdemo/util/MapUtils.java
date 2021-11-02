package com.example.springbootdemo.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * map集合工具类
 *
 * @author lizhen created on 2021-10-26 15:04
 * @version 1.0
 */
public class MapUtils {
    public static Map<String, String> sortMapByValue(Map<String, String> oriMap) {
        if (CollectionUtil.isEmpty(oriMap)){
            return null;
        }
        Map<String, String> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<String, String>> entryList = new ArrayList<>(oriMap.entrySet());
        entryList.sort(new MapValueComparator());

        Iterator<Map.Entry<String, String>> iter = entryList.iterator();
        Map.Entry<String, String> tmpEntry;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }
    static class MapValueComparator implements Comparator<Map.Entry<String, String>> {
        // 重写compare 比较key,也可以依据value比较大小
        @Override
        public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
            Integer oo1 = Integer.valueOf(o1.getKey());
            Integer oo2 = Integer.valueOf(o2.getKey());
            return oo1.compareTo(oo2);
        }
    }

    /**
     * 移除值为空的元素
     *
     * @author lizhen
     * @date 2021/10/29-11:59
     * @version 1.0
     */
    public static Map<String, Object> remove(Map<String, Object> map){
        // 第一种
        map.entrySet().removeIf(m->(ObjectUtil.isEmpty(m.getValue())) || StringUtils.isBlank((CharSequence) m.getValue()));
        return map;
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("a", "");
        map.put("b", "   ");
        map.put("c", null);
        map.put("d", "d");
        map.put("e", new ArrayList<>());
        map.put("f", new String[] {});
        map.put("g", new HashMap<>(10));
        Map remove = remove(map);
        System.out.println(remove);
    }
}
