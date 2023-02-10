package com.example.springdoc


import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
class Config {

  // fill the DB with some data at startup
  @Bean
  fun init(repository: BookRepository): ApplicationRunner {
    return ApplicationRunner {
      listOf(
        Pair("Kotlin tutorial", "ER"),
        Pair("Study Vue", "GF"),
      ).forEach { repository.save(Book(title = it.first, author = it.second)) }
      repository.findAll().forEach{ println(it) }
    }
  }

  @Bean
  @Throws(Exception::class)
  fun filterChain(http: HttpSecurity): SecurityFilterChain? {
    http.authorizeHttpRequests()
      .anyRequest().permitAll()
//      .anyRequest().authenticated().and().oauth2ResourceServer().jwt();
    return http.build()
  }

}
