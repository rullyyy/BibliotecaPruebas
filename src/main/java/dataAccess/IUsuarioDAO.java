package dataAccess;

import domain.UsuarioEntity;
import java.util.List;

public interface IUsuarioDAO {
	
	public UsuarioEntity create(UsuarioEntity usuario);
	public UsuarioEntity update();
	public UsuarioEntity read();
	public UsuarioEntity delete();
        public List<UsuarioEntity> findUsers(boolean all, int maxResults, int firstResult);
     
}
