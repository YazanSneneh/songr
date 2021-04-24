package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

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
    public String albumRoute(){
        return "addAlbum.html";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(@RequestParam("title")String title,
                                 @RequestParam("artist") String artist,
                                 @RequestParam("countSongs")int countSongs,
                                 @RequestParam("length")int length,
                                 @RequestParam("imageURL")String image
                                 ){

        Album album = new Album(title,artist,countSongs,length,image);
        albumRepository.save(album);

        return  new RedirectView("/albums");
    }

}

