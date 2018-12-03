package com.pyramidsystems.oc.intake.jpa.repo;

import com.pyramidsystems.oc.intake.jpa.entity.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suhas on 11/18/2018.
 */

@Repository
public interface RequestLogRepository extends JpaRepository<RequestLog, String>{

    @Query("select l.text, count(1) from com.pyramidsystems.oc.intake.jpa.entity.RequestLog l group by l.text order by 1")
    List<Object[]> getCount();
}
