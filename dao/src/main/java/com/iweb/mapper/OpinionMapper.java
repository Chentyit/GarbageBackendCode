package com.iweb.mapper;

import com.iweb.pojo.Opinion;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Chentyit
 * @Date 2019/8/10 18:14
 * @Description: Dao 层 Opinion 接口
 */
public interface OpinionMapper {

    /**
     * 添加意见
     * @param opinion
     * @return
     */
    public boolean insertOpinion(@Param("opinion") Opinion opinion);

    /**
     * 根据 ID 查询意见
     * @param opId 意见 ID
     * @return 返回搜索到的意见
     */
    public Opinion findOpinionById(@Param("opId") int opId);

    /**
     * 根据 ID 删除意见
     * @param opId 意见 ID
     * @return 返回删除结果
     */
    public boolean deleteOpinionById(@Param("opId") int opId);
}
