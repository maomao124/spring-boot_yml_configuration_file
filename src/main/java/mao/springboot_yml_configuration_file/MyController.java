package mao.springboot_yml_configuration_file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Project name(项目名称)：spring-boot_yml_configuration_file
 * Package(包名): mao.springboot_yml_configuration_file
 * Class(类名): MyController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/9
 * Time(创建时间)： 22:07
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Controller
public class MyController
{
//    @Value("${author}")
//    private String author;

    @Value("${server.port}")
    private String port;

//    @Value("${subject}")
//    private String[] subject;

    @Autowired
    private Environment environment;

    @Autowired
    private DataSouse datasource;

    @RequestMapping("test")
    @ResponseBody
    public String test(HttpServletResponse response)
    {
        response.setContentType("text/html;charset=UTF-8");
        //return port;
        return "port:" + environment.getProperty("server.port") + "<br>"
                + "driver:" + environment.getProperty("spring.datasource.driver-class-name") + "<br>"
                + "username:" + environment.getProperty("spring.datasource.username");
    }

    @RequestMapping("test1")
    @ResponseBody
    public String test1(HttpServletResponse response)
    {
        response.setContentType("text/html;charset=UTF-8");
        //return port;
        return  datasource.toString();
    }
}
