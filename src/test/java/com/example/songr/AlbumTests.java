package com.example.songr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AlbumTests {
    Album andJusticeForAll = new Album("And justice for all","Metallica",20,2,"https://cdn.europosters.eu/image/1300/textile-postermetallica-and-justice-for-all-i85083.jpg");
    @Test
    public void constructorTest(){
       assertNotNull("SHould see album string" ,andJusticeForAll.toString());

    }
    @Test
    public void getTitleTest(){
       assertEquals("Should see album Title" ,andJusticeForAll.getTitle());

    }
    @Test
    public void SetTitleTest(){
        andJusticeForAll.setTitle("Some");
        assertEquals("Should see new  album title ", "Some" , andJusticeForAll.getTitle());
    }

    @Test
    public void getArtistTest(){
        assertEquals("SHould see album artist", "metallica" ,andJusticeForAll.getArtist());
    }
    @Test
    public void setArtistTest(){
        andJusticeForAll.setArtist("Yazan");
        assertEquals("update on artist expected ", "Yazan" ,andJusticeForAll.getArtist() );
    }
    @Test
    public void getCountTest(){
        assertEquals("SHould see album string", 20 ,andJusticeForAll.getSongCount());
    }
    @Test
    public void setCountTest(){
        andJusticeForAll.setSongCount(32);
        assertEquals("expected count after update: ", 32 ,andJusticeForAll.getSongCount());
    }
    public void getLengthUrlTest(){

        assertEquals("get the length : ", 2 ,andJusticeForAll.getLength());
    }
    public void setLengthUrlTest(){
        andJusticeForAll.setLength(111);
        assertEquals("expected length : ", 111 ,andJusticeForAll.getLength());
    }
    public void getImageUrlTest(){
        assertEquals("SHould see album string", "https://cdn.europosters.eu/image/1300/textile-postermetallica-and-justice-for-all-i85083.jpg" ,andJusticeForAll.getImageUrl());
    }
    public void setImageUrlTest(){
         andJusticeForAll.setImageUrl("default one");
        assertEquals("see updated path", "default one" ,andJusticeForAll.getImageUrl());
    }
}
