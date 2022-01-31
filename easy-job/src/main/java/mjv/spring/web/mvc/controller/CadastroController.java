package mjv.spring.web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mjv.spring.web.mvc.model.Cadastro;
import mjv.spring.web.mvc.service.CadastroService;

@Controller
public class CadastroController {
	
	@Autowired
	private CadastroService cadastroService;
	
	@GetMapping("/")
	public String view (Model model) {
		model.addAttribute("listCadastros", cadastroService.getAllCadastros());
		return "index";		
	}
	
	@GetMapping("/view")
	public String verNovoCadastro(Model model) {
		Cadastro cadastro = new Cadastro();
		model.addAttribute("Cadastro", cadastro);
		return "novo_cadastro";
	}
	
	@PostMapping("/save")
	public String salvaCadastro(@ModelAttribute("cadastro") Cadastro cadastro) {
		cadastroService.saveCadastro(cadastro);
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable(value = "id") long id, Model model) {
		Cadastro cadastro = cadastroService.getCadastroById(id);
		return "update_cadastro";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCadastro(@PathVariable(value = "id") long id) {
		this.cadastroService.deleteCadastroById(id);
		return "redirect:/";
	}
}


/*
@Controller
@RequestMapping("/")
public class EasyJobController {
	@Autowired
	private CadastroRepository repository;
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mView = new ModelAndView("index");
		mView.addObject("cadastros", repository.findAll());
		
		return mView;
	}
	@PostMapping("/grava")
	public ModelAndView save(@Validated Cadastro cadastro) {
		 repository.save(cadastro);
		 return index();
	}
	@RequestMapping(value = "/delete_user/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable String id) {
		return index();
	}

}
*/