package com.example.songr.controller;

import com.example.songr.model.Album;
import com.example.songr.model.Song;
import com.example.songr.repository.AlbumRepository;
import com.example.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;


@Controller
public class SongController {

    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/songs")
    public String getSongRepository(Model model) {
        model.addAttribute("songs",songRepository.findAll());
        return "songs.html";
    }

     @GetMapping("addSong")
     public String addSongView(){
        return "addSong.html";
     }

    @PostMapping("/song")
    public RedirectView addSongToAlbum(@RequestParam(value = "title") String title,
                                             @RequestParam(value = "length") Integer length,
                                             @RequestParam(value = "trackNumber")Integer trackNumber,
                                             @RequestParam(value = "albumID" ) Integer albumId){

        Album album = albumRepository.findById(albumId).get();
        System.out.println(albumId);
        Song song = new Song(title,length, trackNumber, album);
        songRepository.save(song);

        return new RedirectView("/songs");
    }

    @GetMapping("/song/{param}")
    public String getOneSong(Model model, @PathVariable("param") Integer id){
        Song song =  songRepository.findById(id).get();
        model.addAttribute("song",song);
        return "viewOneSong.html";
    }
}