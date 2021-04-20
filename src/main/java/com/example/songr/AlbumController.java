package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class AlbumController {
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
