# Songr project
* a web application using Spring MVC, Thymeleaf for rendering, and java as the language.
* to run application from terminal use this command:  `./gradlew bootRun`
* or run inside application from IDE **press run button**.

* Routes :
  * to get all songs : `http://localhost:8080/songs`
  * to get one songs : `http://localhost:8080/song/{id}`
  * to get all albums : `http://localhost:8080/albums`
  * to get one album : `http://localhost:8080/album/{id}`
  * home page : `http://localhost:8080/`
  * hello page : `http://localhost:8080/hello`
  * capitalize page : `http://localhost:8080/capitalize/{param}`


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

**Running the application:**
* from application run the app from **play button**.
* from terminal : `./gradlew bootRun`
1. Navigate to `localhost:port8080` to  basic splash page.
2. Hello Router: `http://localhost:8080/hello`.
3. Captialize: `http://localhost:8080/capitalize/{String}`.
4. Albums list: `http://localhost:8080/albums`
5. Add New Album `http://localhost:8080/addAlbums`


## lab 12 update
 * Project source Structure:

```bash
.
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── songr
│   │               ├── SongrApplication.java
│   │               ├── controller
│   │               │   └── AlbumController.java
│   │               ├── model
│   │               │   └── Album.java
│   │               └── repository
│   │                   └── AlbumRepository.java
│   └── resources
│       ├── application.properties
│       ├── static
│       │   └── style.css
│       └── templates
│           ├── addAlbum.html
│           ├── albums.html
│           ├── capitalize.html
│           ├── index.html
│           ├── songs.html
│           └── viewOneSong.html
└── test
    └── java
        └── com
            └── example
                └── songr
                    ├── AlbumTest.java
                    └── SongrApplicationTests.java

```
* `class interface AlbumRepository extends CrudRepository<Album,Integer>{}` has been added to create middleware object between controller and Database.
* Connected to postgresdb.
* Make `Album Class` Entity
* add routes to handle adding data from user.
* 
#### lab 13 update
* new Brand Class Has Been added called `class Song{}`.
* it has a relation One to Many with our `class Album{}`.
  * contain `title, length, songNumber` properties.
  * contain `Album object` to map 1 to many relationship.
* `class interface SongRepository extends CrudRepository<Song,Integer>{}` interface middleware with db.
* `SongController{}` class contain routes for song endpoints.


```java
@GetMapping("/songs")
    public String getSongRepository(Model model)
```
  * get one song route:
```java
@GetMapping("/songs/{id}")
    public ResponseEntity<Song> getOneSong(Model model, @PathVariable("id") Integer id)
```
  * Add song route:
```java
 @PostMapping("/addSong")
    public ResponseEntity<Song> addSongToAlbum(@RequestParam(value = "title") String title,
                                               @RequestParam(value = "length") Integer length,
                                               @RequestParam(value = "trackNumber")Integer trackNumber,
                                               @RequestParam(value = "album" )Album album)

```
