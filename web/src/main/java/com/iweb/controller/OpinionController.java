package com.iweb.controller;

import com.iweb.pojo.Opinion;
import com.iweb.service.OpinionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Chentyit
 * @Date 2019/8/10 18:31
 * @Description: Opinion 的控制层
 */
@RestController
public class OpinionController {

    /**
     * 注入 opinionService 以便使用方法
     */
    @Resource
    private OpinionService opinionService;

    /**
     * 向后台添加用户提交的意见
     * @param opDate 意见日期
     * @param opAddress 意见地址
     * @param opContent 意见内容
     * @return 返回添加结果信息
     */
    @RequestMapping("/opinion/addOp")
    public boolean addOpinion(
            @RequestParam("opDate") String opDate,
            @RequestParam("opAddress") String opAddress,
            @RequestParam("opContent") String opContent) {
        // 创建一个对象存储数据
        Opinion opinion = new Opinion();
        opinion.setOpDate(opDate);
        opinion.setOpAddress(opAddress);
        opinion.setOpContent(opContent);

        // 向后台提交数据
        return opinionService.insertOpinion(opinion);
    }

    /**
     * 通过意见的 ID 查询意见信息
     * @param opId 意见的 ID
     * @return 返回查询到的意见信息
     */
    @RequestMapping("/opinion/search")
    public Opinion searchOpinion(@RequestParam("opId") int opId) {
        return opinionService.findOpinionById(opId);
    }

    /**
     * 通过意见的 ID 删除意见信息
     * @param opId 意见的 ID
     * @return 返回删除意见结果
     */
    @RequestMapping("/opinion/del")
    public boolean delOpinion(@RequestParam("opId") int opId) {
        return opinionService.deleteOpinionById(opId);
    }
}
