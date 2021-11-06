package com.example.springbootdemo.util;

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
//        Double a = new Double(8000.98000);
//        Student student = new Student("张三",a);
//
//        System.out.println(JSON.toJSONString(student));
//
//        System.out.println(BigDecimal.valueOf(a));

        String a = "MERCHANT_TYPE_(\"100\",\"实物d\n" +
                "MERCHANT_TYPE_(\"110\",\"综合商城d\n" +
                "MERCHANT_TYPE_(\"111\",\"超市（线下）d\n" +
                "MERCHANT_TYPE_(\"121\",\"服饰类商城/服饰配件/箱包d\n" +
                "MERCHANT_TYPE_(\"122\",\"礼品/鲜花/纪念品d\n" +
                "MERCHANT_TYPE_(\"123\",\"户外/运动/健身器材/安防d\n" +
                "MERCHANT_TYPE_(\"124\",\"乐器d\n" +
                "MERCHANT_TYPE_(\"125\",\"手表/钟表/眼睛（美瞳）d\n" +
                "MERCHANT_TYPE_(\"126\",\"黄金珠宝/钻石/玉石d\n" +
                "MERCHANT_TYPE_(\"127\",\"首饰/饰品d\n" +
                "MERCHANT_TYPE_(\"128\",\"装饰/设计d\n" +
                "MERCHANT_TYPE_(\"131\",\"家居/建材/装饰/布艺类商城d\n" +
                "MERCHANT_TYPE_(\"132\",\"食品d\n" +
                "MERCHANT_TYPE_(\"133\",\"保健品/滋补品d\n" +
                "MERCHANT_TYPE_(\"134\",\"家用电器d\n" +
                "MERCHANT_TYPE_(\"135\",\"成人计生用品d\n" +
                "MERCHANT_TYPE_(\"136\",\"美妆/护肤/个人护理d\n" +
                "MERCHANT_TYPE_(\"137\",\"工艺品/盆栽/室内装饰品d\n" +
                "MERCHANT_TYPE_(\"138\",\"汽车/摩托/自行车/配件/改装d\n" +
                "MERCHANT_TYPE_(\"139\",\"餐饮d\n" +
                "MERCHANT_TYPE_(\"141\",\"数码产品d\n" +
                "MERCHANT_TYPE_(\"142\",\"办公设备（打印机/复印机/扫描仪等）d\n" +
                "MERCHANT_TYPE_(\"150\",\"母婴/玩具d\n" +
                "MERCHANT_TYPE_(\"154\",\"培训教育d\n" +
                "MERCHANT_TYPE_(\"155\",\"医药d\n" +
                "MERCHANT_TYPE_(\"156\",\"摄影d\n" +
                "MERCHANT_TYPE_(\"161\",\"影票/演唱会/赛事等娱乐票务d\n" +
                "MERCHANT_TYPE_(\"162\",\"火车票/船票/车票等长途交通票务d\n" +
                "MERCHANT_TYPE_(\"170\",\"票务/机票/旅游d\n" +
                "MERCHANT_TYPE_(\"171\",\"旅行社d\n" +
                "MERCHANT_TYPE_(\"172\",\"旅游服务平台d\n" +
                "MERCHANT_TYPE_(\"173\",\"交通运输服务类d\n" +
                "MERCHANT_TYPE_(\"175\",\"旅馆/酒店/景区/度假区d\n" +
                "MERCHANT_TYPE_(\"180\",\"书籍/音像/文具d\n" +
                "MERCHANT_TYPE_(\"190\",\"收藏/宠物/文物/非文物d\n" +
                "MERCHANT_TYPE_(\"210\",\"彩票d\n" +
                "MERCHANT_TYPE_(\"220\",\"生活/咨询服务d\n" +
                "MERCHANT_TYPE_(\"221\",\"人才中介机构/招聘/猎头d\n" +
                "MERCHANT_TYPE_(\"222\",\"婚庆/婚介d\n" +
                "MERCHANT_TYPE_(\"223\",\"网上生活服务平台d\n" +
                "MERCHANT_TYPE_(\"230\",\"金融d\n" +
                "MERCHANT_TYPE_(\"240\",\"保险/保险公司d\n" +
                "MERCHANT_TYPE_(\"250\",\"公益d\n" +
                "MERCHANT_TYPE_(\"260\",\"网络虚拟服务/软件/彩铃d\n" +
                "MERCHANT_TYPE_(\"263\",\"机械设备/电子d\n" +
                "MERCHANT_TYPE_(\"265\",\"通信/宽带/话费充值d\n" +
                "MERCHANT_TYPE_(\"280\",\"娱乐/健身服务d\n" +
                "MERCHANT_TYPE_(\"290\",\"苗木/绿化/化肥d\n" +
                "MERCHANT_TYPE_(\"291\",\"快递/货运服务d\n" +
                "MERCHANT_TYPE_(\"292\",\"水电煤缴费/交通罚款等生活缴费d\n" +
                "MERCHANT_TYPE_(\"293\",\"公立医院d\n" +
                "MERCHANT_TYPE_(\"294\",\"民办院校（中学/小学/幼儿园）d\n" +
                "MERCHANT_TYPE_(\"295\",\"挂号平台d\n" +
                "MERCHANT_TYPE_(\"296\",\"公立院校d\n" +
                "MERCHANT_TYPE_(\"297\",\"停车缴费d\n" +
                "MERCHANT_TYPE_(\"298\",\"事业单位d\n" +
                "MERCHANT_TYPE_(\"299\",\"物业管理费d\n" +
                "MERCHANT_TYPE_(\"300\",\"其他生活缴费d\n" +
                "MERCHANT_TYPE_(\"301\",\"教育/培训/考试缴费/学费d\n" +
                "MERCHANT_TYPE_(\"302\",\"私立院校d\n" +
                "MERCHANT_TYPE_(\"303\",\"诊所/卫生站/卫生服务中心d\n" +
                "MERCHANT_TYPE_(\"304\",\"咨询/法律咨询/金融咨询等d\n" +
                "MERCHANT_TYPE_(\"305\",\"宗教d\n" +
                "MERCHANT_TYPE_(\"310\",\"[个体户]美妆/护肤/个人护理d\n";
        List<String> d = Arrays.asList(a.split("d"));
        for (int i=0; i<d.size(); i++){
            String s = d.get(i);
            String ss = s.replace("MERCHANT_TYPE_", "MERCHANT_TYPE_" + i);
            System.out.println(ss+"g");
        }
    }

}
