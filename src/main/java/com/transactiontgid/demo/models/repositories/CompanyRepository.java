package com.transactiontgid.demo.models.repositories;

import com.transactiontgid.demo.models.entities.Company;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
  Optional<Company> findByLegalPersonRegistry(String legalPersonRegistry);
}
