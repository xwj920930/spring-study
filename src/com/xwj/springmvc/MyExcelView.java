package com.xwj.springmvc;

import com.xwj.entity.People;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/5 16:17
 * @Version 1.0
 **/
public class MyExcelView extends AbstractExcelView{
    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook hssfWorkbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Content-Disposition","inline;filename="+new String("用户列表".getBytes(),"iso8859-1"));
        List<People> list= (List<People>) map.get("people");
        HSSFSheet sheet=hssfWorkbook.createSheet("peoples");
        HSSFRow header=sheet.createRow(0);
        header.createCell(0).setCellValue("姓名");
        header.createCell(1).setCellValue("密码");
        header.createCell(2).setCellValue("时间");
        int rowNum=1;
        for (People people : list) {
            HSSFRow row=sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(people.getUserName());
            row.createCell(1).setCellValue(people.getPassWord());
            row.createCell(2).setCellValue(people.getTime());
        }
    }
}
