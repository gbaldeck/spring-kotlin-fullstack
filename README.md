Spring WebFlux Kotlin fullstack example with Kotlin/JS for frontend instead of JavaScript or TypeScript.

This is based on `https://github.com/sdeleuze/spring-kotlin-fullstack`. Special thanks to all the contributors on that project.

This project leverages [Kotlin multiplatform support](http://kotlinlang.org/docs/reference/multiplatform.html)
to share code between JS and JVM using a shared module.

To run the application, use `./gradlew bootRun` and go to `http://localhost:8080`

For development mode run the above and run `./gradlew :frontend:run -t` then go to `http://localhost:3000`

See the `shared` folder for how to use Kotlin Multiplatform. It's slightly different than how you would normally use it because there are 3 Gradle projects.
