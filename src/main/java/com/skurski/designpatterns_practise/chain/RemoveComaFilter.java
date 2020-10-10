package com.skurski.designpatterns_practise.chain;

public class RemoveComaFilter extends BaseFilter {

    @Override
    public void handle(Request request) {
        System.out.println("Remove coma filter...");
        request.setName(request.getName().trim().replace(".", ""));

        super.handle(request);
    }
}
