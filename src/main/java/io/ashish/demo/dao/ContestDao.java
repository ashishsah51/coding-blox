package io.ashish.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.ashish.demo.entity.Contest;



@Repository
public interface ContestDao extends BaseDao<Contest>{
    @Query(value = "select * from contests where level = :level", nativeQuery = true)
    List<Contest> findAllContestByLevelSQL(String level);
}