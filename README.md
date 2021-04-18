# Songr project
a web application using Spring MVC, Thymeleaf for rendering, and java as the language.

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