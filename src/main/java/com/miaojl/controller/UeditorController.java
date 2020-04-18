package com.miaojl.controller;

import com.baidu.ueditor.ActionEnter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("ueditor")
public class UeditorController {

    @Value("${realPath}")
    private String realPath;
    @Value("${path}")
    private String path;
    /*
    *
    * 富文本编辑器的统一请求接口
    * */
    @RequestMapping
    public String execute(String action, HttpServletRequest request, MultipartFile upfile){
        String result = null;

        if("config".equals(action)){//富文本编辑器初始化后会自动请求访问统一接口action=config，返回配置json

            String rootPath = request.getServletContext().getRealPath( "/" );

            //调用ueditorapi读取config.json，转换成json字符串
            result = new ActionEnter( request, rootPath ).exec();
        }else if("uploadImage".equals(action)){//文件上传操作
            /**
             * 1.设置文件上传解析器，指定bean的名字为multipartResolver
             * 2.在服务的接口上添加CommonsMultipartFile对象
             * 3.执行文件上传
             * 4.返回执行响应json字符串
             */
            if (!upfile.isEmpty()){
                //设置上传位置
                File dir = new File(realPath);
                /*随机生成不重复文件名*/
                String name = UUID.randomUUID().toString();
                String  originalFilename = upfile.getOriginalFilename();

                String type = originalFilename.substring(originalFilename.lastIndexOf("."));
                String realName = name+type;

                try {
                    upfile.transferTo(new File(dir,realName));
                    result = new JSONObject(resultMap("SUCCESS",originalFilename,upfile.getSize(),realName,type,path+File.separator+realName)).toString();
                } catch (IOException e) {
                    e.printStackTrace();
                    result = new JSONObject(resultMap("FAIL",null,0,null,null,null)).toString();
                }
            }
        }

        return result;
    }


    //{"state": "SUCCESS","original": "111.jpg","size": "124147","title": "1535961757878095151.jpg","type": ".jpg","url": "/1535961757878095151.jpg"}

    private Map<String,Object> resultMap(String state, String original, long size, String title,String type,  String url){
        Map<String ,Object> result = new HashMap<>();
        result.put("state",state);
        result.put("original",original);
        result.put("size",size);
        result.put("title",title);
        result.put("type",type);
        result.put("url", url);
        return result;
    }
}
