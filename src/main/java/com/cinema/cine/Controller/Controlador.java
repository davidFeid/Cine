package com.cinema.cine.Controller;

import com.cinema.cine.Entity.Pelicula;
import com.cinema.cine.Entity.Sala;
import com.cinema.cine.Entity.Usuario;
import com.cinema.cine.Service.SalaServiceIMPL.SSIMPL;
import com.cinema.cine.Service.PersonaServiceIMPL.PSIMPL;
import com.cinema.cine.Service.UusuarioServiceIMPL.USIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("CRUDRepo")
@RestController
@CrossOrigin("*")
public class Controlador {

    private final PSIMPL psimpl;

    public Controlador(PSIMPL psimpl) {
        this.psimpl = psimpl;
    }


    //Peliculas
    @GetMapping
    @RequestMapping(value = "ConsultarPeliculas", method = RequestMethod.GET)
    public ResponseEntity<?> ConsultarPeliculas(){
        List<Pelicula> listarPelicula=this.psimpl.ConsultarPelicula();
        return ResponseEntity.ok(listarPelicula);
    }

    @PostMapping
    @RequestMapping(value = "CRearPeliculas", method = RequestMethod.POST)
    public ResponseEntity<?> CrearPeliculas(@RequestBody Pelicula pelicula){
        Pelicula PeliculaCreada = this.psimpl.CrearPelicula(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(PeliculaCreada);
    }

    @PutMapping
    @RequestMapping(value = "ModificarPelicula", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarPelicula(@RequestBody Pelicula pelicula){
        Pelicula PeliculaModificada = this.psimpl.ModificarPelicula(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(PeliculaModificada);
    }

    @GetMapping
    @RequestMapping(value = "BuscarPelicula/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarPelicula(@PathVariable int id){
        Pelicula pelicula = this.psimpl.BuscarPelicula(id);
        return ResponseEntity.ok(pelicula);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarPelicula/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarPelicula(@PathVariable int id){
        this.psimpl.EliminarPelicula(id);
        return ResponseEntity.ok().build();
    }

    @Autowired
    private SSIMPL ssimpl;

    //Salas
    @GetMapping
    @RequestMapping(value = "ConsultarSala",method =RequestMethod.GET)
    public ResponseEntity<?> ConsultarSala(){
        List<Sala> listarSala=this.ssimpl.ConsultarSala();
        return ResponseEntity.ok(listarSala);
    }

    @PostMapping
    @RequestMapping(value = "CrearSala",method =RequestMethod.POST)
    public ResponseEntity<?> CrearSala(@RequestBody Sala sala){
        Sala SalaCreada=this.ssimpl.CrearSala(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(SalaCreada);
    }

    @PutMapping
    @RequestMapping(value = "ModificarSala",method =RequestMethod.PUT)
    public ResponseEntity<?> ModificarSala(@RequestBody Sala sala){
        Sala SalaModificada=this.ssimpl.ModificarSala(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(SalaModificada);
    }

    @GetMapping
    @RequestMapping(value = "BuscarSala/{id}",method =RequestMethod.GET)
    public ResponseEntity<?> BuscarSala(@PathVariable int id){
        Sala sala=this.ssimpl.BuscarSala(id);
        return ResponseEntity.ok(sala);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarSala/{id}",method =RequestMethod.DELETE)
    public ResponseEntity<?> ElimnarSala(@PathVariable int id){
        this.ssimpl.EliminarSala(id);
        return ResponseEntity.ok().build();
    }

    //Usuarios
    @Autowired
    private USIMPL usimpl;

    @GetMapping
    @RequestMapping(value = "ConsultarUsuario",method =RequestMethod.GET)
    public ResponseEntity<?> ConsultarUsuario(){
        List<Usuario> listarUsuario=this.usimpl.ConsultarUsuario();
        return ResponseEntity.ok(listarUsuario);
    }
    @PostMapping
    @RequestMapping(value = "CrearUsuario",method =RequestMethod.POST)
    public ResponseEntity<?> CrearUsuario(@RequestBody Usuario usuario){
        Usuario UsuarioCreada=this.usimpl.CrearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioCreada);
    }
    @PutMapping
    @RequestMapping(value = "ModificarUsuario",method =RequestMethod.PUT)
    public ResponseEntity<?> ModificarUsuario(@RequestBody Usuario usuario){
        Usuario UsuarioModificada=this.usimpl.ModificarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioModificada);
    }
    @GetMapping
    @RequestMapping(value = "BuscarUsuario/{id}",method =RequestMethod.GET)
    public ResponseEntity<?> BuscarUsuario(@PathVariable int id){
        Usuario usuario=this.usimpl.BuscarUsuario(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarUsuario/{id}",method =RequestMethod.DELETE)
    public ResponseEntity<?> EliminarUsuario(@PathVariable int id){
        this.usimpl.EliminarUsuario(id);
        return ResponseEntity.ok().build();
    }

}
