package com.bd.jpa.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.jpa.modelo.TblProducto;
import com.bd.jpa.servicio.IProductoService;

@Controller
@RequestMapping("/vistas")
public class productoController {

	@Autowired
	private IProductoService productoServ;
	
	@GetMapping("/ListadoProductos")
	public String ListarProducto(Model model) {
		model.addAttribute("producto",productoServ.ListadoProducto());
		
		return "/vistas/ListadoProducto";
	}
	@GetMapping("/RegistrarProducto")
	public String RegistrarProducto(Model model) {
		TblProducto tblprod=new TblProducto();
		
		model.addAttribute("regproducto",tblprod);
		
		return "/vistas/RegistrarProducto";
	}
	@PostMapping("/GuardarProducto")
	public String GuardarProducto(@ModelAttribute TblProducto tblprod,Model modelo) {
		productoServ.RegistrarProducto(tblprod);
		System.out.println("Dato Registrado en la BD !!!!!");
		
		return "redirect:/vistas/ListadoProductos";
		
		
	}
}
