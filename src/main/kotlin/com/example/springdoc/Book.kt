package com.example.springdoc

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Book (

  @Id
  val id: String = shortId(),

  var title: String = "",

  var author: String = ""

)
