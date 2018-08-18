package com.itheima.bos.test;

import com.itheima.bos.utils.PinYin4jUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 17/08/2018
 * Time: 22:57
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Pinyin4JTest {


    @Test
    public void test1() {


        String province = "河北省";
        String city = "石家庄市";
        String district = "桥西区";

        province = province.substring(0, province.length() - 1);
        city = city.substring(0, city.length() - 1);
        district = district.substring(0, district.length() - 1);

        String info = province + city + district;

        System.out.println(info);

        String[] headByString = PinYin4jUtils.getHeadByString(info);

        String join = StringUtils.join(headByString);

        System.out.println(join);

        System.out.println(PinYin4jUtils.hanziToPinyin("周磊"));
    }
}