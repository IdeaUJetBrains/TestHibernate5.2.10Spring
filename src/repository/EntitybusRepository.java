package repository;

import java.util.List;

import entity.Entitybus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EntitybusRepository extends JpaRepository<Entitybus, Long> {

    /** No need to define findAll() here, because
     *  inherited from JpaRepository with many other basic JPA operations.**/
    //
//    public List<Entitybus> findAll();

    /** spring-jpa-data understands this method name,
     *  because it supports the resolution of specific keywords inside method names. **/
    public List<Entitybus> findByEnumberContainingIgnoreCase(String searchString);

    /** You can define a JPA query.**/
    @Query("select p from Entitybus p where p.enumber = :enumber")
    public List<Entitybus> findByEnumberIs(@Param("enumber") String enumber);

}

