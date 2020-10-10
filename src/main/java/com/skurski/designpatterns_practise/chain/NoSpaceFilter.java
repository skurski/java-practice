package com.skurski.designpatterns_practise.chain;

public class NoSpaceFilter extends BaseFilter {

    @Override
    public void handle(Request request) {
        System.out.println("No space filter");
        request.setName(request.getName().replace(" ", ""));

        super.handle(request);
    }
}
