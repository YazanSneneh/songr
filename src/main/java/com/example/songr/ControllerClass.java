package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class ControllerClass {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld(){
       return "hello router";
    }

    @GetMapping("capitalize/{param}")
    public String smallToCapital(Model model, @PathVariable("param") String small){
        model.addAttribute("capital",small.toUpperCase());
          return "capitalize.html";
    }

    @GetMapping("/")
    public String homeRoute(){
        return "index.html";
    }

    @GetMapping("/albums")
     public String albumRoute(Model model){
            Album LifeForRent = new Album("Life for Rent","Dido",20,2,"https://cdn-s3.allmusic.com/release-covers/500/0001/041/0001041545.jpg");
            Album StillOnMyMind = new Album("Still on My Mind","Dido",5,2,"https://img.discogs.com/tjC-_aFPQn1E9b3eOd4qHzwXPd4=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/R-307805-1584293948-9468.jpeg.jpg");
            Album andJusticeForAll = new Album("And justice for all","Metallica",20,2,"https://cdn.europosters.eu/image/1300/textile-postermetallica-and-justice-for-all-i85083.jpg");

            model.addAttribute("albums",albumRepository.findAll());

        return "albums.html";
    }
   @GetMapping("/addAlbum")
   @ResponseBody
    public String getAddAlbumView(){
        return "addAlbum.html";
   }
   @GetMapping("/albums")
    public RedirectView addAlbumRouter(@RequestParam(value = "title") String title,
                                       @RequestParam(value = "artist")String artist,
                                       @RequestParam(value = "countSongs") int songCount,
                                       @RequestParam(value = "length")int length,
                                       @RequestParam(value = "imageURL") String imageUrl){

        Album album = new Album(title,artist,songCount,length,imageUrl);
        albumRepository.save(album);
        return new RedirectView("/students");
   }


}
