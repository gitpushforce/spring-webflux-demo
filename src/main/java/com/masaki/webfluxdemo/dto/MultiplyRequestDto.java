package com.masaki.webfluxdemo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MultiplyRequestDto {
    private int first;
    private int second;
}
