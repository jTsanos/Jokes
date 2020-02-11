package com.nostsa.jokes;

public class Joke {

    String type;
    String category;
    String setup;
    String delivery;
    String onejoke;


public Joke(){

}



    public Joke(String type,String category,String setup,String delivery ){
    this.type=type;
    this.category=category;
    this.setup=setup;
    this.delivery=delivery;


    }





    public Joke(String type,String category,String onejoke ){
        this.type=type;
        this.category=category;
        this.onejoke=onejoke;


    }



    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public String getSetup() {
        return setup;
    }



    public String getDelivery()
    {
        return delivery;
    }


    public String getOnejoke() {
        return onejoke;
    }
}
