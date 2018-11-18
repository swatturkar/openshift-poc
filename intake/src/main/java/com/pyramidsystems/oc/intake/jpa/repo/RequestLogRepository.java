package com.pyramidsystems.oc.intake.jpa.repo;

import com.pyramidsystems.oc.intake.jpa.entity.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by suhas on 11/18/2018.
 */

@Repository
public interface RequestLogRepository extends JpaRepository<RequestLog, String>{
}
