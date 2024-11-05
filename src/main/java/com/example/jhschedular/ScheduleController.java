package com.example.jhschedular;


import com.example.jhschedular.AppConfig.AppConfig;
import com.example.jhschedular.dto.request.RequestDto;
import com.example.jhschedular.dto.response.ResponseDto;

import com.example.jhschedular.service.ScheduleService;
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
import java.util.List;
import java.util.Optional;


@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;

    }

    @ResponseBody
    @RequestMapping(value = "/schedules", method = RequestMethod.POST)
    public HttpEntity<String> requestBodyToPost(@RequestBody RequestDto.RequestToPostDto body) throws IOException {
        ResponseDto.ResponseToPostScheduleDto response = scheduleService.saveToDatabase(body);
        String ResponseMessage = String.format("responseMessage : scheduleId: %d created", response.getScheduleId());
        return new ResponseEntity<>(ResponseMessage, HttpStatus.OK);

    }

    @ResponseBody
    @RequestMapping(value = "/schedules/{scheduleId}", method = RequestMethod.PUT)
    public HttpEntity<String> requestBodyToEdit(@RequestBody RequestDto.RequestToEditDto body, @PathVariable String scheduleId) throws IOException {
        ResponseDto.ResponseToEditDto response = scheduleService.editToDatabase(body);
        String ResponseMessage = String.format("responseMessage : scheduleId: %d updated", response.getScheduleId());
        return new ResponseEntity<>(ResponseMessage, HttpStatus.OK);

    }

    @ResponseBody
    @RequestMapping(value = "/schedules?start-date={startDate}&end-date={endDate}&user-name={userName}", method = RequestMethod.GET)
    public HttpEntity<List<ResponseDto.ResponseToSearchScheduleListDto>> requestBodyToViewScheduleListByDate(@PathVariable String endDate, @PathVariable String startDate, @PathVariable String userName) throws IOException {

        List<ResponseDto.ResponseToSearchScheduleListDto> response = scheduleService.searchToDatabase(new RequestDto.RequestToSearchDto(startDate,endDate,userName));

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @ResponseBody
    @RequestMapping(value = "/schedule/{scheduleId}", method = RequestMethod.GET)
    public HttpEntity<String> requestBodyToViewSchedule( @PathVariable Long scheduleId) throws IOException {

        Optional<ResponseDto.ResponseToViewScheduleDto> response = scheduleService.viewToDatabase(new RequestDto.RequestToViewDto(scheduleId)) ;
        if(response.isPresent()) {
            String ResponseMessage = String.format("responseMessage : scheduleId: %d view", response.get().getScheduleId());
            return new ResponseEntity<>(ResponseMessage, HttpStatus.OK);
        }
        String ResponseMessage = String.format("responseMessage : scheduleId: %d does not exist", scheduleId);
        return new ResponseEntity<>(ResponseMessage, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @RequestMapping(value = "/schedule/{scheduleId}", method = RequestMethod.DELETE)
    public HttpEntity<String> requestBodyToDelete(@PathVariable Long scheduleId, @RequestBody RequestDto.RequestToDeleteDto body) throws IOException {
        ResponseDto.ResponseToDeleteScheduleDto response = scheduleService.deleteToDatabase(body);

        String ResponseMessage = String.format("responseMessage : scheduleId: %d deleted", response.getScheduleId());
        return new ResponseEntity<>(ResponseMessage, HttpStatus.OK);

    }
}
