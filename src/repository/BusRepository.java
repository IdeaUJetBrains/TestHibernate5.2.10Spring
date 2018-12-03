package repository;


import notentity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

    /** No need to define findAll() here, because
     *  inherited from JpaRepository with many other basic JPA operations.**/
    //
//    public List<Bus> findAll();

    /** spring-jpa-data understands this method name,
     *  because it supports the resolution of specific keywords inside method names. **/
    public List<Bus> findByNumberContainingIgnoreCase(String searchString);

    /** You can define a JPA query.**/
    @Query("select p from Bus p where p.number = :number")
    public List<Bus> findByNumberIs(@Param("number") String number);

}

