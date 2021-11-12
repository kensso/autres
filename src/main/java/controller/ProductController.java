package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import model.Product;
import services.ProductService;

@RestController
public class ProductController {
	  @Autowired
	    private ProductService service;
	  /*@RequestMapping("/")
	  public String viewHomePage(Model model) {
	      List<Product> listProducts = service.listAll();
	      model.addAttribute("listProducts", listProducts);
	       
	      return "index";
	  }*/
	  @GetMapping(value="/new")
	  //@RequestMapping("/new")
	  public String showNewProductPage(ModelMap model) {
	      Product product = new Product();
	      model.addAttribute("product", product);
	       
	      return "new_product";
	  }
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public String saveProduct(@ModelAttribute("product") Product product) {
	      service.save(product);
	       
	      return "redirect:/";
	  }
	  
	  @RequestMapping("/edit/{id}")
	  public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	      ModelAndView mav = new ModelAndView("edit_product");
	      Product product = service.get(id);
	      mav.addObject("product", product);
	       
	      return mav;
	  }
	  @RequestMapping("/delete/{id}")
	  public String deleteProduct(@PathVariable(name = "id") int id) {
	      service.delete(id);
	      return "redirect:/";       
	  }

}
