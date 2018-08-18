package com.itheima.bos.test;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 17/08/2018
 * Time: 22:17
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class POITest {


    @Test
    public void test1() throws IOException {

        String filePath = "/Users/zhoulei/IdeaProjects/bosparent/bos-web/src/main/resources/区域导入测试数据.xls";
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePath));

        HSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            for (Cell cell : row) {
                System.out.print(cell.getStringCellValue() + " ");
            }

            System.out.println("");
        }


    }
}