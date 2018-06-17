package useCase

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class DemoApplication: SpringBootServletInitializer(){

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(DemoApplication::class.java)
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}
