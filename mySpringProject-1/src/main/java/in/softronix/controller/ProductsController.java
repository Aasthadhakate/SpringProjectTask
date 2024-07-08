package in.softronix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.softronix.entity.Products;
import in.softronix.service.ProductsService;

@Controller
public class ProductsController {
	
	@Autowired
	ProductsService service;
	
	@RequestMapping(value = "index",method=RequestMethod.GET)
	public String ind()
	{
		return "home";
	}
	
	@RequestMapping(value = "add", method=RequestMethod.GET)
	public String add()
	{
		return "add";
	}
	
	@RequestMapping(value = "save",method=RequestMethod.POST)
	public String saves(@RequestParam String name,@RequestParam String cost, @RequestParam String quant)
	{
		Products pro=new Products();
		pro.setName(name);
		pro.setCost(Integer.parseInt(cost));
		pro.setQuantity(Integer.parseInt(quant));
		Products pro1=new Products();
		
		pro1=service.savePro(pro);
		if(pro1==null)
		{
			return "error";
		}
		else
		{
			return "success";
		}
	}
		
	@RequestMapping(value ="delete",method=RequestMethod.GET)
	public String del() 
	{
		return "delete";
	}
	
	@RequestMapping(value ="del",method=RequestMethod.POST)
	public String dels(@RequestParam String id)
	{
		String status;
		status = service.deletePro(Integer.parseInt(id));
		if(status=="success")
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}
	
	@RequestMapping(value = "view",method=RequestMethod.GET)
	public String view()
	{
		return "view";
	}
	@RequestMapping(value = "show",method=RequestMethod.POST)
	public String edit(@RequestParam String id,ModelMap map)
	{
		Products pro = new Products();
		pro = service.finds(Integer.parseInt(id));
		if(pro==null)
		{
			return "error";
		}
		else
		{
			map.addAttribute("id", pro.getId());
			map.addAttribute("product",pro);
			return "editform";
		}
	}
	
	@RequestMapping(value = "update",method=RequestMethod.POST)
	public String ups(@RequestParam String id,@RequestParam String name,@RequestParam  String cost, @RequestParam String quant,ModelMap map)
	{
		Products pro = new Products();
		pro.setId(Integer.parseInt(id));
		pro.setName(name);
		pro.setCost(Integer.parseInt(cost));
		pro.setQuantity(Integer.parseInt(quant));
		
		Products p = new Products();
		p=service.update(pro);
		if(p==null)
		{
			return "error";
		}
		else
		{
			return "success";
		}
	}
}
