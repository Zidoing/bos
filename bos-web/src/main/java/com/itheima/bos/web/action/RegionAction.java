package com.itheima.bos.web.action;

import com.itheima.bos.domain.Region;
import com.itheima.bos.service.IRegionService;
import com.itheima.bos.utils.PageBean;
import com.itheima.bos.utils.PinYin4jUtils;
import com.itheima.bos.web.action.base.BaseAction;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 17/08/2018
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Controller
@Scope("prototype")
public class RegionAction extends BaseAction <Region> {

    private File regionFile;
    @Autowired
    private IRegionService regionService;

    public void setRegionFile(File regionFile) {
        this.regionFile = regionFile;
    }

    public String importXls() throws IOException {

        List <Region> regionList = new ArrayList <>();

        System.out.println(regionFile);

        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(regionFile));

        HSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            int rowNum = row.getRowNum();
            if (rowNum == 0) {
                continue;
            }

            String id = row.getCell(0).getStringCellValue();
            String province = row.getCell(1).getStringCellValue();
            String city = row.getCell(2).getStringCellValue();
            String district = row.getCell(3).getStringCellValue();
            String postcode = row.getCell(4).getStringCellValue();

            Region region = new Region(id, province, city, district, postcode, null, null, null);

            province = province.substring(0, province.length() - 1);
            city = city.substring(0, city.length() - 1);
            district = district.substring(0, district.length() - 1);

            String info = province + city + district;

            System.out.println(info);

            String[] headByString = PinYin4jUtils.getHeadByString(info);

            String join = StringUtils.join(headByString);

            String citycode = PinYin4jUtils.hanziToPinyin(city, "");


            region.setShortcode(join);
            region.setCitycode(citycode);
            regionList.add(region);

        }

        regionService.saveBatch(regionList);


        return NONE;
    }


    public String pageQuery() throws IOException {

        regionService.pageQuery(pageBean);

        String s = JSONObject.fromObject(pageBean).toString();

        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(s);

        return NONE;
    }
}