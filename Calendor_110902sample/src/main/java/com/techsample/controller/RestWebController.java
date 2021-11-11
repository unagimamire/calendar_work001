package com.techsample.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techsample.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/api/event")
public class RestWebController {

    /**
     * カレンダーに表示するEvent情報を取得
     * @return Event情報をjsonエンコードした文字列
     */
    @GetMapping(value = "/all")
    public String getEvents() {
        String jsonMsg = null;
        try {
            List<Event> events = new ArrayList<Event>();
            Event event = new Event();
            event.setTitle("first event");
            event.setStart("2017-10-01");
            events.add(event);

            event = new Event();
            event.setTitle("second event");
            event.setStart("2017-10-11");
            event.setEnd("2017-10-12");
            events.add(event);

            // FullCalendarにエンコード済み文字列を渡す
            ObjectMapper mapper = new ObjectMapper();
            jsonMsg =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(events);
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
        return jsonMsg;
    }
}