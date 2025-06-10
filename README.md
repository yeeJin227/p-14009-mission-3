# 명언 게시판 - 레이어드 아키텍처 적용


- **Main Application**  
  - `App` - 사용자 명령어를 받아 '컨트롤러'로 요청 전달  
  - `Main` - 프로그램 진입점

- **Controller**: 사용자 입력을 받아 '서비스에 처리를 요청'하고 그 결과를 출력.  
  - `SystemController` - 시스템 관련 기능 (프로그램 종료)  
  - `WiseSayingController` - 명언 관련 기능 (등록, 목록, 수정, 삭제)

- **Service**: 내부 로직을 처리, 'Repository에 데이터 요청'.  
  - `WiseSayingService` - 명언 관련 로직 기능
    
- **Repository**: 데이터 저장소 역할, 명언 데이터 관리.  
  - `WiseSayingRepository` - 명언 저장, 목록조회, 삭제, 수정 기능

- **Domain**: 공통으로 사용되는 도메인 모델 / 공유 객체  
  - `WiseSaying` - 명언 도메인 클래스 (id, 내용, 작가, 생성/수정 날짜 포함)  
  - `AppContext` - 싱글톤 패턴으로 여러 객체 공유 (스캐너, 컨트롤러, 서비스, 레포지토리 등)

- **Request Parser**  
  - `Rq` - 명령어 파싱 , 쿼리 파라미터 관리

