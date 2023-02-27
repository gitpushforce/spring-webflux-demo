package com.masaki.webfluxdemo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Response {
    private LocalDate localDate = LocalDate.now();
    private int output;

    public Response(int output) {
        this.output = output;
    }
}
