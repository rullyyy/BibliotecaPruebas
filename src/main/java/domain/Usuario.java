package domain;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuario")
public class Usuario{
	
	
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
	private long id; 
        @Column(name="nombre")
	private String nombre;
        @Column(name="apellidos")
	private String apZellidos;
        @Column(name="fechaNacimiento")
        @Temporal(TemporalType.DATE)
	private LocalDate fechaNacimiento;
        @Column(name="curp")
	private String curp;
        @Column(name="matricula")
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