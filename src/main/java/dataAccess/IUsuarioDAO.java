package dataAccess;

import domain.UsuarioEntity;

public interface IUsuarioDAO {
	
	public UsuarioEntity create(UsuarioEntity usuario);
	public UsuarioEntity edit();
	public UsuarioEntity read();
	public UsuarioEntity delete();
}
