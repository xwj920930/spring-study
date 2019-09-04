package com.xwj.springmvc;

import com.xwj.entity.People;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/3 17:29
 * @Version 1.0
 **/
@Controller
@RequestMapping("/load")
public class LoadController {
    @RequestMapping("/jsp")
    public String upJsp(){
        return "load";
    }
    //下载ie有问题，Google没问题
    @RequestMapping(value = "/down")
    public ResponseEntity<byte[]> download() throws IOException {
        File file=new File("D:\\工作\\project\\SpringWebTest\\web\\resource\\file\\test.txt");
        HttpHeaders headers=new HttpHeaders();
        String fileName=new String("test.txt".getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment",fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }
    //produces用于返回中文，但是不要application/json会报错，其实它的作用@ResponseBody已经包含
    @RequestMapping(value = "/up",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName=file.getOriginalFilename();
        if(file.getSize()>0){
            file.transferTo(new File("D:\\工作\\project\\SpringWebTest\\web\\resource\\file",fileName));
            return "上传成功";
        }else {
            return "上传失败";
        }
    }
}
