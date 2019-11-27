package com.simple.repository

import com.simple.domain.Person
import org.springframework.data.mongodb.repository.MongoRepository

interface PersonRepository : MongoRepository<Person, String> {
    fun findOneById(id: String): Person = id?.let { findById(it).orElse(null) }
}