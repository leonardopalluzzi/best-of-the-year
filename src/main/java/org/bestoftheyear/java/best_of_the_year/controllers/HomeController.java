package org.bestoftheyear.java.best_of_the_year.controllers;

import java.util.ArrayList;

import org.bestoftheyear.java.classes.Movie;
import org.bestoftheyear.java.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    ArrayList<Movie> movieList;
    ArrayList<Song> songsList;

    @GetMapping("/")
    public String home(Model model) {
        String name = "Leonardo";
        model.addAttribute("name", name);

        return "index";
    }

    private ArrayList<Movie> getBestMovies() {
        Movie firstMovie = new Movie("Film 1", 1);
        Movie secondMovie = new Movie("Film 2", 2);
        Movie thirdMovie = new Movie("Film 3", 3);
        Movie fourthMovie = new Movie("Film 4", 4);

        movieList = new ArrayList<>();

        movieList.add(firstMovie);
        movieList.add(secondMovie);
        movieList.add(thirdMovie);
        movieList.add(fourthMovie);

        return movieList;
    }

    private ArrayList<Song> getBestSongs() {

        Song firstSong = new Song("Song 1", 1);
        Song secondSong = new Song("Song 2", 2);
        Song thirdSong = new Song("Song 3", 3);
        Song fourthSong = new Song("Song 4", 4);

        songsList = new ArrayList<>();

        songsList.add(firstSong);
        songsList.add(secondSong);
        songsList.add(thirdSong);
        songsList.add(fourthSong);

        return songsList;

    }

    @GetMapping("/movies")
    public String movies(Model model) {

        model.addAttribute("movieList", getBestMovies());
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        model.addAttribute("songsList", getBestSongs());
        return "songs";
    }

    @GetMapping("/song/{id}")
    public String song(@PathVariable("id") String id, Model model) {
        getBestSongs();
        for (Song song : songsList) {
            Song foundSong;
            if (song.getId() == Integer.parseInt(id)) {
                foundSong = song;
                model.addAttribute("song", foundSong);
                break;
            }
        }
        return "song";

    }

    @GetMapping("/movie/{id}")
    public String movie(@PathVariable("id") String id, Model model) {
        getBestMovies();
        for (Movie movie : movieList) {
            Movie foundMovie;
            if (movie.getId() == Integer.parseInt(id)) {
                foundMovie = movie;
                model.addAttribute("movie", foundMovie);
                break;
            }
        }
        return "movie";

    }

}
