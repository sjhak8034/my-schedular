package com.example.jhschedular;


import com.example.jhschedular.AppConfig.AppConfig;
import com.example.jhschedular.Handler.HandlerForDeleteSchedule;
import com.example.jhschedular.Handler.HandlerForEditSchedule;
import com.example.jhschedular.Handler.HandlerForPostSchedule;
import com.example.jhschedular.Handler.HandlerForViewSchedule;
import com.example.jhschedular.Handler.HandlerForViewScheduleListByDate;
import com.example.jhschedular.body.RequestBodies;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class RequestController {
    @ResponseBody
    @RequestMapping(value = "/schedules", method = RequestMethod.POST)
    public HttpEntity<String> requestBodyToPost(@RequestBody RequestBodies.RequestBodyToPost body) throws IOException {
        AppConfig appConfig = new AppConfig();
        HandlerForPostSchedule handlerForPostingSchedule = appConfig.handlerForPostSchedule(body);

        String ResponseMessage = String.format("responseMessage : scheduleId: %d created", handlerForPostingSchedule.getId());
        return new ResponseEntity<>(ResponseMessage, HttpStatus.OK);

    }

    @ResponseBody
    @RequestMapping(value = "/schedules/{scheduleId}", method = RequestMethod.PUT)
    public HttpEntity<String> requestBodyToEdit(@RequestBody RequestBodies.RequestBodyToPost body, @PathVariable String scheduleId) throws IOException {
        AppConfig appConfig = new AppConfig();
        HandlerForEditSchedule handlerForEditSchedule = appConfig.handlerForEditSchedule(body);

        String ResponseMessage = String.format("responseMessage : scheduleId: %d created", handlerForEditSchedule.getId());
        return new ResponseEntity<>(ResponseMessage, HttpStatus.OK);

    }

    @ResponseBody
    @RequestMapping(value = "/schedules?start-date={startDate}&end-date={endDate}&user-name={userName}", method = RequestMethod.GET)
    public HttpEntity<String> requestBodyToViewScheduleListByDate(@RequestHeader HttpHeaders headers, @PathVariable String endDate, @PathVariable String startDate, @PathVariable String userName) throws IOException {
        AppConfig appConfig = new AppConfig();
        HandlerForViewScheduleListByDate handlerForViewScheduleListByDate = appConfig.handlerForViewScheduleListByDate(body);

        String ResponseMessage = String.format("responseMessage : scheduleId: %d created", handlerForViewScheduleListByDate.getId());
        return new ResponseEntity<>(ResponseMessage, HttpStatus.OK);

    }

    @ResponseBody
    @RequestMapping(value = "/schedule/{scheduleId}", method = RequestMethod.GET)
    public HttpEntity<String> requestBodyToViewSchedule( @PathVariable String scheduleId) throws IOException {
        AppConfig appConfig = new AppConfig();
        HandlerForViewSchedule handlerForViewSchedule = appConfig.handlerForViewSchedule(body);

        String ResponseMessage = String.format("responseMessage : scheduleId: %d created", handlerForViewSchedule.getId());
        return new ResponseEntity<>(ResponseMessage, HttpStatus.OK);

    }

    @ResponseBody
    @RequestMapping(value = "/schedule/{scheduleId}", method = RequestMethod.DELETE)
    public HttpEntity<String> requestBodyToDelete(@RequestHeader HttpHeaders headers, @PathVariable String scheduleId) throws IOException {
        AppConfig appConfig = new AppConfig();
        HandlerForDeleteSchedule handlerForDeleteSchedule = appConfig.handlerForDeleteSchedule(body);

        String ResponseMessage = String.format("responseMessage : scheduleId: %d created", handlerForDeleteSchedule.getId());
        return new ResponseEntity<>(ResponseMessage, HttpStatus.OK);

    }
}
