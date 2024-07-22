package com.study.ssr.controller;

import com.study.ssr.model.Dvd;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DvdController {

    // 자동으로 mvc 패턴을 가지게 만듦, 밑의 코드를 줄일 수 있음 / 리턴이 String이면 무조건 view
    @GetMapping("/dvds")
    public String dvdListPage(Model model) {
        Dvd dvd = Dvd.builder()
                .title("테스트")
                .producer("테스트 제작사")
                .publisher("테스트 발행사")
                .build();
        Dvd dvd2 = Dvd.builder()
                .title("테스트2")
                .producer("테스트 제작사2")
                .publisher("테스트 발행사2")
                .build();
        Dvd dvd3 = Dvd.builder()
                .title("테스트3")
                .producer("테스트 제작사3")
                .publisher("테스트 발행사3")
                .build();
        model.addAttribute(dvd);  // 객체
        model.addAttribute("names", List.of("김준일", "김준이", "김준삼"));   // 리스트
        model.addAttribute("dvdList", List.of(dvd, dvd2, dvd3));   // 리스트
                            // key,   value
        model.addAttribute("title", "테스트 제목");  // 리터럴

        return "views/dvd_list";
    }

//    // 객체를 만들어서 사용하는 방법
//    public ModelAndView dvdListPage() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("/views/dvd_list");
//        return mav;
//    }

    @ResponseBody   // 문자열 그대로를 리턴
    @GetMapping("/dvds/body")
    public String getViewName() {
        return "views/dvd_list";
    }

    @ResponseBody   // 객체는 json 형태로 반환
    @GetMapping("/dvd")
    public Object getDvd() {
        Dvd dvd = Dvd.builder().title("테스트").producer("테스트 제작사").publisher("테스트 발행사").build();
        Dvd dvd2 = Dvd.builder().title("테스트2").producer("테스트 제작사2").publisher("테스트 발행사2").build();
        Dvd dvd3 = Dvd.builder().title("테스트3").producer("테스트 제작사3").publisher("테스트 발행사3").build();

        return List.of(dvd, dvd2, dvd3);
    }
}
