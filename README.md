# 마이 셀렉트 샵

1. 키워트로 상품의 정보 검색
    1. 네이버 쇼핑 API 이용 (https://developers.naver.com/docs/serviceapi/search/shopping/shopping.md#%EC%87%BC%ED%95%91)
    2. 상품 이름(title), 링크 URL(link), 이미지(image), 최저가(lprice)
2. 관심 상품 등록하기 
    1. DB에 상품 정보 입력 (Insert)
        - 상품 이름(title), 링크 URL(link), 이미지(image), 최저가(lprice)
        - 희망 최저가(myprice) -> 0원으로 설정
3. 관심 상품의 "희망 최저가" 설정하기
    1. DB 업데이트 (update)
        -  등록된 관심상품의 "희망최저가"(myprice)만 업데이트
4. 관심 상품 조회하기기
    1. DB 조회 (select)
        - 등록된 모든 관심 상품 정보 조회
    2. UI에 '최저가' 표시조건
        - 희망하는 최저가보다 실제 최저가가 낮은 경우
