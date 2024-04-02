package domain;
import java.time.LocalDate;

public class Usuario{
	
	
	private long id; 
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String curp;
	private long matricula;
	
	
	public Usuario()
	{
		
	}
	
	public Usuario(String nombre, String apellidos, LocalDate fechaNacimiento, String curp, long matricula)
	{
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.curp = curp;
		this.matricula = matricula;
	}
	
	public Usuario(long id, String nombre, String apellidos, LocalDate fechaNacimiento, String curp, long matricula)
	{
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.curp = curp;
		this.matricula = matricula;
	}

	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getApellidos() 
	{
		return apellidos;
	}

	public void setApellidos(String apellidos) 
	{
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento()
	{
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento)
	{
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCurp() 
	{
		return curp;
	}

	public void setCurp(String curp) 
	{
		this.curp = curp;
	}

	public long getMatricula()
	{
		return matricula;
	}

	public void setMatricula(long matricula)
	{
		this.matricula = matricula;
	}

	@Override
	public String toString()
	{
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + ", curp=" + curp + ", matricula=" + matricula + "]";
	}
	
	
	
	
	
	
	

	
	
}