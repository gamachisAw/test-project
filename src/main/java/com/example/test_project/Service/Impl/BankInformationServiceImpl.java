package com.example.test_project.Service.Impl;

import com.example.test_project.Model.BankInformation;
import com.example.test_project.Repository.BankInformationRepository;
import com.example.test_project.Service.BankInformationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BankInformationServiceImpl implements BankInformationService {

    @Autowired
private final BankInformationRepository bankInformationRepository;

    @Override
    public void saveBankInformation(BankInformation bankInformation){
     bankInformationRepository.save(bankInformation);
    }
    @Override
    public List<BankInformation> getAllBankInformation(){
        return  bankInformationRepository.findAll();
    }
    @Override
    public void deleteBankInformation(Long id){bankInformationRepository.deleteById(id);
    }
    @Override
    public void updateBankInformation(BankInformation bankInformation, long id) {
        BankInformation bankInformation1 = bankInformationRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        bankInformation1.setBankName(bankInformation.getBankName());
        bankInformation1.setUserID(bankInformation.getUserID());
        bankInformation1.setAccountType(bankInformation.getAccountType());
        bankInformation1.setBankAccountNumber(bankInformation.getBankAccountNumber());
        bankInformationRepository.save(bankInformation1);
    }

}
