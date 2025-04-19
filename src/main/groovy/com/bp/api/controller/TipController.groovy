package com.bp.api.controller

import com.bp.api.model.Tip
import com.bp.api.repository.TipRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.query.Criteria

@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:5173"])
@RestController
@RequestMapping("/api")
class TipController {

    @Autowired
    TipRepository tipRepository

    @Autowired
    MongoTemplate mongoTemplate

/*     @PostMapping("/bptip")
    Tip addTip(@RequestBody Tip tip) {
        return tipRepository.save(tip)
    } */
    @PostMapping("/bptip")
    Tip addTip(@RequestBody Tip tip) {
        println "Saving tip: ${tip.category} - ${tip.tip}"
        def saved = tipRepository.save(tip)
        println "Saved with ID: ${saved.id}"
        return saved
    }

    @GetMapping("/bptip")
    Tip getRandomTipByCategory(@RequestParam("category") String category) {
        def aggregation = Aggregation.newAggregation(
            Aggregation.match(Criteria.where("category").is(category)),
            Aggregation.sample(1)
        )
        def result = mongoTemplate.aggregate(aggregation, "bp_tips", Tip)
        return result.getUniqueMappedResult()
    }

}
