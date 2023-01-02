package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie> moviesDb = new HashMap<>();
    HashMap<String,Director> directorsDb = new HashMap<>();
    HashMap<String, List<String>> directorMoviePair = new HashMap<>();

    public void addMovieToDb(Movie movie){
        moviesDb.put(movie.getName(),movie);
    }

    public void addDirectorToDb( Director director){
        directorsDb.put(director.getName(),director);
    }

    public void addMovieDirectorPairToDb(String movieName,String directorName){
        if(moviesDb.containsKey(movieName) && directorsDb.containsKey(directorName)){
            if(directorMoviePair.containsKey(directorName)){
                directorMoviePair.get(directorName).add(movieName);
            }
            else{
                List<String> moviename = new ArrayList<>();
                moviename.add(movieName);
                directorMoviePair.put(directorName,moviename);
            }
        }
    }

    public Movie getMovieByNameFromDb(String movieName){
        return moviesDb.get(movieName);
    }

    public Director getDirectorByNameFromDb(String directorName){
        return directorsDb.get(directorName);

    }

    public List<String> getMoviesByDirectorNameFromDb(String directorName){
        return directorMoviePair.get(directorName);
    }

    public List<String> findAllMoviesFromDb(){
        List<String> allMovies = new ArrayList<>();
        for(String m:moviesDb.keySet()){
            allMovies.add(m);
        }
        return allMovies;
    }

    public void deleteDirectorByNameFromDb(String directorName){
        directorsDb.remove(directorName);
        if(directorMoviePair.containsKey(directorName)){
            for(String s:directorMoviePair.get(directorName)){
                moviesDb.remove(s);
            }
        }
    }

    public void deleteAllDirectorsFromDb(){
        directorsDb.clear();
        for(List<String> movies:directorMoviePair.values()){
            for(String s:movies){
                moviesDb.remove(s);
            }
        }
        directorMoviePair.clear();
    }
}
