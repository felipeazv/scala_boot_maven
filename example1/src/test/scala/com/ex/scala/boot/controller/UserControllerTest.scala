package com.ex.scala.boot.controller

import java.util.Arrays

import com.ex.scala.boot.entity.User

import org.apache.tomcat.util.codec.binary.Base64
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.{HttpEntity, HttpHeaders, MediaType}
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerTest {

  @Autowired var template: TestRestTemplate = _

  @Test
  def whenPost_thenCreateUser() = {
    val headers = new HttpHeaders
    headers.add("Authorization", "Basic " + new String(Base64.encodeBase64(("root" + ":" + "root").getBytes())))
    headers.setContentType(MediaType.APPLICATION_JSON)
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON))
    val user = new User
    user.setId(101L)
    user.setUsername("Test")
    user.setPassword("Test")
    user.setEnabled(true)
    val entity = new HttpEntity(user, headers)
    val result = template.postForObject("/api/users", entity, classOf[String])
    println(result)
  }

}