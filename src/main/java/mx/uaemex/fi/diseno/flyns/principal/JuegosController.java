package mx.uaemex.fi.diseno.flyns.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import mx.uaemex.fi.diseno.flyns.model.data.Juego;
import mx.uaemex.fi.diseno.flyns.model.data.JuegoData;

@Controller //Se hace controlador
@RequestMapping("/juegos") //Mapea el controlador al juegos
public class JuegosController {
	private JuegoServicio juegoServicio;
	
	@Autowired
	public JuegosController(JuegoServicio elServicio) {
		this.juegoServicio = elServicio;
	}
	
	@PostMapping("")
	@ResponseBody
	public ResponseEntity<Juego> salvaJuego(@RequestBody JuegoData data){
		Juego saved = juegoServicio.salva(data.getNombre(), data.getUrl());
		if(saved == null) {
			return ResponseEntity.status(500).build();
		}
		return ResponseEntity.ok(saved);
	}
	
	@GetMapping("/bienvenido")
	public String bienvenido(Model model) {
		model.addAttribute("mensaje", "Hello, Welcome to Spring Boot");
		return "bienvenido";
	}
}
