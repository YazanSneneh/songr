# Songr project
* a web application using Spring MVC, Thymeleaf for rendering, and java as the language.
* to run application from terminal use this command:  `./gradlew bootRun`
* or run inside application from IDE **press run button**.

* Understanding project strucutre
  * I have inside `src/main/java/com.example.songr` 3 classes,
    *  1 is the `SongrApplication()`.
    * second is `class Album()`.
      * `setters()` and `getters() `for each attributes.
      * consturctor `public Album()`\
      * `toString()`.
    * a router class that contain my web application routes
  * `resources/templates` contain my html files.
  * `resources/styles.css` contain the file styles.

Running the application:
1. Navigate to `localhost:port8080` to  basic splash page.
2. Hello Router: `http://localhost:8080/hello`.
3. Captialize: `http://localhost:8080/capitalize/{String}`.
4. Albums list: `http://localhost:8080/albums`


#### lab 12 update
* `private Integer id` has been added to album class entities.
* `class interface AlbumRepository extends CrudRepository<Album,Integer>{}` has been added to create middleware object between controller and Database.
* Connected to postgresdb.
* Make `Album Class` Entity

#### lab 13 update
* new Brand Class Has Been added called `class Song{}`.
* it has a relation One to Many with our `class Album{}`.
  * contain `title, length, songNumber` properties.
  * contain `Album object` to map 1 to many relationship.
* `class interface SongRepository extends CrudRepository<Song,Integer>{}` interface middleware with db.
* `SongController{}` class contain routes for song endpoints.
  * get all songs route
```
@GetMapping("/songs")
    public String getSongRepository(Model model)
```
  * get one song route:
```
@GetMapping("/songs/{id}")
    public ResponseEntity<Song> getOneSong(Model model, @PathVariable("id") Integer id)
```
  * Add song route:
```
 @PostMapping("/addSong")
    public ResponseEntity<Song> addSongToAlbum(@RequestParam(value = "title") String title,
                                               @RequestParam(value = "length") Integer length,
                                               @RequestParam(value = "trackNumber")Integer trackNumber,
                                               @RequestParam(value = "album" )Album album)

```

* connected to postgresdb.
