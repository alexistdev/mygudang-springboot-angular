package com.alexistdev.mygudang.response;

public class CommonResponsePaging<T> {
    CommonStatus responseStatus;

    String requestId;

    CommonPaging<T> paging;

    public CommonResponsePaging() {
        this.responseStatus = new CommonStatus("200", "SUCCESS");
    }

    public CommonResponsePaging(CommonPaging<T> paging) {
        this();
        this.paging = paging;
    }

    public CommonResponsePaging(CommonStatus status) {
        this.responseStatus = status;
    }

    public CommonStatus getResponseStatus() {
        return this.responseStatus;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public CommonPaging<T> getPaging() {
        return this.paging;
    }

    public void setResponseStatus(CommonStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setPaging(CommonPaging<T> paging) {
        this.paging = paging;
    }
}
