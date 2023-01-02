package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovieToDb(movie);
    }

    public void addDirector(Director director){
        movieRepository.addDirectorToDb(director);
    }

    public void addMovieDirectorPair(String movieName,String directorName){
        movieRepository.addMovieDirectorPairToDb(movieName,directorName);
    }

    public Movie getMovieByName(String movieName){
        return movieRepository.getMovieByNameFromDb(movieName);
    }

    public Director getDirectorByName(String directorName){
        return movieRepository.getDirectorByNameFromDb(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName){
        return movieRepository.getMoviesByDirectorNameFromDb(directorName);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMoviesFromDb();
    }

    public void deleteDirectorByName(String directorName){
        movieRepository.deleteDirectorByNameFromDb(directorName);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectorsFromDb();
    }
}
