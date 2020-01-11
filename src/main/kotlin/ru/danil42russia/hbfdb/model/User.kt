package ru.danil42russia.hbfdb.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var user_id: Long? = 0,

        @Column(nullable = false, unique = true)
        @NotNull
        var login: String? = "",

        @Column(nullable = false)
        @NotNull
        var password: String? = ""
)
