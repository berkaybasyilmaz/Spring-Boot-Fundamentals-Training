package com.trainingspring.application.receivables.business;

import com.trainingspring.application.receivables.data.Account;
import com.trainingspring.application.receivables.data.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public String create(AccountDto accountDto){
        Account account = toEntity(accountDto);
        accountRepository.save(account);
        return accountDto.getAccountId();
    }

    private Account toEntity(AccountDto accountDto){
       Account account = new Account();
       account.setAccountId(UUID.fromString(accountDto.getAccountId()));
       account.setAccountName(accountDto.getAccountName());
       account.setTotalBalance(accountDto.getTotalBalance());
       return account;

    }


}
