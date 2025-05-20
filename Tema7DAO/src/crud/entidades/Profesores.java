package crud.entidades;

public class Profesores {
	/**
	 * identificador para cada profesor
	 */
	private int id = 0;
	/**
	 * nombre del profesor
	 */
	private String nombre;
	/**
	 * apeliido del profesor
	 */
	private String apellido;
	/**
	 * En lo que se especializa el profesor
	 */
	private String especialidad;
	/**
	 * correo electrionico del profesor
	 */
	private String email;
	public Profesores(int id, String nombre, String apellido, String especialidad, String email) {
		this.id = id;
		
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}
		if (apellido != null && !apellido.isEmpty()) {
			this.apellido = apellido;
				}
		if (especialidad != null && !especialidad.isEmpty()) {
			this.especialidad = especialidad;
		}
		if (email != null && !email.isEmpty()) {
			this.email = email;
		}
	}
	/**
	 * Cronstructor prinicipal de la clase Profesores 
	 * @param nombre nombre del profesor
	 * @param apellido apellido del profesro
	 * @param especialidad en lo que se especializa
	 * @param email correo elictronico
	 */
	public Profesores(String nombre, String apellido, String especialidad, String email) {
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}
		if (apellido != null && !apellido.isEmpty()) {
			this.apellido = apellido;
				}
		if (especialidad != null && !especialidad.isEmpty()) {
			this.especialidad = especialidad;
		}
		if (email != null && !email.isEmpty()) {
			this.email = email;
		}
	}
	/**
	 * getter para el id
	 * @return devuelve el id
	 */
	public int getId() {
		return id;
	}
	/**
	 * getter para el nombre
	 * @return devuelve el nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * getter para el apellidos
	 * @return devuelve el apellidos
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * getter para el especialidad
	 * @return devuelve el especialidad
	 */
	public String getEspecialidad() {
		return especialidad;
	}
	/**
	 * getter para el email
	 * @return devuelve el email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Setter para cambiar la especialidad
	 * @param especialidad
	 */
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	/**
	 * Setter para cambiar el email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Funcion toString de la clase 
	 */
	@Override
	public String toString() {
		return  this.id+" Nombre Completo:"+this.nombre+" "+this.apellido+" \nEspecialidad: "+this.especialidad + " Correo: "+this.email;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		boolean iguales =false;
		if (obj instanceof Profesores e) {
			iguales = (e.id == this.id);
		}
		return iguales;
	
	}

	

}
