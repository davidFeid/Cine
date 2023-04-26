package com.cinema.cine.Service.PersonaServiceIMPL;

import com.cinema.cine.Entity.Pelicula;
import com.cinema.cine.Repository.PeliculaRepo;
import com.cinema.cine.Service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PSIMPL implements PeliculaService {

    @Autowired
    private PeliculaRepo repo;

    @Override
    public List<Pelicula> ConsultarPelicula() {
        return (List<Pelicula>) this.repo.findAll();
    }

    @Override
    public Pelicula CrearPelicula(Pelicula pelicula) {
        pelicula.setTitulo(pelicula.getTitulo());
        return this.repo.save(pelicula);
    }

    @Override
    public Pelicula ModificarPelicula(Pelicula pelicula) {
        return this.repo.save(pelicula);
    }

    @Override
    public Pelicula BuscarPelicula(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void EliminarPelicula(int id) {
        this.repo.deleteById(id);
    }
}
