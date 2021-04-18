package com.example.songr;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@org.springframework.stereotype.Controller
public class Controller {

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

            List<Album> albums = new ArrayList<>();

            albums.add(LifeForRent);
            albums.add(StillOnMyMind);
            albums.add(andJusticeForAll);


            model.addAttribute("albums",albums);


        return "albums.html";
    }

}
