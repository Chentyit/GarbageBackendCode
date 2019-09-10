package com.iweb.service;

import com.iweb.mapper.OpinionMapper;
import com.iweb.pojo.Opinion;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Chentyit
 * @Date 2019/8/10 18:29
 * @Description: 用于对意见表进行操作
 */
@Service
public class OpinionServiceImpl implements OpinionService {

    @Resource
    private OpinionMapper opinionMapper;

    /**
     * 添加意见
     * @param opinion
     * @return
     */
    @Override
    public boolean insertOpinion(Opinion opinion) {
        return opinionMapper.insertOpinion(opinion);
    }

    /**
     * 根据 ID 查询意见
     * @param opId 意见 ID
     * @return 返回搜索到的意见
     */
    @Override
    public Opinion findOpinionById(int opId) {
        return opinionMapper.findOpinionById(opId);
    }

    /**
     * 根据 ID 删除意见
     * @param opId 意见 ID
     * @return 返回删除结果
     */
    @Override
    public boolean deleteOpinionById(int opId) {
        return opinionMapper.deleteOpinionById(opId);
    }
}
