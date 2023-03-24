package ru.sberleasing.api.models.createuser;

import lombok.Getter;

@Getter
public class SuccessfulResponse {
    private int code;
    private String type;
    private String message;
}
