package app.birdlist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import app.birdlist.entity.Characters;

@Repository
@EnableJpaRepositories
public interface CharacterRepository extends JpaRepository<Characters, String> {
    @Query("SELECT c.name, c.description FROM Characters c")
    public List<String[]> withoutImage();

    @Query("SELECT c.profile_image FROM Characters c WHERE c.name = ?1")
    public byte[] getImage(String name);
}
