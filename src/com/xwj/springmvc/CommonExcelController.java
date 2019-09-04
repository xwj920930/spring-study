package com.xwj.springmvc;

import com.xwj.entity.People;
import org.apache.poi.hssf.record.StyleRecord;
import org.apache.poi.hssf.record.VCenterRecord;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/3 17:29
 * @Version 1.0
 **/
@Controller
@RequestMapping("/excel")
public class CommonExcelController {
    @ResponseBody
    @RequestMapping(value = "/download")
    //下载文件不能用ajax，应该用表单或者跳转
    public String down(People people, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.reset();
        httpServletResponse.setContentType("application/msexcel");
        httpServletResponse.setHeader("Content-Disposition","attachment;filename="+new String("用户列表".getBytes(),"iso8859-1")+".xls");
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet();
        HSSFRow title=sheet.createRow(0);
        title.createCell(0).setCellValue("标题");
        HSSFRow comment=sheet.createRow(1);
        comment.createCell(0).setCellValue("备注");
        HSSFRow header=sheet.createRow(2);
        header.createCell(0).setCellValue("header1");
        header.createCell(1).setCellValue("header2");
        header.createCell(2).setCellValue("header3");
        HSSFRow data=sheet.createRow(3);
        data.createCell(0).setCellValue("数据1");
        data.createCell(1).setCellValue("数据2");
        data.createCell(2).setCellValue("数据3");
        OutputStream os=httpServletResponse.getOutputStream();
        workbook.write(os);
        os.flush();
        return "ok";
    }
    @RequestMapping(value = "/commonjsp")
    public String jsp(){
        return "excel";
    }
}
