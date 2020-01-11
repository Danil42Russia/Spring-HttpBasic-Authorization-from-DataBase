package ru.danil42russia.hbfdb.controller

import org.springframework.web.bind.annotation.*
import ru.danil42russia.hbfdb.model.User
import ru.danil42russia.hbfdb.service.UserService

@RestController
@RequestMapping("/api/user")
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(
            @RequestBody user: User
    ): User {
        return userService.createUser(user)
    }

    @GetMapping("{id}")
    fun getUserById(
            @PathVariable id: Long
    ): User {
        return userService.getUserById(id)
    }

    @GetMapping
    fun getUsers(): List<User> {
        return userService.userList()
    }
}