package mx.uaemex.fi.diseno.flyns.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mx.uaemex.fi.diseno.flyns.model.data.Juego;

@Component
public class JuegoServicio {
	
	private JuegoRepository repositorio;
	
	@Autowired //Le está diciendo que se necesita instanciar el repositorio aqui
	public JuegoServicio(JuegoRepository r) {
		this.repositorio = r;
	}
	
	public Juego salva(String n, String url) {
		this.repositorio.salvaJuego(new Juego(n, url));
		return new Juego(n, url);
	}
}
