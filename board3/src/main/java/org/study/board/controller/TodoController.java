package org.study.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.study.board.model.Criteria;
import org.study.board.model.PageMaker;
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
		
		return "redirect:/todo/listPage";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String listAllGet(Model model) throws Exception {
		
		model.addAttribute("list",service.listAll());
		return "/todo/list";
	}
	
	@RequestMapping(value="read", method=RequestMethod.GET)
	public String read(@RequestParam("bno") int bno, Model model, Criteria cri) throws Exception {
		
		model.addAttribute(service.todoread(bno));
		model.addAttribute("cri", cri);
		return "/todo/read";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete(@RequestParam("bno") int bno, Criteria cri) throws Exception {
		service.tododelete(bno);
		return "redirect:/todo/listPage?page=" + cri.getPage() + "&perPageNum=" + cri.getPerPageNum();
	}
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public void modifyGet(int bno, Criteria cri, Model model) throws Exception {
		model.addAttribute(service.todoread(bno));
		model.addAttribute("cri", cri);
	}
	
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modifyPost(TodoVO vo, Criteria cri) throws Exception{
		service.todoupdate(vo);
		return "redirect:/todo/listPage?page=" + cri.getPage() + "&perPageNum=" + cri.getPerPageNum();
	}
	

	@RequestMapping(value="listCri", method = RequestMethod.GET)
	public void listCri(Criteria cri, Model model) throws Exception {
		logger.info("listCri: " + cri);
		
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping(value="listPage", method = RequestMethod.GET)
	public void listPage(Criteria cri, Model model) throws Exception {
		logger.info("listPage: " + cri);
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.countTodoPage());
		model.addAttribute("pageMaker", pageMaker);
	}
}
