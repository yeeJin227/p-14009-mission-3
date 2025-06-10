package com.back.domain.wiseSaying.service;

import com.back.WiseSaying;
import com.back.domain.AppContext;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;

// 서비스클래스는 레포지토리클래스에게만 요청 가능
public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository = AppContext.wiseSayingRepository;


    // 내부 로직 메서드들
    // 등록 로직
    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(content, author);

        wiseSayingRepository.save(wiseSaying);

        return wiseSaying;
    }

    // 목록 로직
    public List<WiseSaying> findForList() {
        return wiseSayingRepository.findForList();
    }

    // 삭제 로직
    public WiseSaying delete(int id) {
        return wiseSayingRepository.deleteById(id);
    }

    // 사용자가 삭제&수정하고자 하는 번호가 리스트의 몇 번째 인덱스인지 찾는 메서드
    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    // 수정 로직
    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        wiseSayingRepository.save(wiseSaying);
    }
}


