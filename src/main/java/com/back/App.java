package com.back;

import com.back.domain.system.controller.SystemController;
import com.back.domain.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    private final Scanner scanner = new Scanner(System.in);

    // 진입점 시작
    public void run() {
        System.out.println("== 명언 앱 ==");

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();
            Rq rq = new Rq(cmd);

            // 모던 switch문
            switch (rq.getActionName()) {
                case "종료" -> {
                    systemController.actionsExit();
                    return;
                }
                case "목록" -> wiseSayingController.actionList();
                case "등록" -> wiseSayingController.actionWrite();
                case "삭제" -> wiseSayingController.actionDelete(rq);
                case "수정" -> wiseSayingController.actionModify(rq);
            }
        }
    }
    // 진입점 끝
}
