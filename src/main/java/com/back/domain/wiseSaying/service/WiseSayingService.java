package com.back.domain.wiseSaying.service;

import com.back.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private int lastId = 0;
    private final List<WiseSaying> wiseSayings = new ArrayList<>();

    // 내부 로직 메서드들
    // 등록 로직
    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(++lastId, author, content);

        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    // 목록 로직
    public List<WiseSaying> findForList() {
        return wiseSayings.reversed();
    }

    // 삭제 로직
    public WiseSaying delete(int id) {
        WiseSaying deleteIndex = findById(id);

        // 명언 없을 때
        if (deleteIndex == null) return deleteIndex;

        wiseSayings.remove(deleteIndex);

        return deleteIndex;
    }

    // 사용자가 삭제&수정하고자 하는 번호가 리스트의 몇 번째 인덱스인지 찾는 메서드
    public WiseSaying findById(int id) {
        return wiseSayings
                .stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // 수정 로직
    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
    }
}
