package com.crm.service;

import com.crm.dto.AccountDto;
import com.crm.entity.Account;
import com.crm.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;
    
    public AccountDto createAccount(AccountDto accountDto) {
        // For now, return a mock account
        AccountDto mockAccount = new AccountDto();
        mockAccount.setAccountId(1L);
        mockAccount.setAccountName(accountDto.getAccountName());
        mockAccount.setEmail(accountDto.getEmail());
        mockAccount.setOrgId(accountDto.getOrgId());
        return mockAccount;
    }
    
    public List<AccountDto> getAccountsByOrganization(Long orgId) {
        // For now, return empty list
        return new ArrayList<>();
    }
    
    public AccountDto getAccountById(Long accountId) {
        // For now, return a mock account
        AccountDto mockAccount = new AccountDto();
        mockAccount.setAccountId(accountId);
        mockAccount.setAccountName("Mock Account");
        mockAccount.setEmail("mock@example.com");
        return mockAccount;
    }
    
    public AccountDto updateAccount(Long accountId, AccountDto accountDto) {
        // For now, return the updated DTO
        accountDto.setAccountId(accountId);
        return accountDto;
    }
    
    public void deleteAccount(Long accountId) {
        // For now, do nothing
    }
}
