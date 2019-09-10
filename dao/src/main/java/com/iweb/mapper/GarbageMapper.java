package com.iweb.mapper;

import com.iweb.pojo.Garbage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Chentyit
 * @Date 2019/7/30 23:13
 * @Description: Dao 层 Garbage 接口
 */
public interface GarbageMapper {

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
     * 根据类别 ID 查询出归属于这个分类下的垃圾
     * @param classId 类别 ID
     * @return 返回查询集合
     */
    public List<Garbage> findGarByClassId(@Param("classId") int classId);

    /**
     * 根据垃圾类别的 ID 查询出垃圾类别的名称
     * @param classId 垃圾类别 ID
     * @return 返回垃圾类别名称
     */
    public String findGarClassNameByClassId(@Param("classId") int classId);

    /**
     * 根据垃圾名称，模糊查询出符合名称的所有垃圾
     * @param garName 垃圾名称
     * @return 返回符合条件的垃圾集合
     */
    public List<Garbage> findGarByGarName(@Param("garName") String garName);

    /**
     * 添加垃圾名称，当搜索的垃圾不存在时自动添加（分类暂时归于未分类）
     * @param garName 垃圾名称
     * @return 返回是否添加成功
     */
    public boolean addGarbage(@Param("garName") String garName);
}
