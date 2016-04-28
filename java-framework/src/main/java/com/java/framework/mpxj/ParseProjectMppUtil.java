package com.java.framework.mpxj;

import net.sf.mpxj.*;
import net.sf.mpxj.MPXJException;
import net.sf.mpxj.Resource;
import net.sf.mpxj.ResourceAssignment;
import net.sf.mpxj.Task;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.mpp.MPPReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ryan Xu on 2016/4/24.
 */
public class ParseProjectMppUtil {


    /**
     * 解析Microsoft Project Mpp 文件
     * @param mppfile Microsoft Project Mpp 文件
     * @return list
     */
    public static List<Map<String,Object>> psrseProjectFile(File mppfile){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        MPPReader reader = new MPPReader();
        ProjectFile projectFile;
        try{
            projectFile = reader.read(mppfile);
            List<Task> taskList = projectFile.getAllTasks();
            for(Task task : taskList){
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("id",task.getID());
                map.put("taskName",task.getName());
                map.put("startDate",task.getStart());
                map.put("endDate",task.getFinish());
                map.put("beforeTask",getBeforeTaskId(task));//获得前置任务的行号
                map.put("resource",getResources(task));     //获得资源
                list.add(map);
            }
        }catch(MPXJException e ){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取前置任务字段的值
     * @param task
     * @return
     */
    private static String  getBeforeTaskId(Task task){
        StringBuffer beforeTaskId = new StringBuffer();
        if(task!=null){
            List<Relation> list = task.getPredecessors();
            if(list != null ){
                if(list.size()>0){
                    for(int i=0; i<list.size(); i++){
                        Relation relation = (Relation)list.get(i);
                        beforeTaskId.append(relation.getTargetTask().getID());
                    }
                }
            }
        }
        return beforeTaskId.toString();
    }

    /**
     * 获取任务的资源信息
     * @param task
     * @return
     */
    private static String getResources(Task task){
        if(task == null){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        List<ResourceAssignment> assignments = task.getResourceAssignments();
        for(ResourceAssignment ra : assignments){
            Resource resource = ra.getResource();
            if(resource != null){
                sb = sb.append(resource.getName());
            }
        }
        return sb.toString();
    }
}
