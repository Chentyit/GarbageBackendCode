package com.iweb.common.ai;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @Author Chentyit
 * @Date 2019/8/9 18:47
 * @Description:
 */
public class AiImageIdentification {

    /**
     * 设置 APPID / AK /SK
     * 可以先使用我的
     */
    public static final String APP_ID = "16986172";
    public static final String API_KEY = "DirgkQx5FBCkOplCCoyC7Cgy";
    public static final String SECRET_KEY = "4CxEc1NWdOotRZgrO0EydD42Borbuntm";

    private static AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

    public static AipImageClassify getInstance() {
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        return client;
    }

    /**
     * 百度 AI 接口测试
     */
//    public static void main(String[] args) {
//        // 初始化一个AipImageClassify
//        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
//
//        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);
//
//        // 传入可选参数调用接口
//        HashMap<String, String> options = new HashMap<String, String>();
//        options.put("top_num", "1");
//        options.put("baike_num", "1");
//
//        // 调用接口
//        String path = "E:\\test\\timg.jfif";
//        JSONObject res = client.advancedGeneral(path, options);
//        JSONArray list = res.getJSONArray("result");
//        JSONObject perInfo = list.getJSONObject(0);
//        System.out.println(perInfo.getString("keyword"));
//    }
}
