package br.com.fortbit.logserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.fortbit.logserver.domain.WebRequestLogs;

@Repository
public interface WebRequestLogsRepository extends JpaRepository<WebRequestLogs, Integer>, JpaSpecificationExecutor<WebRequestLogs>{

}
