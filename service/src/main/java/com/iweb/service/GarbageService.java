package com.iweb.service;

import com.iweb.pojo.Garbage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author Chentyit
 * @Date 2019/7/31 08:32
 * @Description:
 */
public interface GarbageService {

    /**
     * 查询所有的垃圾
     * 在数据库中，垃圾表单独使用一列来表示垃圾的类别，该列指向类别的 ID
     * @return 返回垃圾列表
     */
    public List<Garbage> findAllGarbage();

    /**
     * 查询到所有垃圾的分类名称
     * 数据库中 garbage_class_id 为 0 的就是垃圾的根类别（湿垃圾，干垃圾，可回收垃圾，有害垃圾）
     * @return 返回垃圾类别列表
     */
    public List<Garbage> findAllGarClass();

    /**
     * 根据垃圾名称，模糊查询出符合名称的所有垃圾信息
     * @param garName 垃圾名称
     * @return 返回相关垃圾的详细信息
     */
    public Map<String, String> selectGarInfo(String garName);

    /**
     * 根据类别 ID 查询出归属于这个分类下的垃圾
     * @param classId 类别 ID
     * @return 返回查询集合
     */
    public List<Garbage> findGarByClassId(@Param("classId") int classId);

    /**
     * 获取拉结类别以及类别下的所有垃圾的总列表
     * @return 返回统计好的列表
     */
    public Map<String, List<String>> getClassAndGarList();
}
