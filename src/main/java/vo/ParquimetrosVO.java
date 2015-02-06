package vo;

public class ParquimetrosVO {
	public int id;
	public double latitud;
	public double longitud;
	public String titulo;
	public String icono;
	public String descripcion;
	
	public ParquimetrosVO() {
		// TODO Auto-generated constructor stub
	}
	
	public ParquimetrosVO(int id, double latitud, double longitud, 
				String titulo, String icono, String descripcion) {
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
		this. titulo = titulo;
		this. icono = icono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
