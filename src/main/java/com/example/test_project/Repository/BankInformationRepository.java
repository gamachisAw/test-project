package com.example.test_project.Repository;

import com.example.test_project.Model.BankInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankInformationRepository extends JpaRepository<BankInformation, Long> {

}
