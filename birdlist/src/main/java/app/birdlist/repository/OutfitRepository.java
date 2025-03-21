package app.birdlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import app.birdlist.entity.Outfits;

@Repository
@EnableJpaRepositories
public interface OutfitRepository extends JpaRepository<Outfits, Integer> {
}