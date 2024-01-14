package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;

import java.util.List;

public interface AreaDao {
    List<Area> queryArea();     //列出区域列表
    Area queryAreaById(int areaid);     //根据ID列出具体区域
    int insertArea(Area area);      //插入区域信息
    int updateArea(Area area);      //更新区域信息
    int deleteArea(int areaId);     //删除区域信息
}
