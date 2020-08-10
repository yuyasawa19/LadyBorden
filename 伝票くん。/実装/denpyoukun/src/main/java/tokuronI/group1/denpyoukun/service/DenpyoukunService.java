package tokuronI.group1.denpyoukun.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tokuronI.group1.denpyoukun.entity.Dish;
import tokuronI.group1.denpyoukun.entity.Request;
import tokuronI.group1.denpyoukun.entity.Resident;
import tokuronI.group1.denpyoukun.repository.DishRepository;
import tokuronI.group1.denpyoukun.repository.RequestRepository;

@Service

public class DenpyoukunService {

    @Autowired
    RequestRepository rr; // レポジトリ
    DishRepository dr;

    // 要望の保存して、保存したものを返す TODO
    public Request postRequest(Request r) {
        return r;
    }

    // 全居住者を取得する TODO
    public List<Resident> getAllResident() {
        // 全居住者を取得する TODO
        List<Resident> list = new ArrayList<Resident>();
        list.add(new Resident(-1L, "testUser", "null"));// テスト用データを投入

        return list;
    }

    // idから料理情報を取得する TODO
    public Dish getDishById(Long id) {
        // idから料理情報を取得する TODO
        Optional<Dish> found = dr.findById(id);
        if(found.isPresent()){
            return found.get();
        }

        return new Dish(-2L, "カテゴリテスト", new Date(), "絵");// 料理のテストデータ

    }

    // // 特定の呟きを検索
    // public List<Tsubuyaki> findTsubuyaki(String word) {
    // Iterable<Tsubuyaki> found = repo.findByCommentLike("%" + word + "%");
    // ArrayList<Tsubuyaki> list = new ArrayList<>();
    // found.forEach(list::add);
    // return list;
    // }

    // // つぶやきを投稿
    // public Tsubuyaki postTsubuyaki(Tsubuyaki t) {
    // // 名前がない場合の業務ロジック

    // String name = t.getName();
    // if (name == null || name.length() == 0) {
    // t.setName("名無しさん");
    // }
    // t.setCreatedAt(new Date()); // 作成日時をセット
    // return repo.save(t); // セーブしたオブジェクトを返却
    // }

    // // 全つぶやきを取得
    // public List<Tsubuyaki> getAllTsubuyaki() {
    // Iterable<Tsubuyaki> found = repo.findAll();
    // ArrayList<Tsubuyaki> list = new ArrayList<>();
    // found.forEach(list::add);
    // return list;
    // }

    // // 特定の呟きを検索
    // public List<Tsubuyaki> findTsubuyaki(String word) {
    // Iterable<Tsubuyaki> found = repo.findByCommentLike("%" + word + "%");
    // ArrayList<Tsubuyaki> list = new ArrayList<>();
    // found.forEach(list::add);
    // return list;
    // }
}
