package tokuronI.group1.denpyoukun.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tokuronI.group1.denpyoukun.entity.Dish;
import tokuronI.group1.denpyoukun.entity.DishListDto;
import tokuronI.group1.denpyoukun.entity.Request;
import tokuronI.group1.denpyoukun.entity.Resident;
import tokuronI.group1.denpyoukun.repository.dishRepository;
import tokuronI.group1.denpyoukun.repository.requestRepository;
import tokuronI.group1.denpyoukun.repository.residentRepository;

@Service

public class DenpyoukunService {

    @Autowired
    dishRepository dishR;
    @Autowired
    requestRepository requestR;
    @Autowired
    residentRepository residentR;

    // 要望の保存して、保存したものを返す
    public Request postRequest(Request r) {
        return requestR.save(r);// セーブしたオブジェクトを返却
    }

    // 全居住者を取得する
    public List<Resident> getAllResident() {

        List<Resident> list = new ArrayList<Resident>();
        Iterable<Resident> found = residentR.findAll();

        // list.add(new Resident(-1L, "testUser", "null"));// テスト用データを投入
        found.forEach(list::add);
        return list;
    }

    // // idから料理情報を取得する
    // public List<Dish> getDishById(Long id) {

    // List<Dish> list = new ArrayList<Dish>();
    // Iterable<Dish> found = dishR.findAll();
    // found.forEach(list::add);
    // return list;

    // // 単品を取得するバージョン
    // // Optional<Dish> found = dishR.findById(id);
    // // if (found.isPresent()) {
    // // return found.get();
    // // }
    // // return new Dish(-2L, "カテゴリテスト", new Date(), "絵");// 料理のテストデータ

    // }

    // idから料理情報を取得する
    public DishListDto getDishDtoByName(Long id) {

        // idから居住者を特定
        Optional<Resident> r = residentR.findById(id);
        if (!r.isPresent()) {
            return null;
        }

        // 居住者名から要望を取得
        String name = r.get().getName();
        List<Request> requestList = new ArrayList<Request>();
        Iterable<Request> foundRequest = requestR.findByName(name);
        foundRequest.forEach(requestList::add);

        // 要望から、料理データを取得
        String category;
        Date date;
        List<Dish> dishList = new ArrayList<Dish>();
        ;
        Optional<Dish> d;
        for (Request request : requestList) {
            category = request.getCategory();
            date = request.getPlan();
            d = dishR.findByCategoryAndPlan(category, date);
            if (d.isPresent()) {// 存在したら追加
                d.get().setOpt(request.getOpt());// 表示用optionの追加
                dishList.add(d.get());
            } else {// 存在しないなら空を追加
                dishList.add(new Dish());
            }
        }

        return new DishListDto(dishList, r.get());

        // 単品を取得するバージョン
        // Optional<Dish> found = dishR.findById(id);
        // if (found.isPresent()) {
        // return found.get();
        // }
        // return new Dish(-2L, "カテゴリテスト", new Date(), "絵");// 料理のテストデータ

    }

    // 入力した居住者が存在するか確認する
    public Boolean residentIsPresent(String name) {
        return residentR.findByName(name).isPresent();
    }

    // 入力した日にそのカテゴリの料理が存在するか確認する
    public Boolean dishIsPresent(String category, Date date) {
        return dishR.findByCategoryAndPlan(category, date).isPresent();
    }

    // dbのデータの初期設定
    public void setUp() {

        // 料理データ
        dishR.save(new Dish(1L, "洋食", new Date(120, 8, 1), "9/1の洋食の画像", null));
        dishR.save(new Dish(2L, "和食", new Date(120, 8, 1), "9/1の和食の画像", null));
        dishR.save(new Dish(3L, "洋食", new Date(120, 8, 2), "9/2の洋食の画像", null));
        dishR.save(new Dish(4L, "和食", new Date(120, 8, 2), "9/2の和食の画像", null));
        dishR.save(new Dish(5L, "アラカルト", new Date(120, 8, 2), "9/2のアラカルトの画像", null));

        // 居住者データ
        residentR.save(new Resident(1L, "マンダ", "マンダさんの写真"));
        residentR.save(new Resident(2L, "澤", "澤さんの写真"));
        residentR.save(new Resident(3L, "中村", "中村さんの写真"));
    }

}
