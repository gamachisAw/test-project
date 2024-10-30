package com.example.test_project.Controller;

import com.example.test_project.Model.BankInformation;
import com.example.test_project.Service.BankInformationService;
import com.example.test_project.Service.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BankInformationController {

    @Value("${app.encryption.key}")
    private String encryptionKey;

    private final BankInformationService bankInformationService;

    @Autowired
    public BankInformationController(BankInformationService bankInformationService) {
        this.bankInformationService = bankInformationService;
    }

    @PostMapping("/save/BankInformation")
    public String saveBankInformation(@ModelAttribute BankInformation bankInformation) {
        try {
            String encryptedAccountNumber = EncryptionUtils.encrypt(bankInformation.getBankAccountNumber(), encryptionKey);
            bankInformation.setBankAccountNumber(encryptedAccountNumber);
            bankInformationService.saveBankInformation(bankInformation);
            return "Bank information saved successfully";
        } catch (Exception e) {
            return "Error saving bank information";
        }
    }

    @GetMapping("/bankInformation")
    public void getBankInformation(Model model) {
        try {
            List<BankInformation> getAllBankInformation = bankInformationService.getAllBankInformation();

            for (BankInformation bankInformation : getAllBankInformation) {
                String decryptedAccountNumber = EncryptionUtils.decrypt(bankInformation.getBankAccountNumber(), encryptionKey);
                bankInformation.setBankAccountNumber(decryptedAccountNumber);
            }

            model.addAttribute("ListOfBankInformation", getAllBankInformation);
        } catch (Exception e) {
            model.addAttribute("error", "Error retrieving bank information: " + e.getMessage());
        }
    }

    @PutMapping("/update/BankInformation/{id}")
    public String updateBankInformation(@PathVariable long id, @ModelAttribute BankInformation bankInformation) {
        try {
            String encryptedAccountNumber = EncryptionUtils.encrypt(bankInformation.getBankAccountNumber(), encryptionKey);
            bankInformation.setBankAccountNumber(encryptedAccountNumber);
            bankInformationService.updateBankInformation(bankInformation, id);
            return "Bank information updated successfully";
        } catch (Exception e) {
            return "Error updating bank information";
        }
    }

    @DeleteMapping("delete/BankInformation/{id}")
    public String deleteBankInformation(@PathVariable long id) {
        bankInformationService.deleteBankInformation(id);
        return "Bank information deleted successfully";
    }
}
