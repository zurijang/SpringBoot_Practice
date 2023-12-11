package com.practice;

// Repository(DAO) 기능 정의
public interface HelloRepository {

	// name에 대한 오브젝트 조회
	Hello findHello(String name);
	
	// 데이터 가공 로직, 이름에 대한 카운트 증가
	void increaseCount(String name);
	
	// 디폴트 메소드 Java 8 이후, Hello Object를 받는 대신 name을 넣으면 count를 가져오는 메소드
	// SQL로 해도 되지만 findHello를 이용하면 다른 쿼리를 만들지 않아도 됨
	default int countOf(String name) {

		Hello hello = findHello(name);
		return hello == null ? 0 : hello.getCount();

	}
	
}
