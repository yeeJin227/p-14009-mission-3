package com.back.domain;

import com.back.domain.system.controller.SystemController;
import com.back.domain.wiseSaying.controller.WiseSayingController;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;
import com.back.domain.wiseSaying.service.WiseSayingService;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// 시스템 전반적으로 공유되는 객체들을 모아둔 클래스.
// static으로 객체를 정의.
public class AppContext {
    // 여기저기서 공유되는 객체들
    public static final Scanner scanner;
    public static final DateTimeFormatter forPrintDateTimeFormatter;

    // 1개만 있어야하거나, 1개만 있어도 되는 객체들 ( wiseSaying이나 Rq클래스 같은 객체는 2개 이상 존재 가능하므로, AppContext에 등록 x)
    public static final WiseSayingRepository wiseSayingRepository;
    public static final WiseSayingService wiseSayingService;
    public static final WiseSayingController wiseSayingController;
    public static final SystemController systemController;



    // static 블록 이용 ( 위에서 ststic 필드 초기화가 복잡해졌으므로 static 블록으로 뺌 )
    static {
        scanner = new Scanner(System.in);
        forPrintDateTimeFormatter = DateTimeFormatter.ofPattern(("yy-MM-dd HH:mm:ss"));
        wiseSayingRepository = new WiseSayingRepository();
        wiseSayingService = new WiseSayingService();
        wiseSayingController = new WiseSayingController();
        systemController = new SystemController();
    }
}
