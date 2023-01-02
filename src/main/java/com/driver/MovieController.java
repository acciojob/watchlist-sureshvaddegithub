package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
         movieService.addMovie(movie);
        return new ResponseEntity<>("success" , HttpStatus.CREATED);
    }

    @PostMapping("add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
           movieService.addDirector(director);
        return new ResponseEntity<>("success" , HttpStatus.CREATED);
    }

    @PutMapping("add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName,@RequestParam String directorName){
        movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>("success" , HttpStatus.CREATED);
    }

    @GetMapping("get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
         Movie movie = null;
          movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director = null;
        director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    @GetMapping("get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> movies = null;
         movies = movieService.getMoviesByDirectorName(director);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }

    @GetMapping("get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> allMovies = null;
           allMovies = movieService.findAllMovies();

        return new ResponseEntity<>(allMovies,HttpStatus.CREATED);
    }

    @DeleteMapping("delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName){
           movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>("success" , HttpStatus.CREATED);
    }

    @DeleteMapping("delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
         movieService.deleteAllDirectors();
        return new ResponseEntity<>("success" , HttpStatus.CREATED);
    }
}
