package tokuronI.group1.denpyoukun.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

public class RequestForm {

    String name; // 要望した人の名前
    String category; // 料理の種類
    String option; // その他の要望
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date plan; // 料理の提供予定日時
}