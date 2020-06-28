//package com.home.we.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class controller {
//   
//   @RequestMapping(value = "/post/{x}",method = RequestMethod.POST, produces = {"application/json"})
//   public @ResponseBody Map<String, Object> makerepo(@RequestBody Map<String, Object> info){
//      System.out.println(info.get("tempvalue") + " "+ info.get("humivalue"));
//      
//      Map<String, Object> retVal = new HashMap<String, Object>();
//
//      retVal.put("result","success!!");
//      return retVal;
//   }
//
//}