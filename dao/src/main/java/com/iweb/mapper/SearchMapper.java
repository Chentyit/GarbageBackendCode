package com.iweb.mapper;

import com.iweb.pojo.Search;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Chentyit
 * @Date 2019/7/31 14:54
 * @Description: Dao 层 Search 接口
 */
public interface SearchMapper {

    /**
     * 搜索记录列表里面没有记录过该垃圾
     * @param garName 某个垃圾的名字
     * @return 返回增加是否成功标志
     */
    public Search findRecordByGarName(@Param("garName") String garName);

    /**
     * 向数据库中添加该垃圾名称
     * @param garName 某个垃圾名称
     * @return 返回增加是否成功标志
     */
    public boolean addSearchName(@Param("garName") String garName);

    /**
     * 搜索记录次数加一
     * @param garName 某个垃圾的名字
     * @return 返回增加是否成功标志
     */
    public boolean incSearchNum(@Param("garName") String garName);

    /**
     * 根据搜索的次数降序排序输出搜索排行
     * @return 返回搜索排行
     */
    public List<Search> selectSearchOrderBySearchNum();
}
