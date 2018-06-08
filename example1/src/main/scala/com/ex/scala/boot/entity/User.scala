package com.ex.scala.boot.entity

import java.io.Serializable
import java.lang.Long

import javax.persistence._

import scala.beans.BeanProperty

@Entity(name = "users")
class User extends Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _

  @BeanProperty
  @Column(name = "username")
  var username: String = _

  @BeanProperty
  @Column(name = "password")
  var password: String = _

  @BeanProperty
  @Column(name = "enabled")
  var enabled: Boolean = _

}
