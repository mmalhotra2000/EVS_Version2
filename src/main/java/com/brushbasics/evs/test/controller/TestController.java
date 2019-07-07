package com.brushbasics.evs.test.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brushbasics.evs.test.model.TestModel;
import com.brushbasics.evs.test.service.TestModelService;

@Controller
@RequestMapping("/testcontroller")
public class TestController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TestModelService testModelService;

	@RequestMapping("/test")
	public String welcome(Map<String, Object> model) {
		model.put("message", "testing page");
		return "/userregistration/index";
	}

	// openRegistration

	@RequestMapping("/openRegistration")
	public String displayRegistrationPage(Map<String, Object> model) {
		model.put("message", "testing page");
		return "/userregistration/view_profile";
	}

	@GetMapping("/showTestForm")
	public String showFormForAdd(Model theModel) {
		LOGGER.trace("trace enter test");
		LOGGER.debug("This is a debug message");
		LOGGER.info("This is an info message");
		LOGGER.warn("This is a warn message");
		LOGGER.error("This is an error message");
		TestModel testModel = new TestModel();
		theModel.addAttribute("testModel", testModel);
		LOGGER.trace("trace exit");
		return "test-form";
	}

	@PostMapping("saveTest")
	public String saveTest(@ModelAttribute("testModel") TestModel testModel) {
		testModelService.saveTestModel(testModel);
		return "redirect:/testcontroller/testList";
	}

	@GetMapping("testList")
	public String listTests(Model model) {
		List<TestModel> testList = testModelService.getAllTest();
		model.addAttribute("testList", testList);
		return "list-tests";
	}

	@RequestMapping("/change-hi")
	public String changeLocaleHi(HttpServletRequest httpServletRequest) {
		Config.set(httpServletRequest.getSession(), Config.FMT_LOCALE, new java.util.Locale("hi", "IN"));
		return "welcome";
	}

	@RequestMapping("/change-en")
	public String changeLocaleEn(HttpServletRequest httpServletRequest) {
		Config.set(httpServletRequest.getSession(), Config.FMT_LOCALE, new java.util.Locale("en", "IN"));
		return "welcome";
	}
}
