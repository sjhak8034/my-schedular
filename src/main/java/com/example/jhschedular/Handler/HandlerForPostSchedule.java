package com.example.jhschedular.Handler;

import com.example.jhschedular.body.RequestBodies;

public class HandlerForPostSchedule {
    RequestBodies.RequestBodyToPost requestBodyToPost;
    public HandlerForPostSchedule(RequestBodies.RequestBodyToPost requestBodyToPost){
        this.requestBodyToPost = requestBodyToPost;
    }
    public void saveToDatabase(){

    }
    public int getId(){
        return 0;
    }

}
