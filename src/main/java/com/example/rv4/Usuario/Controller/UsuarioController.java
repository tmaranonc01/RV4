package com.example.rv4.Usuario.Controller;

import com.example.rv4.Usuario.Domain.Usuario;
import com.example.rv4.Usuario.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuarios(){
        List<Usuario> usuarios = usuarioService.getUsuario();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Usuario> UsuarioPorId(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
        usuario.setDNI(usuario.getDNI());
        usuario.setContrasena(usuario.getContrasena());
        usuario.setCorreo(usuario.getCorreo());
        usuario.setNombreUsuario(usuario.getNombreUsuario());
        usuario.setDireccion(usuario.getDireccion());
        Usuario usuario1 = usuarioService.addUsuario(usuario);
        return new ResponseEntity<>(usuario1, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Usuario> modifyUsuario(@RequestBody Usuario nuevoUsuario) {
        Usuario usuario = usuarioService.updateUsuarioById(nuevoUsuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
