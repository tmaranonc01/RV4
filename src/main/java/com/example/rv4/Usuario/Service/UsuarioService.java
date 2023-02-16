package com.example.rv4.Usuario.Service;

import com.example.rv4.BaseService;
import com.example.rv4.Usuario.Domain.Usuario;
import com.example.rv4.Usuario.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService extends BaseService<Usuario, Long, UsuarioRepository> {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario addUsuario(Usuario nuevoUsuario){
        return usuarioRepository.save(nuevoUsuario);
    }

    public Usuario updateUsuarioById(Usuario nuevoUsuario){
        Optional<Usuario> usuario = null;
        usuario = usuarioRepository.findById((nuevoUsuario.getId()));
        if (usuario.isPresent()){
            usuarioRepository.save(nuevoUsuario);
        }
        return usuario.get();
    }

    public void deleteUsuario(Long id){
        try {
            usuarioRepository.delete(usuarioRepository.findById(id).get());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Usuario> getUsuario() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id){
        return usuarioRepository.findById(id);
    }
}
