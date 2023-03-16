package com.alexistdev.mygudang.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse<T> {
    private CommonStatus responseStatus;
    private String requestId;
    T data;

    public CommonResponse() {
        this.responseStatus = new CommonStatus("00","SUCCESS");
    }

    public CommonResponse(CommonStatus status) {
        this.responseStatus = status;
    }

    public CommonResponse(T data) {
        this();
        this.data = data;
    }

    public CommonStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(CommonStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
