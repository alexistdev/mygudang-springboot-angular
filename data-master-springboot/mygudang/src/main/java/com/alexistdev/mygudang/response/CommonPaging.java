package com.alexistdev.mygudang.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;


@NoArgsConstructor
public class CommonPaging<T> {
    List<T> data;
    int page;
    int rowPerPage;
    long totalData;

    public CommonPaging(Page<T> data) {
        this.data = data.getContent();
        this.page = data.getNumber();
        this.rowPerPage = data.getSize();
        this.totalData = data.getTotalElements();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRowPerPage() {
        return this.rowPerPage;
    }

    public void setRowPerPage(int rowPerPage) {
        this.rowPerPage = rowPerPage;
    }

    public int getStartRow(){
        return this.page * this.rowPerPage;
    }

    public long getTotalData() {
        return this.totalData;
    }

    public void setTotalData(long totalData) {
        this.totalData = totalData;
    }
}
