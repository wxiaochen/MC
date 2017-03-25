package com.fruit.fruit.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fruit.entity.Fruit;
import com.fruit.framework.Page;
import com.fruit.fruit.service.FruitServiceImpl;

@Controller
@RequestMapping("fruit")
public class FruitControllerImpl {

	@Resource
	private FruitServiceImpl fruitServiceImpl;

	@RequestMapping("add")
	public String add(Fruit f) {
		this.fruitServiceImpl.addFruit(f);
		return "redirect:list";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String toEdit(@RequestParam("number") Integer fruitNumber, HttpServletRequest request) {
		Fruit f = this.fruitServiceImpl.getFruit(fruitNumber);
		request.setAttribute("fruit", f);
		request.setAttribute("action", "edit");
		return "fruit/form";
	}

	@RequestMapping(value="edit",method=RequestMethod.POST)
	public String edit(Fruit f, HttpServletRequest request) {
		this.fruitServiceImpl.editFruit(f);
		return "redirect:list";
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String delete(@RequestParam("number") Integer fruitNumber, HttpServletRequest request) {
		this.fruitServiceImpl.dropFruit(fruitNumber);
		return "redirect:list";
	}

	@RequestMapping("list")
	public String list(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(name = "searchParam", defaultValue = "") String searchParam, HttpServletRequest request,
			Model model) {

		Page<Fruit> page;
		if (searchParam == null || searchParam.equals("")) {

			page = this.fruitServiceImpl.listFruit(pageNum, 8, null);

		} else {
			page = this.fruitServiceImpl.listFruit(pageNum, 8, new Object[] { searchParam });
		}

		request.setAttribute("page", page);
		request.setAttribute("searchParam", searchParam);
		return "product";

	}

}
