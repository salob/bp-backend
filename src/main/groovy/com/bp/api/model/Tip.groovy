package com.bp.api.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "bp_tips")
class Tip {
    @Id
    String id
    String category
    String tip
}
