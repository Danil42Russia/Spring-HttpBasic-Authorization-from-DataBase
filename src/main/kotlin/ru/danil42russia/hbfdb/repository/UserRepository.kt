package ru.danil42russia.hbfdb.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.danil42russia.hbfdb.model.User

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByLogin(login: String): User
}