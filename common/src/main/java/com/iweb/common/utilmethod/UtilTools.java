package com.iweb.common.utilmethod;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.iweb.common.ai.AiImageIdentification;
import com.iweb.common.utilobj.GarListOfClazz;
import com.iweb.common.utilobj.GarOneOfClazz;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Chentyit
 * @Date 2019/8/6 21:59
 * @Description: 工具类（全都是静态方法直接调用）
 */
public class UtilTools {

    /**
     * 将复杂的 List<Map<String, List<String>>> 映射为 List 集合
     * 使用一个对象对复杂数据进行封装
     * 一步简化
     *
     * @param map 存放简化后的数据集合
     * @return
     */
    public static List<GarListOfClazz> mapToList(Map<String, List<String>> map) {
        // 创建一个集合收集简化后的数据
        List<GarListOfClazz> gocList = new ArrayList<>();

        // 遍历 Map 数据集合
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            // 创建一个临时对象进行映射
            GarListOfClazz goc = new GarListOfClazz();
            goc.setClaName(entry.getKey());
            goc.setGarNameList(entry.getValue());
            // 将对象存储来将要返回的集合中
            gocList.add(goc);
        }

        return gocList;
    }

    /**
     * 将原有的数据格式 {"熟料瓶": "可回收垃圾"}
     * 更改成 {garName: "熟料瓶", claName: "可回收垃圾"}
     *
     * @param map 待更改的列表
     * @return 返回已更改的列表
     */
    public static List<GarOneOfClazz> toObjList(Map<String, String> map) {
        // 创建一个列表存放最后的数据
        List<GarOneOfClazz> result = new ArrayList<>();

        // 使用 Entry 对 Map 进行遍历
        for (Map.Entry<String, String> entry : map.entrySet()) {
            // 创建一个临时对象进行映射
            GarOneOfClazz gooc = new GarOneOfClazz();
            gooc.setGarName(entry.getKey());
            gooc.setClaName(entry.getValue());
            result.add(gooc);
        }
        return result;
    }

    /**
     * 将获取到的图片上传到百度 AI 图像识别
     *
     * @param bytes 存储图片的字节数组
     * @return 返回识别到的图片名称
     */
    public static String identifyTheImage(byte[] bytes) {
        // 获取到一个百度 AI 客户端
        AipImageClassify client = AiImageIdentification.getInstance();

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("top_num", "1");
        options.put("baike_num", "1");

        // 调用接口
        JSONObject res = client.advancedGeneral(bytes, options);

        // 解析出需要的结果
        JSONArray list = res.getJSONArray("result");
        JSONObject perInfo = list.getJSONObject(0);

        // 返回识别出来的名称
        return perInfo.getString("keyword");
    }
}
