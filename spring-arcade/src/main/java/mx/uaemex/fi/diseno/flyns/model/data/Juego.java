package mx.uaemex.fi.diseno.flyns.model.data;

public class Juego {
	private String nombre;
	private Integer id;
	private boolean activo;
	private String url;
	
	public Juego(String n, String url) {
		this.nombre = n;
		this.activo = false;
		this.url = url;
	}
	
	public Juego(int id, String nombre, boolean activo, String url) {
		this.nombre = nombre;
		this.id = id;
		this.activo = activo;
		this.url = url;
	}
	
	public boolean isActivo() {
		return this.activo;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
