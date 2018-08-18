package com.itheima.bos.service;

import com.itheima.bos.domain.Region;
import com.itheima.bos.utils.PageBean;

import java.util.List;

public interface IRegionService {
    void saveBatch(List<Region> regionList);

    void pageQuery(PageBean pageBean);
}
