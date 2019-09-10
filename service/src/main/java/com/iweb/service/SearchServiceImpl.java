package com.iweb.service;

import com.iweb.mapper.SearchMapper;
import com.iweb.pojo.Search;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Chentyit
 * @Date 2019/7/31 16:42
 * @Description: 搜索表服务层实现类
 */
@Service
public class SearchServiceImpl implements SearchService {

    /**
     * 注入 SearchMapper
     * 可以直接使用 SearchMapper 实例
     * 可以直接调用 SearchMapper 的方法
     */
    @Resource
    private SearchMapper searchMapper;

    /**
     * 1. 先查找搜索表中是否有相关的垃圾名称
     * 2. 如果找不到就向数据库里面添加一条记录并赋初值 0
     * 3. 如果找到了，就在对应的数据搜索次数加一
     * @param garName 垃圾名称
     * @return 返回搜索次数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public long incSearchNumOfGarName(String garName) {
        // 先搜数据库中是否存在这条记录
        Search search = searchMapper.findRecordByGarName(garName);

        // 如果搜索记录为空
        if (search == null) {
            // 先向数据库中添加该记录
            boolean addFlag = searchMapper.addSearchName(garName);
            // 判断是否添加成功
            if (addFlag) {
                // 获取当前记录
                search = searchMapper.findRecordByGarName(garName);
                // 返回当前记录被搜索次数
                return search.getSearchNum();
            }
        }

        // 如果数据库中存在该搜索记录就直接加一
        searchMapper.incSearchNum(garName);
        // 获取当前记录
        search = searchMapper.findRecordByGarName(garName);
        // 返回当前记录被搜索次数
        return search.getSearchNum();
    }

    /**
     * 根据搜索的次数降序排序输出搜索排行
     * @return 返回搜索排行
     */
    @Override
    public List<Search> selectSearchOrderBySearchNum() {
        return searchMapper.selectSearchOrderBySearchNum();
    }
}
