package app.birdlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import app.birdlist.entity.Version;

@Repository
@EnableJpaRepositories
public interface VersionRepository extends JpaRepository<Version, Integer> {
    @Query("SELECT v.character_image FROM Version v WHERE v.id = ?1")
    public byte[] getImage(Integer id);
}
