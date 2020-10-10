package com.skurski.designpatterns_practise.chain;

public class BaseFilter implements Filter {

    private Filter next;

    @Override
    public void setNext(Filter filter) {
        this.next = filter;
    }

    @Override
    public void handle(Request request) {
        if (next != null) {
            next.handle(request);
        }
    }
}
