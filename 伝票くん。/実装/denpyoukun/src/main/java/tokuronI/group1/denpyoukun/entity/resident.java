package tokuronI.group1.denpyoukun.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor

public class resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; // 居住者エンティティの識別子
    String name; // 居住者の名前
    String photo; // シリアライズ化された居住者の顔写真
    // List<String> allergy; // アレルギー情報
    // List<dish> record; // 過去の飲食した料理
}
