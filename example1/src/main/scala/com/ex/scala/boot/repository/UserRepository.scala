package com.ex.scala.boot.repository

import com.ex.scala.boot.entity.User

import org.springframework.stereotype.Repository
import org.springframework.data.repository.CrudRepository
import java.lang.Long

@Repository
trait UserRepository extends CrudRepository[User, Long] {

  def findUserByUsername(username: String): User

}
