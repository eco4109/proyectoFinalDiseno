package mx.uaemex.fi.diseno.flyns.principal;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

public class Fisgon extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long inicio = new Date().getTime();
		chain.doFilter(request, response);
		long lapso = new Date().getTime() - inicio;
		HttpServletRequest req = (HttpServletRequest) request;
		logger.debug("Peticion[uri = "+req.getRequestURI()+", metodo = "+req.getMethod()+"] completado en "+ lapso+" ms");
	}

}
