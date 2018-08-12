package com.itheima.bos.service.impl;

import com.itheima.bos.dao.IStaffDao;
import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 12/08/2018
 * Time: 12:01
 * To change this template use File | Settings | File Templates.
 * Description:
 */


@Service
@Transactional
public class IStaffServiceImpl implements IStaffService {

    @Autowired
    private IStaffDao staffDao;

    @Override
    public void save(Staff model) {
        staffDao.save(model);

    }

    @Override
    public void pageQuery(PageBean pageBean) {
        staffDao.pageQuery(pageBean);

    }

    @Override
    public void deleteBatch(String ids) {
        if (StringUtils.isNoneBlank(ids)) {
            String[] staffIds = ids.split(",");
            for (String staffId : staffIds) {
                staffDao.executeUpdate("staff.delete", staffId);
            }
        }
    }

    @Override
    public Staff findById(String id) {
        return staffDao.findById(id);
    }

    @Override
    public void update(Staff staff) {
        staffDao.update(staff);
    }
}