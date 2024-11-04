package com.example.jhschedular.Handler;

import com.example.jhschedular.body.RequestBodies;

public class HandlerForViewSchedule {
    RequestBodies.RequestBodyToPost requestBodyToPost;
    public HandlerForViewSchedule(RequestBodies.RequestBodyToPost requestBodyToPost){
        this.requestBodyToPost = requestBodyToPost;
    }
    public void saveToDatabase(){

    }
    public int getId(){
        return 0;
    }
}
