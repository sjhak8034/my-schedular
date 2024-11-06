package com.example.jhschedular;


import com.example.jhschedular.dto.request.RequestDto;
import com.example.jhschedular.dto.response.ResponseDto;
import com.example.jhschedular.service.ScheduleService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    @PostMapping(value = "/schedules")
    public HttpEntity<String> requestBodyToPost(@RequestBody RequestDto.RequestToPostDto body) throws IOException {
        ResponseDto.ResponseToPostScheduleDto response = scheduleService.saveToDatabase(body);
        return new ResponseEntity<>(response.getResponseMessage(), HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(value = "/schedules/{scheduleId}")
    public HttpEntity<String> requestBodyToEdit(@RequestBody RequestDto.RequestToEditDto body, @PathVariable("scheduleId") String scheduleId) throws IOException {
        ResponseDto.ResponseToEditDto response = scheduleService.editToDatabase(body);

        return new ResponseEntity<>(response.getResponseMessage(), HttpStatus.OK);

    }

    @ResponseBody
    @GetMapping(value = "/schedules")
    public HttpEntity<List<ResponseDto.ResponseToSearchScheduleListDto>> requestBodyToViewScheduleListByDate(
            @RequestParam(value = "endDate",defaultValue = "9999-01-01" ) String endDate, @RequestParam(value = "startDate",defaultValue = "1000-01-01") String startDate, @RequestParam(value = "userName",defaultValue = "") String userName) throws IOException {

        List<ResponseDto.ResponseToSearchScheduleListDto> response = scheduleService.searchToDatabase(new RequestDto.RequestToSearchDto(startDate,endDate,userName));

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @ResponseBody
    @GetMapping(value = "/schedules/")
    public HttpEntity<Optional<ResponseDto.ResponseToViewScheduleDto>> requestBodyToViewSchedule(@RequestParam("scheduleId") Long scheduleId) throws IOException {

        Optional<ResponseDto.ResponseToViewScheduleDto> response = scheduleService.viewToDatabase(new RequestDto.RequestToViewDto(scheduleId)) ;

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @DeleteMapping(value = "/schedules/{scheduleId}")
    public HttpEntity<String> requestBodyToDelete(@PathVariable("scheduleId") Long scheduleId, @RequestBody RequestDto.RequestToDeleteDto body) throws IOException {
        ResponseDto.ResponseToDeleteScheduleDto response = scheduleService.deleteToDatabase(body);
        return new ResponseEntity<>(response.getResponseMessage(), HttpStatus.OK);

    }
}
