package com.alexistdev.mygudang.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonStatus {
    String responseCode;
    String responseDesc;

    public CommonStatus() {
    }

    public CommonStatus(String responseCode, String responseDesc) {
        this.responseCode = responseCode;
        this.responseDesc = responseDesc;
    }
}
