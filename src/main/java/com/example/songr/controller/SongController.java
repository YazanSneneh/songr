package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SongController {

    @Autowired
    SongRepository songRepository;

    @GetMapping("/songs")
    public String getSongRepository(Model model) {
        model.addAttribute("songs",songRepository.findAll());
        return "songs.html";
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<Song> getOneSong(Model model, @PathVariable("id") Integer id){
                 Song song =  songRepository.findById(id).get();
        return new ResponseEntity(song, HttpStatus.OK);
    }

    @PostMapping("/addSong")
    public ResponseEntity<Song> addSongToAlbum(@RequestParam(value = "title") String title,
                                               @RequestParam(value = "length") Integer length,
                                               @RequestParam(value = "trackNumber")Integer trackNumber,
                                               @RequestParam(value = "album" )Album album){
            Song song = new Song(title,length,trackNumber,album);
            songRepository.save(song);

        return new ResponseEntity(song, HttpStatus.OK);
    }

}
