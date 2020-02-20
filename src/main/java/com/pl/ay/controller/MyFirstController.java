package com.pl.ay.controller;

import com.pl.ay.model.QtNewIPOStockModel;
import com.pl.ay.service.MyFirstService;
import com.pl.ay.util.JsonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pl on 2019/8/29
 */
@Controller
@Slf4j
@RequestMapping("/ssj/")
public class MyFirstController {

    @Autowired
    private MyFirstService myFirstService;

    @RequestMapping(value = "/mytest")
    @ResponseBody
    public JsonResponse findByTradeDate() {
        Map<String, Object> map = new HashMap<>();
        List<QtNewIPOStockModel> result = myFirstService.findByTradeDate();
        map.put("qtNewIPOStock", result);
        return JsonResponse.success("success!").addInfo(map);
    }

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("a");
        return mv;
    }

    @RequestMapping(value = "/add")
    public Object add(HttpServletRequest request, @RequestParam(value = "files", required = false) MultipartFile multipartFile) throws Exception {//这里一定要写required=false 不然前端不传文件一定报错。到不了后台。
        //获取文件名
        String realpath="";
        String name = "";
        if (multipartFile != null){
            long size = multipartFile.getSize();
            if (size > 5242880) {//文件设置大小，我这里设置5M。
                throw new Exception("跑出异常");
            }
            name = multipartFile.getOriginalFilename();//直接返回文件的名字
            String subffix = name.substring(name.lastIndexOf(".") + 1, name.length());//我这里取得文件后缀
            String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());//文件保存进来，我给他重新命名，数据库保存有原本的名字，所以输出的时候再把他附上原本的名字就行
            //String filepath = request.getServletContext().getRealPath("/") + "files\\";//获取项目路径到webapp
            File file = new File("/static");
            if (!file.exists()) {//目录不存在就创建
                file.mkdirs();
            }
            multipartFile.transferTo(new File(file + "\\" + fileName + "." + subffix));//保存文件
            realpath = file + "\\" + fileName + "." + subffix;
        }
        return null;
    }
}
