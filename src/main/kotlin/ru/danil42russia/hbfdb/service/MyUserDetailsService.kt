package ru.danil42russia.hbfdb.service

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import ru.danil42russia.hbfdb.repository.UserRepository

@Service
class MyUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val result = userRepository.findByLogin(username)

        return User(result.login, result.password, true, true, true, true, emptyList())
    }
}