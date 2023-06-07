package com.example.sof3021_nhom1_ca4_lab7.Service;

import com.example.sof3021_nhom1_ca4_lab7.Model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountImp implements AccountDAO {
    public static List<Account> listAccount = new ArrayList<>();
    static {
        listAccount.add(new Account("lai","123",true));//Admin
        listAccount.add(new Account("minh","123",false));//Customer
    }

    @Override
    public Account getOne(String username) {
        Account account=new Account();
        if(username.isEmpty()||username=="") {
            account=null;
            return null;
        }
        for(Account item:listAccount) {
            if(item.getUsername().equalsIgnoreCase(username)) {
                account=item;
            }
        }
        return account;
    }
}
