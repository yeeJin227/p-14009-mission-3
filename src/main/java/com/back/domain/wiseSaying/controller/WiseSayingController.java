package com.back.domain.wiseSaying.controller;

import com.back.Rq;
import com.back.WiseSaying;
import com.back.domain.wiseSaying.service.WiseSayingService;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner scanner = new Scanner(System.in);
    WiseSayingService wiseSayingService = new WiseSayingService();

    // 내부 로직 처리 후 '출력'을 담당하는 action- 메서드들
    // 등록 시 출력 담당
    public void actionWrite() {
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();
        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();

        WiseSaying wiseSaying2 = wiseSayingService.write(content, author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying2.getId()));
    }

    // 목록 시 출력 담당
    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> forListWiseSayings = wiseSayingService.findForList();

        for (WiseSaying wiseSaying : forListWiseSayings) {
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }

    // 삭제 시 출력 담당
    public void actionDelete(Rq rq) {
        int id = rq.getParamAsInt("id",-1);

        if (id == -1) {
            System.out.println("id를 숫자로 입력해주세요.");
            return;
        }

        WiseSaying deletedIndex = wiseSayingService.delete(id);

        if (deletedIndex == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
    }

    // 수정 시 출력 담당
    public void actionModify(Rq rq) {
        int id = rq.getParamAsInt("id", -1);

        if (id == -1) {
            System.out.println("id를 숫자로 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        // 수정할 번허의 명언이 없을 때 예외처리
        if (wiseSaying == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        // 수정된 명언,작가 입력받기
        System.out.printf("명언(기존) : %s\n", wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();

        System.out.printf("작가(기존) : %s\n", wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();

        // 수정된 내용으로 값 대입
        wiseSayingService.modify(wiseSaying, content, author);
    }

}
