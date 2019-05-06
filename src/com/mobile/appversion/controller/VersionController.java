package com.mobile.appversion.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobile.appversion.service.VersionService;
import com.mobile.model.ResultModelVersion;

/**
 * 版本更新接口
 */
@Controller
@RequestMapping("/com/mobile/")
public class VersionController {
	@Resource
	VersionService versionService;

	@RequestMapping(value = "updateVersion", method = RequestMethod.POST)
	@ResponseBody
	public ResultModelVersion getCurrentVersion(HttpServletRequest request,
			@RequestParam String version, @RequestParam String appKey) {

		return versionService.updateVersionNumberServiceInterface(request,
				version, appKey);
	}
}
