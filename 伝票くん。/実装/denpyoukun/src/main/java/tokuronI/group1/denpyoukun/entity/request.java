package tokuronI.group1.denpyoukun.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; // 要望エンティティの識別子
    String name; // 要望した人の名前
    String category; // 料理の種類
    String option; // その他の要望
    Date plan; // 料理の提供予定日時
}
