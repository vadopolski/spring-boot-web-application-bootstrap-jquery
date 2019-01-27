package com.in28minutes.springboot.tutorial.basics.application.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WelcomeController {
	private TaskRepository taskRepository;

	@Autowired
	public WelcomeController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@RequestMapping("/welcome")
	public String loginMessage(){
		return "welcome";
	}

	@RequestMapping(value = "/welcome/user/{name}", method = RequestMethod.GET)
	public ModelAndView loginMessageWithName( @PathVariable("name") String name) {
		ModelAndView modelAndView = new ModelAndView("welcomeWithName");
		modelAndView.addObject("userName", name);
		List<Task> tasks = new ArrayList<>();
		taskRepository.findAll().forEach(tasks::add);
		modelAndView.addObject("taskList", tasks);
		return modelAndView;
	}

	@RequestMapping(value = "/taskpart/{first}/{size}", method = RequestMethod.GET)
	public ModelAndView getTaskByPage(@PathVariable(value = "first") Integer first,
									  @PathVariable(value = "size") Integer size) {
		int firstPage = first / size;
		List<Task> tasks = taskRepository.findAllByIsUrgentOrIsUrgent(
				0, 1, new PageRequest(firstPage, size));
		ModelAndView modelAndView = new ModelAndView("tasksWithPagination");
		modelAndView.addObject("taskList", tasks);
		return modelAndView;
	}

	@RequestMapping(value = "/welcome/company/{title}", method = RequestMethod.GET)
	public ModelAndView loginMessageWithCompany( @PathVariable("title") String name) {
		ModelAndView modelAndView = new ModelAndView("welcomeWithName");
		modelAndView.addObject("userName", name);
		return modelAndView;
	}
}