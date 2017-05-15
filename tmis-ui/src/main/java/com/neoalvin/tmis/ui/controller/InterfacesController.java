package com.neoalvin.tmis.ui.controller;

import com.neoalvin.tmis.api.IZookeeperService;
import com.neoalvin.tmis.impl.ZookeeperServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 接口Controller
 * Created by alvin on 2017/4/25.
 */
@Controller
public class InterfacesController {

  @RequestMapping("/interfaces")
  public ModelAndView getInterfaces(){
    ModelAndView mv = new ModelAndView();
    mv.setViewName("interfaces");
    return mv;
  }

  @RequestMapping(value = "/interfaces/list", method = RequestMethod.GET, produces = "application/json")
  public List<String> getInterfaceList(){
    IZookeeperService zookeeperService = new ZookeeperServiceImpl();
    return zookeeperService.getDubboServices();
  }
}
