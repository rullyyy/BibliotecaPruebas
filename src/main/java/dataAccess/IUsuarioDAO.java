package dataAccess;

import domain.Usuario;

public interface IUsuarioDAO {
	
	public Usuario create();
	public Usuario edit();
	public Usuario read();
	public Usuario delete();
}
