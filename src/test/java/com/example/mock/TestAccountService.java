package com.example.mock;

import com.example.test.mock.Account;
import com.example.test.mock.AccountService;
import com.example.test.mock.MockAccountManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAccountService {

    @Test
    public void testTransferOk() {
        Account senderAccount = new Account("1", 200);
        Account beneficiaryAccount = new Account("2", 100);
        MockAccountManager mockAccountManager = new MockAccountManager();
        mockAccountManager.addAccount("1", senderAccount);
        mockAccountManager.addAccount("2", beneficiaryAccount);

        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        accountService.transfer("1", "2", 50);

        assertEquals(150, senderAccount.getBalance());
        assertEquals(150, beneficiaryAccount.getBalance());
    }

}
