package backend

import common.User
import common.printPlatformHello
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType.TEXT_EVENT_STREAM
import org.springframework.web.reactive.function.server.*
import java.net.URI

@FlowPreview
@SpringBootApplication
class Application {

	private val users = listOf(
			User("Foo", "Foo"),
			User("Bar", "Bar"),
			User("Baz", "Baz"))

	@Bean
	fun routes() = coRouter {
		GET("/") { permanentRedirect(URI("/index.html")).buildAndAwait() }

		(GET("/api/users") and accept(TEXT_EVENT_STREAM)) {
      ok().sse().bodyAndAwait(flow {
        while(true) {
          delay(100)
          emit(users.random())
        }
      })
		}
	}
}

@FlowPreview
fun main(args: Array<String>) {
    runApplication<Application>(*args)
  printPlatformHello()
}