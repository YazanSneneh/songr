package com.example.songr.controller;

import com.example.songr.model.Album;
import com.example.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;
    @PostMapping("/hello")
    @ResponseBody
    public String helloWorld(@RequestParam("name")String name){
        return "hello "+name;
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
    public RedirectView  addAlbum(@RequestParam("title")String title,
                                 @RequestParam("artist") String artist,
                                 @RequestParam("countSongs")int countSongs,
                                 @RequestParam("length")int length,
                                 @RequestParam("imageURL")String image
                                 ){

        Album album = new Album(title,artist,countSongs,length,image);
        albumRepository.save(album);

        return  new RedirectView("/albums");
    }

    @GetMapping("/album/{param}")
    public String viewAlbum(Model model, @PathVariable("param")int id){
        Album album = albumRepository.findById(id).get();
        model.addAttribute("album", album);
        return "viewOneAlbum.html";
    }

    @DeleteMapping("album/{id}")
    public RedirectView deleteAlbume(@PathVariable("id")int id){
        System.out.println("Item with id success delete: " + id);
        albumRepository.deleteById(id);
        return new RedirectView("/albums");
    }
    @PutMapping("album/{id}")
    public RedirectView updateAlbum(@PathVariable("id") int id,
                                     @RequestParam("title") String title,
                                    @RequestParam("artist") String  artist ,
                                    @RequestParam("countSongs") int songCount ,
                                    @RequestParam("length") int length){
        Album album = albumRepository.findById(id).get();
        album.setTitle(title);
        album.setArtist(artist);
        album.setSongCount(songCount);
        album.setLength(length);
        albumRepository.save(album);
        return new RedirectView("/album/"+id);
    }
}

