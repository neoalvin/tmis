package com.neoalvin.tmis.ui.controller;

import com.neoalvin.tmis.model.InterfaceWatchInfo;
import com.neoalvin.tmis.service.InterfaceWatchInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by alvin on 2017/4/25.
 */
@Controller
public class IndexController {

  @Resource
  InterfaceWatchInfoService interfaceWatchInfoService;

  @RequestMapping("/")
  public ModelAndView getIndex(HttpServletRequest request){
    ModelAndView mv = new ModelAndView();
    HttpSession session = request.getSession();
    try{
      InterfaceWatchInfo watchInfo = interfaceWatchInfoService.selectInterfaceWatchInfo();
      session.setAttribute("servicesCount",watchInfo.getInterfaceCount());
      session.setAttribute("callCount",watchInfo.getInterfaceCallSum());
      session.setAttribute("serverCount",watchInfo.getServerCount());
    }catch(Exception e){
      session.setAttribute("servicesCount",0);
      session.setAttribute("callCount",0);
      session.setAttribute("serverCount",0);
    }
    mv.setViewName("index");
    return mv;
  }

  @RequestMapping("/interface_docs")
  public ModelAndView getInterfaceDocs(){
    ModelAndView mv = new ModelAndView();
    mv.setViewName("interface_docs");
    return mv;
  }

  @RequestMapping("/interface_extend")
  public ModelAndView getInterfaceExtend(){
    ModelAndView mv = new ModelAndView();
    mv.setViewName("interface_extend");
    return mv;
  }

  @RequestMapping("/interface_test")
  public ModelAndView getInterfaceTest(){
    ModelAndView mv = new ModelAndView();
    mv.setViewName("interface_test");
    return mv;
  }




}
