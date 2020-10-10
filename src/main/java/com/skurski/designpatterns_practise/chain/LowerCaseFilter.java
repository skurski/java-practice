package com.skurski.designpatterns_practise.chain;

public class LowerCaseFilter extends BaseFilter {

    @Override
    public void handle(Request request) {
        System.out.println("Lower case filter...");
        request.setName(request.getName().toLowerCase());

        super.handle(request);
    }
}
