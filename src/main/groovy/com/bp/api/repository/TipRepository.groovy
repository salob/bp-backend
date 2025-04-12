package com.bp.api.repository

import com.bp.api.model.Tip
import org.springframework.data.mongodb.repository.MongoRepository

interface TipRepository extends MongoRepository<Tip, String> {
    List<Tip> findByCategory(String category)
}
