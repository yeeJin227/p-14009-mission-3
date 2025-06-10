package com.back.domain.wiseSaying.repository;

import com.back.WiseSaying;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private int lastId = 0;
    private final List<WiseSaying> wiseSayings = new ArrayList<>();


    public List<WiseSaying> findForList() {
        return wiseSayings.reversed();
    }

    public void save(WiseSaying wiseSaying) {
        // save는 WiseSayingService의 write메서드에서 최초의 생성할 때 사용되고
        // WiseSayingService의 modify메서드에서 수정할 때도 사용된다.
        // 그러므로 이 둘을 구분해서 처리해야한다.
        if (wiseSaying.isNew()) {
            // 새로 생성하는 명언일 때
            wiseSaying.setId(++lastId); // id는 따로 저장.
            LocalDateTime now = LocalDateTime.now();
            wiseSaying.setCreateDate(now);  // setCreateDate 메서드 호출.
            wiseSaying.setModifyDate(now); // setModifyDate 메서드 호출
            wiseSayings.add(wiseSaying);
        } else {
            // 명언을 수정할 때
            wiseSaying.setModifyDate(LocalDateTime.now()); // setModifyDate 메서드 호출
        }
    }

    public WiseSaying findById(int id) {
        return wiseSayings
                .stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public WiseSaying deleteById(int id) {
        WiseSaying deleteIndex = findById(id);

        // 명언 없을 때
        if (deleteIndex == null) return deleteIndex;

        wiseSayings.remove(deleteIndex);

        return deleteIndex;
    }
}
