package com.vpr.monopoly.realtymanager.service.impl;

import com.vpr.monopoly.realtymanager.service.BankService;
import com.vpr.monopoly.realtymanager.service.ServicesManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServicesManagerImpl implements ServicesManager {

    private boolean bankEnabled = true;

    private final BankService bankClient;


    private final BankService bankServiceImpl;


    @Override
    public BankService getBankService() {
        return bankEnabled ? bankClient : bankServiceImpl;
    }


    @Override
    public void checkConnect() {
        boolean bankEnabled = true;

        if(!bankClient.checkConnection()){
            bankEnabled = false;
        }

        this.bankEnabled = bankEnabled;

    }
}
