package com.iweb.controller;

import com.iweb.common.utilobj.GarListOfClazz;
import com.iweb.common.utilmethod.UtilTools;
import com.iweb.common.utilobj.GarOneOfClazz;
import com.iweb.pojo.Garbage;
import com.iweb.pojo.Search;
import com.iweb.service.GarbageService;
import com.iweb.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @Author Chentyit
 * @Date 2019/7/31 08:35
 * @Description:
 */
@Controller
public class GarbageController {

    /**
     * 注入 Garbage 服务层
     */
    @Resource
    private GarbageService garbageService;

    /**
     * 注入 Search 服务层
     */
    @Resource
    private SearchService searchService;

    /**
     * 搜索出所有的垃圾
     *
     * @return 将所有垃圾的参数封装到 json 中返回
     */
    @ResponseBody
    @RequestMapping("/garbage/allGar")
    public List<Garbage> findAllGarbage() {
        return garbageService.findAllGarbage();
    }

    /**
     * 搜索出所有的垃圾类别
     *
     * @return 将垃圾类别封装到 json 中返回
     */
    @ResponseBody
    @RequestMapping("/garbage/allClass")
    public List<Garbage> findAllGarClass() {
        return garbageService.findAllGarClass();
    }

    /**
     * 通过关键字搜索某个垃圾的详细信息
     *
     * @return 返回相关垃圾的详细信息
     */
    @ResponseBody
    @RequestMapping("/garbage/search")
    public List<GarOneOfClazz> findGarInfo(
            @RequestParam("garName") String garName) {
        // 去除首位空格
        garName = garName.trim();
        // 判断 garName 是否有值
        if ("".equals(garName)) {
            return null;
        }
        // 创建一个结果集
        // 用于搜集查询出来的结果
        Map<String, String> garMap = garbageService.selectGarInfo(garName);

        // 将数据库中对应这条搜索记录的次数加一
        searchService.incSearchNumOfGarName(garName);

        // 返回处理的结果集
        return UtilTools.toObjList(garMap);
    }

    /**
     * 根据搜索的次数降序排序输出搜索排行
     *
     * @return 返回搜索排行
     */
    @ResponseBody
    @RequestMapping("/garbage/list")
    public List<Search> getSearchList() {
        return searchService.selectSearchOrderBySearchNum();
    }

    /**
     * 根据类别 ID 查询出归属于这个分类下的垃圾
     *
     * @param garClassId 类别 ID
     * @return 返回查询集合
     */
    @ResponseBody
    @RequestMapping("/garbage/byCId/")
    public List<Garbage> getGarListByClass(
            @RequestParam("garClassId") int garClassId) {
        return garbageService.findGarByClassId(garClassId);
    }

    /**
     * 获取拉结类别以及类别下的所有垃圾的总列表
     *
     * @return 返回统计好的列表
     */
    @ResponseBody
    @RequestMapping("/garbage/allInfoList")
    public List<GarListOfClazz> getClassAndGarList() {
        return UtilTools.mapToList(garbageService.getClassAndGarList());
    }

    /**
     * 接收传递过来的图片
     * 使用百度 AI 图像识别来识别出是什么物品
     * @param request 携带图片信息的请求
     * @return 返回识别出来的名称
     */
    @ResponseBody
    @RequestMapping("/garbage/image")
    public List<GarOneOfClazz> getImage(HttpServletRequest request) throws IOException {

        // 将 request 请求转换为 MultipartHttpServletRequest
        // 用于读取传递过来的文件
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;

        // 获取请求携带过来的文件
        MultipartFile multipartFile = req.getFile("file");

        // 创建 IO 流读取文件
        FileInputStream fis = null;
        ByteArrayOutputStream out = null;

        // 返回识别到的图片名称
        String garName = UtilTools.identifyTheImage(multipartFile.getBytes());

        // 创建一个结果集
        // 用于搜集查询出来的结果
        Map<String, String> garMap = garbageService.selectGarInfo(garName);

        // 将数据库中对应这条搜索记录的次数加一
        searchService.incSearchNumOfGarName(garName);

        // 返回处理的结果集
        return UtilTools.toObjList(garMap);
    }

}
