package com.aula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aula.domain.Animals;
import com.aula.service.Service;

@Controller
public class AnimalController {
	@Autowired
	private Service Service;

	@RequestMapping("/animal/list")
	public String carList(Model model) {
		List<Animals> listaAnimales = Service.findAll();
		model.addAttribute("animalList", listaAnimales);

		return null;
	}

	@RequestMapping("/animal/add")
	public void animalAdd() {
	}

	@RequestMapping(value = "/animal/add", method = RequestMethod.POST)
	public String animalAddSubmit(@ModelAttribute("animal") Animals a) {

		// validation was successful
		Service.add(a);

		return "redirect:/animal/list";

	}

	@RequestMapping("/animal/act")
	public void actualizarAnimal() {
	}

	@RequestMapping(value = "/animal/act", method = RequestMethod.POST)
	public String actualizarAnimal(@ModelAttribute("animal") Animals a) {
		Service.actualizarAnimal(a);
		return "redirect:/animal/list";
	}

	@RequestMapping("/animal/borrar")
	public void borrarAnimal() {
	}

	@RequestMapping(value = "/animal/borrar", method = RequestMethod.POST)
	public String borrarAnimal(@ModelAttribute("animal") Animals a) {
		Service.borrar(a);
		return "redirect:/animal/list";
	}

}