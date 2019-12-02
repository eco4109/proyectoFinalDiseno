package mx.uaemex.fi.diseno.flyns.config;

import java.util.Arrays;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.*;

import mx.uaemex.fi.diseno.flyns.principal.Fisgon;

@Configuration //Conesta esta anotacion lo hacemos un configurardor
@ComponentScan("mx.uaemex.fi.diseno.flyns") //Donde buscar componentes con Annotations

public class AppConfig {
	
	@Bean
	public FilterRegistrationBean<Fisgon> auditingFilterRegistrationBean(){
		FilterRegistrationBean<Fisgon> registro = new FilterRegistrationBean<>();
		Fisgon filtro = new Fisgon();
		registro.setFilter(filtro);
		registro.setOrder(Integer.MAX_VALUE);
		registro.setUrlPatterns(Arrays.asList("/juegos/*"));
		return registro;
	}
}