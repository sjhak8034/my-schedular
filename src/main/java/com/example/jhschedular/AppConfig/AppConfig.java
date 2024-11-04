package com.example.jhschedular.AppConfig;

import com.example.jhschedular.Handler.HandlerForDeleteSchedule;
import com.example.jhschedular.Handler.HandlerForEditSchedule;
import com.example.jhschedular.Handler.HandlerForPostSchedule;
import com.example.jhschedular.Handler.HandlerForViewSchedule;
import com.example.jhschedular.Handler.HandlerForViewScheduleListByDate;
import com.example.jhschedular.body.RequestBodies;

public class AppConfig {

    public RequestBodies.RequestBodyToPost requestBodyToPost(){
        return new RequestBodies.RequestBodyToPost();
    }
    public RequestBodies.RequestBodyToEdit requestBodyToEdit(){
        return new RequestBodies.RequestBodyToEdit();
    }



    public HandlerForPostSchedule handlerForPostSchedule(RequestBodies.RequestBodyToPost requestBodyToPost){
        return new HandlerForPostSchedule(requestBodyToPost);
    }
    public HandlerForEditSchedule handlerForEditSchedule(RequestBodies.RequestBodyToPost requestBodyToPost){
        return new HandlerForEditSchedule(requestBodyToPost);
    }
    public HandlerForViewScheduleListByDate handlerForViewScheduleListByDate(RequestBodies.RequestBodyToPost requestBodyToPost){
        return new HandlerForViewScheduleListByDate(requestBodyToPost);
    }
    public HandlerForViewSchedule handlerForViewSchedule(RequestBodies.RequestBodyToPost requestBodyToPost){
        return new HandlerForViewSchedule(requestBodyToPost);
    }
    public  HandlerForDeleteSchedule handlerForDeleteSchedule(RequestBodies.RequestBodyToPost requestBodyToPost){
        return new HandlerForDeleteSchedule(requestBodyToPost);
    }
}
