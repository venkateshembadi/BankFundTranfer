package com.training.fund.fundtransfer.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.fund.fundtransfer.entity.AccountStatement;

@Repository
public interface AccountStatementRepository extends JpaRepository<AccountStatement, Integer> {
	
	@Query("select a from AccountStatement a where a.date between :startDate AND :endDate")
	public List<AccountStatement> fetchAccountHistory(@Param("startDate")Date startDate,@Param("endDate")Date endDate);

}
