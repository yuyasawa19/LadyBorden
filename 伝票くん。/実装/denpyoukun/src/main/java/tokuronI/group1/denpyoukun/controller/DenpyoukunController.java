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
import tokuronI.group1.denpyoukun.entity.dish;
import tokuronI.group1.denpyoukun.entity.resident;

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
        return "top";
    }

    // 要望入力画面を表示
    @GetMapping("/request")
    String showRequsetMenu(Model model) {
        model.addAttribute("requestForm", new requestForm()); // 空フォームをセット
        return "request";
    }

    // 成功画面を表示 テスト用
    @GetMapping("/success")
    String showSuccessMenu() {
        return "success";
    }

    // ユーザ選択画面を表示 TODO
    @GetMapping("/resident")
    String showResidentList(Model model) {
        List<resident> list = ds.getAllResident(); // 全つぶやきを取得
        model.addAttribute("residentList", list); // モデル属性にリストをセット
        return "resident_list";
    }

    // ユーザの料理を表示 TODO
    @GetMapping("/result")
    String showResult(Model model, @RequestParam("id") Long id) {
        dish dish = ds.getDishById(id);
        model.addAttribute("dish", dish);
        return "result";
    }

    // ユーザの要望を保存 TODO
    @PostMapping("/postRequest")
    String postRequest(Model model, @ModelAttribute("requestForm") requestForm form) {

        // フォームからエンティティに移し替え TODO

        // サービスに投稿処理を依頼 TODO
        // ds.postRequest(***);

        // モデルに属性をセットする requestFormを返してるだけ TODO
        model.addAttribute("requestForm", form);

        // 失敗したらfailedに飛ばす 拡張機能としてメモ

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
