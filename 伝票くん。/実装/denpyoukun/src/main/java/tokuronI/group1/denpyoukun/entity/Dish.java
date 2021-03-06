package tokuronI.group1.denpyoukun.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; // 料理エンティティの識別子
    String category; // 料理の種類
    // List<String> menu; // 料理の内容
    // List<String> ingredient; // 成分情報
    // List<String> allergy; // アレルギー情報
    // List<String> replaceMenu; // アレルギー用の代替メニュー
    Date plan; // 提供予定日時
    String picture; // シリアライズ化された料理画像
    String opt;// その他の要望の表示用
}