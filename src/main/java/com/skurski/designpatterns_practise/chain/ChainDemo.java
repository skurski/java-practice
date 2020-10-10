package com.skurski.designpatterns_practise.chain;

public class ChainDemo {

    public static void main(String[] args) {

        Request request = new Request("New request testing...");
        System.out.println(request.getName());

        RemoveComaFilter textFilter = new RemoveComaFilter();
        LowerCaseFilter sizeFilter = new LowerCaseFilter();
        NoSpaceFilter noSpaceFilter = new NoSpaceFilter();

        textFilter.setNext(sizeFilter);
        sizeFilter.setNext(noSpaceFilter);

        textFilter.handle(request);

        System.out.println(request.getName());
    }
}
