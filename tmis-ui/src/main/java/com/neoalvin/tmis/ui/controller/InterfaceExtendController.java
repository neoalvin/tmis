package com.neoalvin.tmis.ui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

/**
 * 接口扩展Controller类
 * Created by alvin on 2017/5/17.
 */
@Controller
public class InterfaceExtendController {

    public static final Logger LOGGER = LoggerFactory.getLogger
            (InterfaceExtendController.class);

    public static final String API_PACKAGE_PATH = "com/neoalvin/tmis/api/";

    public static final String IMPL_PACKAGE_PATH = "com/neoalvin/tmis/impl/";

    @RequestMapping("/uploadInterfaceFile")
    public void uploadInterfaceFile(@RequestParam(value = "file", required =
            false) MultipartFile file, HttpServletRequest request,
                                    HttpServletResponse response) throws IOException {
        URL locationUrl = InterfaceExtendController.class.getProtectionDomain()
                .getCodeSource().getLocation();
        LOGGER.info(locationUrl + file.getOriginalFilename());
        response.sendRedirect("/interface_extend");
    }

    @RequestMapping("/uploadInterfaceImplFile")
    public void uploadInterfaceImplFile(@RequestParam(value = "file", required =
            false) MultipartFile file, HttpServletRequest request,
                                    HttpServletResponse response) throws IOException {
        URL locationUrl = InterfaceExtendController.class.getProtectionDomain()
                .getCodeSource().getLocation();
        LOGGER.info(locationUrl + file.getOriginalFilename());
        response.sendRedirect("/interface_extend");
    }
}
