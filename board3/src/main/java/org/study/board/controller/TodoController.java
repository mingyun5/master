package org.study.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.study.board.model.TodoVO;
import org.study.board.service.TodoService;

@Controller
@RequestMapping("/todo/*")
public class TodoController {
	private static final Logger logger = LoggerFactory.getLogger(TodoController.class);
	
	@Autowired
	private TodoService service;
	
	@RequestMapping(value = "register", method=RequestMethod.GET)
	public String registerGet() {
		logger.info("todo register get");
		
		return "/todo/register";
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String registerPost(TodoVO vo) {
		
		try {
			service.regist(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/todo/listAll";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String listAllGet(Model model) throws Exception {
		
		model.addAttribute("list",service.listAll());
		return "/todo/list";
	}
	
	
}
