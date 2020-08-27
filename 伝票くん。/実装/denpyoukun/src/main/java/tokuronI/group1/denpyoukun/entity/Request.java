package tokuronI.group1.denpyoukun.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; // 要望エンティティの識別子
    String name; // 要望した人の名前
    String category; // 料理の種類
    String opt; // その他の要望
    @Temporal(TemporalType.TIMESTAMP)
    Date plan; // 料理の提供予定日時
}
