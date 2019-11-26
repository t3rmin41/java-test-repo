package com.simple

import org.springframework.data.mongodb.repository.MongoRepository

interface PersonRepository : MongoRepository<Person, String> {
    fun findOne(id: String): Person = id?.let { findById(it).orElse(null) }
}