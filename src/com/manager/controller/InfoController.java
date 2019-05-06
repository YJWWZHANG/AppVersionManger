package com.manager.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manager.entity.Info;
import com.manager.entity.Page;
import com.manager.service.InfoService;


@Controller
@RequestMapping(value="/info")
public class InfoController {
	
	@Resource
	private InfoService infoService;
	
	@RequestMapping
	public String info(Model model,Page page){
		List<Info> infoList = infoService.listPageInfo(page);
		model.addAttribute("infoList", infoList);
		model.addAttribute("page", page);
		return "info";
	}
	
}
