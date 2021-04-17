package com.javi.uned.pfgweb.repositories;

import com.javi.uned.pfgweb.beans.Sheet;
import com.javi.uned.pfgweb.beans.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SheetRepository extends JpaRepository<Sheet, Integer> {


    @Query(nativeQuery = true, value = "SELECT * FROM sheets WHERE name REGEXP ?1 OR style REGEXP ?1")
    Page<Sheet> find(String text, PageRequest of);

}
