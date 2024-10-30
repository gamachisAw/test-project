package com.example.test_project.Service;

import com.example.test_project.Model.BankInformation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankInformationService {
    void saveBankInformation(BankInformation bankInformation);
    List<BankInformation> getAllBankInformation();
    void deleteBankInformation(Long id);
    void updateBankInformation(BankInformation bankInformation, long id);
}
