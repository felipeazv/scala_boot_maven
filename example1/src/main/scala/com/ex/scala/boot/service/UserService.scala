package com.ex.scala.boot.service

import java.lang.Iterable

import com.ex.scala.boot.entity.User
import com.ex.scala.boot.repository.UserRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.{PostAuthorize, PreAuthorize}
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired private val userRepository: UserRepository) {

  @PreAuthorize("hasRole('admin')")
  def listUsers(): Iterable[User] = {
    userRepository.findAll
  }

  @PreAuthorize("hasRole('user')")
  @PostAuthorize("returnObject.username==principal.username || hasRole('admin')")
  def getUser(id: Long): User = {
    userRepository.findOne(id)
  }

  @PreAuthorize("hasRole('admin')")
  def createUser(user : User): Long = {
    userRepository.save(user)
    user.id
  }

}
