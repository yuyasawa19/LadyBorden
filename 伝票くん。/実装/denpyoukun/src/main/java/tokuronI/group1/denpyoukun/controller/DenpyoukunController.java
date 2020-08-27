package tokuronI.group1.denpyoukun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tokuronI.group1.denpyoukun.service.DenpyoukunService;
import tokuronI.group1.denpyoukun.entity.DishListDto;
import tokuronI.group1.denpyoukun.entity.Resident;
import tokuronI.group1.denpyoukun.entity.Request;

@Controller
public class DenpyoukunController {
    @Autowired
    DenpyoukunService ds;

    // タイトル画面を表示
    @GetMapping("/")
    String showIndex() {
        return "index";
    }

    // トップ画面を表示
    @GetMapping("/top")
    String showTopMenu() {
        // DBの初期データを投入する
        ds.setUp();
        return "top";
    }

    // 要望入力画面を表示
    @GetMapping("/request")
    String showRequsetMenu(Model model) {
        model.addAttribute("requestForm", new requestForm()); // 空フォームをセット
        return "request";
    }

    // ユーザ選択画面を表示
    @GetMapping("/resident")
    String showResidentList(Model model) {
        List<Resident> list = ds.getAllResident(); // 全つぶやきを取得
        model.addAttribute("residentList", list); // モデル属性にリストをセット
        return "resident_list";
    }

    // ユーザの料理一覧を表示
    @GetMapping("/dish_list")
    String showResult(Model model, @RequestParam("id") Long id) {
        DishListDto dl = ds.getDishDtoByName(id);
        System.out.println(dl.getDishList());
        model.addAttribute("dishList", dl.getDishList());
        model.addAttribute("name", dl.getResident().getName());
        return "dish_list";
    }

    // ユーザの要望を保存
    @PostMapping("/postRequest")
    String postRequest(Model model, @ModelAttribute("requestForm") requestForm form) {

        // 居住者がいるか確認する
        if (!ds.residentIsPresent(form.getName())) {
            // 居住者が存在しないエラー
            model.addAttribute("error", form.getName() + "さんはいません、もう一度入力してください。");
            return "request";
        }

        // 居住者がいるか確認する
        if (!ds.dishIsPresent(form.getCategory(), form.getPlan())) {
            // 居住者が存在しないエラー
            model.addAttribute("error",
                    form.getPlan().toString() + " " + form.getCategory() + "のメニューはありません、もう一度入力してください。");
            return "request";
        }

        // フォームからエンティティに移し替え
        Request r = new Request();
        r.setName(form.getName());
        r.setCategory(form.getCategory());
        r.setOpt(form.getOption());
        r.setPlan(form.getPlan());

        // サービスに投稿処理を依頼
        ds.postRequest(r);

        // モデルに属性をセットする
        model.addAttribute("requestForm", form);

        return "success";
    }

    // // メイン画面を表示
    // @GetMapping("/read")
    // String showTsubuyakiList(Model model) {
    // List<Tsubuyaki> list = ts.getAllTsubuyaki(); // 全つぶやきを取得
    // model.addAttribute("tsubuyakiList", list); // モデル属性にリストをセット
    // model.addAttribute("tsubuyakiForm", new TsubuyakiForm()); // 空フォームをセット
    // return "tsubuyaki_list"; // リスト画面を返す
    //

    // // つぶやきを投稿
    // @PostMapping("/read")
    // String postTsubuyaki(@ModelAttribute("tsubuyakiForm") TsubuyakiForm form,
    // Model model) {

    // // フォームからエンティティに移し替え
    //
    // Tsubuyaki t = new Tsubuyaki();
    // t.setName(form.getName());
    // t.setComment(form.getComment());

    // // サービスに投稿処理を依頼
    // ts.postTsubuyaki(t);
    // return "redirect:/read"; // メイン画面に転送

    //

    // // つぶやきを検索
    // @GetMapping("/find")
    // String findTsubuyaki(@RequestParam(value = "keyWord", required = true) String
    // word, Model model) {

    // List<Tsubuyaki> list = ts.findTsubuyaki(word); // 条件に合う呟きを取得
    //
    // model.addAttribute("title", "検索結果"); // タイトルの表示
    // model.addAttribute("tsubuyakiList", list); // モデル属性にリストをセット
    // model.addAttribute("tsubuyakiForm", new TsubuyakiForm()); // 空フォームをセット
    // return "tsubuyaki_list"; // リスト画面を返す

    //

}
