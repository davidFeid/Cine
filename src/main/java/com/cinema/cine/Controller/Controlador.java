package com.cinema.cine.Controller;

import com.cinema.cine.Entity.Pelicula;
import com.cinema.cine.Entity.Sala;
import com.cinema.cine.Service.ListaServiceIMPL.LSIMPL;
import com.cinema.cine.Service.PersonaServiceIMPL.PSIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("CRUDRepo")
@RestController
public class Controlador {

    private final PSIMPL psimpl;

    public Controlador(PSIMPL psimpl) {
        this.psimpl = psimpl;
    }

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
    private LSIMPL lsimpl;

    @GetMapping
    @RequestMapping(value = "ConsultarSala",method =RequestMethod.GET)
    public ResponseEntity<?> ConsultarSala(){
        List<Sala> listarSala=this.lsimpl.ConsultarSala();
        return ResponseEntity.ok(listarSala);
    }

    @PostMapping
    @RequestMapping(value = "CrearSala",method =RequestMethod.POST)
    public ResponseEntity<?> CrearSala(@RequestBody Sala sala){
        Sala SalaCreada=this.lsimpl.CrearSala(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(SalaCreada);
    }

    @PutMapping
    @RequestMapping(value = "ModificarSala",method =RequestMethod.PUT)
    public ResponseEntity<?> ModificarSala(@RequestBody Sala sala){
        Sala SalaModificada=this.lsimpl.ModificarSala(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(SalaModificada);
    }

    @GetMapping
    @RequestMapping(value = "BuscarSala/{id}",method =RequestMethod.GET)
    public ResponseEntity<?> BuscarSala(@PathVariable int id){
        Sala sala=this.lsimpl.BuscarSala(id);
        return ResponseEntity.ok(sala);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarSala/{id}",method =RequestMethod.DELETE)
    public ResponseEntity<?> ElimnarSala(@PathVariable int id){
        this.lsimpl.ElimnarSala(id);
        return ResponseEntity.ok().build();
    }

}
