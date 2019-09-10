package com.iweb.service;

import com.iweb.pojo.Search;

import java.util.List;

/**
 * @Author Chentyit
 * @Date 2019/7/31 16:41
 * @Description: 搜索表 Service 层
 */
public interface SearchService {

    /**
     * 1. 先查找搜索表中是否有相关的垃圾名称
     * 2. 如果找不到就向数据库里面添加一条记录并赋初值 0
     * 3. 如果找到了，就在对应的数据搜索次数加一
     * @param garName 垃圾名称
     * @return 返回搜索次数
     */
    public long incSearchNumOfGarName(String garName);

    /**
     * 根据搜索的次数降序排序输出搜索排行
     * @return 返回搜索排行
     */
    public List<Search> selectSearchOrderBySearchNum();
}
