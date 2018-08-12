package com.itheima.bos.web.action;

import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.utils.BOSUtils;
import com.itheima.bos.utils.PageBean;
import com.itheima.bos.web.action.base.BaseAction;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 12/08/2018
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 * Description:
 */

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction <Staff> {
    @Autowired
    private IStaffService staffService;

    public int page;
    public int rows;

    public String add() {
        model.setDeltag("0");

        staffService.save(model);
        return LIST;
    }

    public String pageQuery() throws IOException {
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(rows);

        System.out.println(page + "  :  " + rows);

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);

        pageBean.setDetachedCriteria(detachedCriteria);
        System.out.println("yichagn");
        staffService.pageQuery(pageBean);
        System.out.println(pageBean);


        JSONObject jsonObject = JSONObject.fromObject(pageBean);


        String json = jsonObject.toString();


        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");

        ServletActionContext.getResponse().getWriter().write(json);


        return NONE;
    }

    public String ids;

    public String deleteBatch() {
        System.out.println(ids);

        staffService.deleteBatch(ids);
        return LIST;
    }


    public String edit() {

        Staff staff = staffService.findById(model.getId());

        staff.setName(model.getName());

        staff.setTelephone(model.getTelephone());

        staff.setHaspda(model.getHaspda());

        staff.setStandard(model.getStandard());


        staffService.update(staff);
        return LIST;

    }
}