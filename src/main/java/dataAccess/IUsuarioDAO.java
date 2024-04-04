package dataAccess;

import domain.UsuarioEntity;

public interface IUsuarioDAO {
	
	public UsuarioEntity create(UsuarioEntity usuario);
	public UsuarioEntity update();
	public UsuarioEntity read();
	public UsuarioEntity delete();
     
}
