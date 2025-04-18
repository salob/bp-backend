package com.bp.api

import com.bp.api.model.Tip
import com.bp.api.repository.TipRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DatabaseSeeder implements CommandLineRunner {

    private final TipRepository tipRepository

    DatabaseSeeder(TipRepository tipRepository) {
        this.tipRepository = tipRepository
    }

    @Override
    void run(String... args) throws Exception {
        if (tipRepository.count() == 0) {
            tipRepository.saveAll([
                new Tip(category: "Low", tip: "Increase your fluid intake."),
                new Tip(category: "Ideal", tip: "Maintain a balanced diet."),
                new Tip(category: "PreHigh", tip: "Exercise regularly."),
                new Tip(category: "High", tip: "Reduce salt intake.")
            ])
            println "Database preloaded with tips for each category."
        } else {
            println "Database already contains data. Skipping preload."
        }
    }
}