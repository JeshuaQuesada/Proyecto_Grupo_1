package Libreria.Libreria.service.impl;

import Libreria.Libreria.service.UsuarioService;
import Libreria.Libreria.domain.Usuario;
import Libreria.Libreria.dao.UsuarioDao; // Asegurate de tener un DAO o repositorio
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    public Usuario getUsuarioPorUsernameYPassword(String username, String password) {
        return usuarioDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.existsByUsernameOrCorreo(username, correo);
    }

    @Override
    public void save(Usuario usuario, boolean crearRolUser) {
        usuarioDao.save(usuario);
        // lógica para crear rol user si es necesario (según tu modelo)
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
}

