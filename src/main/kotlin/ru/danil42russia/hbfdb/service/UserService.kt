package ru.danil42russia.hbfdb.service

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import ru.danil42russia.hbfdb.model.User
import ru.danil42russia.hbfdb.repository.UserRepository

@Service
class UserService(private val userRepository: UserRepository) {
    fun createUser(user: User): User {
        val oldPassword = user.password
        val hashPassword = BCryptPasswordEncoder().encode(oldPassword)
        user.password = hashPassword

        val result = userRepository.save(user)
        result.password = oldPassword

        return result
    }

    fun getUserById(id: Long): User {
        return userRepository.getOne(id)
    }

    fun userList(): List<User> {
        return userRepository.findAll()
    }
}