package com.xwj.springmvc;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/8/30 9:20
 * @Version 1.0
 **/
@Test
public class RestTemplateTest {
    @Test
    public void test(){
        RestTemplate template=new RestTemplate();
        MultiValueMap<String,String> form=new LinkedMultiValueMap<>();
        form.add("userName","xwj");
        form.add("passWord","123123");
        template.postForLocation("http://localhost:8080/people/json1",form);
    }
}
