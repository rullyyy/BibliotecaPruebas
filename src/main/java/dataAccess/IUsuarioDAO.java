package dataAccess;

import domain.UsuarioEntity;
import java.util.List;

public interface IUsuarioDAO {
	
	public UsuarioEntity create(UsuarioEntity usuario);
	public UsuarioEntity update(UsuarioEntity usuarioEntity);
	public UsuarioEntity read();
	public UsuarioEntity delete();
        public List<UsuarioEntity> findUsers(boolean all, int maxResults, int firstResult);
        public UsuarioEntity findUser(Integer id);
        public boolean existeUsuario(UsuarioEntity usuario);
     
}
