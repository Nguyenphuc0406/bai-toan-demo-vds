/*
package com.example.demo.service.impl;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.security.jwt.CustomUserDetails;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements UserDetailsService,AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public BaseResponse addAccount() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String name) {
        Account account = accountRepository.findByAccountName(name);
        if (account == null){
            throw new UsernameNotFoundException(name);
        }
        return new CustomUserDetails(account);
    }
}
*/
