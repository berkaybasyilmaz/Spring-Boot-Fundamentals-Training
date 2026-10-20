package com.trainingspring.application.receivables.presentation;

import com.trainingspring.application.receivables.business.AccountDto;
import com.trainingspring.application.receivables.business.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// InsertRequest ve Response yöntemiyle yapıldı. Klasik değil.
@RequestMapping("/receivable")
public class AccountController {

    private final AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account/create")
    public AccountInsertResponse createAccount (AccountInsertRequest request) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountName(request.getAccountName());
        accountDto.setTotalBalance(request.getTotalBalance());

        String accountId = accountService.create(accountDto);

        AccountInsertResponse response = new AccountInsertResponse();
        response.setAccountId(accountDto.getAccountId());
        return  response;

    }

}
