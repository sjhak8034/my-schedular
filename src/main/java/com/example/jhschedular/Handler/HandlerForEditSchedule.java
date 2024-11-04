package com.example.jhschedular.Handler;

import com.example.jhschedular.body.RequestBodies;

public class HandlerForEditSchedule {
    RequestBodies.RequestBodyToPost requestBodyToPost;
    public HandlerForEditSchedule(RequestBodies.RequestBodyToPost requestBodyToPost){
        this.requestBodyToPost = requestBodyToPost;
    }
    public void saveToDatabase(){

    }
    public int getId(){
        return 0;
    }
}
