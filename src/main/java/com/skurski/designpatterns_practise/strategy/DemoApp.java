package com.skurski.designpatterns_practise.strategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoApp {

    public static void main(String[] args) {
        List<Contract> contracts = Stream.of(ContractType.values())
                .map(type -> ContractFactory.of(type))
                .collect(Collectors.toList());

        contracts.forEach(Contract::processPayment);
    }
}
