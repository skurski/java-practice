package com.skurski.designpatterns_practise.chain;

public interface Filter {

    void setNext(Filter filter);

    void handle(Request request);
}
