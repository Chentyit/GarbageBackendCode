package com.iweb.service;

import com.iweb.mapper.GarbageMapper;
import com.iweb.pojo.Garbage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author Chentyit
 * @Date 2019/7/31 08:33
 * @Description:
 */
@Service
public class GarbageServiceImpl implements GarbageService {

    @Resource
    private GarbageMapper garbageMapper;

    /**
     * 查询所有的垃圾
     * 在数据库中，垃圾表单独使用一列来表示垃圾的类别，该列指向类别的 ID
     *
     * @return 返回垃圾列表
     */
    @Override
    public List<Garbage> findAllGarbage() {
        return garbageMapper.findAllGarbage();
    }

    /**
     * 查询到所有垃圾的分类名称
     * 数据库中 garbage_class_id 为 0 的就是垃圾的根类别（湿垃圾，干垃圾，可回收垃圾，有害垃圾）
     *
     * @return 返回垃圾类别列表
     */
    @Override
    public List<Garbage> findAllGarClass() {
        return garbageMapper.findAllGarClass();
    }

    /**
     * 根据垃圾名称，模糊查询出符合名称的所有垃圾信息
     *
     * @param garName 垃圾名称
     * @return 返回相关垃圾的详细信息
     */
    @Override
    public Map<String, String> selectGarInfo(String garName) {
        // 创建一个结果集
        // 用于搜集查询出来的结果
        Map<String, String> resultMap = new HashMap<>(16);

        // 获取符合条件的垃圾列表
        List<Garbage> garbageList = garbageMapper.findGarByGarName(garName);
        // 如果没找到就先向垃圾表中添加一条数据（暂时标记为未分类）
        if (garbageList.size() == 0) {
            // 在垃圾表中添加一条数据（分类标志为 -1，代表暂时没有归入任何分类）
            garbageMapper.addGarbage(garName);
            // 再查一遍获取到更新值
            garbageList = garbageMapper.findGarByGarName(garName);
        }

        // 搜索 “垃圾” 结果会有问题 ———— 待解决
        // 如果用户输出的不是垃圾名称而是垃圾类别的名称（干垃圾，湿垃圾，有害垃圾，可回收垃圾）
        if (garbageList.get(0).getgClassId() == 0) {
            int garClaId = garbageList.get(0).getgId();
            garbageList.clear();
            garbageList = garbageMapper.findGarByClassId(garClaId);
        }

        // 搜索出列表中每个垃圾归属的类别
        for (Garbage gar : garbageList) {
            String garClassName = garbageMapper.findGarClassNameByClassId(gar.getgClassId());
            resultMap.put(gar.getgName(), garClassName);
        }

        // 返回处理的结果集
        return resultMap;
    }

    /**
     * 根据类别 ID 查询出归属于这个分类下的垃圾
     *
     * @param classId 类别 ID
     * @return 返回查询集合
     */
    @Override
    public List<Garbage> findGarByClassId(int classId) {
        if (classId == 0) {
            return null;
        }
        return garbageMapper.findGarByClassId(classId);
    }

    /**
     * 获取垃圾类别以及类别下的所有垃圾的总列表
     *
     * @return 返回统计好的列表
     */
    @Override
    public Map<String, List<String>> getClassAndGarList() {

        // 创建一个集合用于搜集所有的垃圾
        Map<String, List<String>> resultMap = new HashMap<>(16);

        // 先获取所有类别
        List<Garbage> clazzList = garbageMapper.findAllGarClass();

        // 遍历所有的垃圾类别获取到每个类别下的所有垃圾
        // 使用迭代器遍历类别 list
        for (Garbage garCla : clazzList) {
            // 获取每个类别
            // 创建一个 List 存放查询出来的垃圾名称
            List<String> garNamelist = new ArrayList<>();
            // 创建一个迭代器获取每个垃圾
            // 遍历迭代器存储每个值
            for (Garbage garbage : garbageMapper.findGarByClassId(garCla.getgId())) {
                garNamelist.add(garbage.getgName());
            }
            // 将名称列表存放到 garListOfCla 中
            // 记录该类别下所有的垃圾
            resultMap.put(garCla.getgName(), garNamelist);
        }

        return resultMap;
    }
}
