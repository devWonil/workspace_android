package com.example.movie_1.interfaces;

// 1. 콜백 메서드를 만들 때 인터페이스를 선언한다
// 1.1 추상메서드를 선언한다 (구분해야 될 부분/ 데이터를 전달해야 할 경우 매개변수를 만들어준다)
// 2. 호출자에 가서 멤버변수 선언(interface)
// 2.1 필요한 곳에서 OnChangeToolbarType 속해 있는 추상메서드를 호출하면 된다
// (Movie Fragment, Info Fragment) <-- 호출자가 된다
public interface OnChangeToolbarType {
    // 확장성 있게, 유지보수 편하게 생각하기
    void onSetupType(String title);
    // 프래그먼트 -> 메소드 호출(MovieFragment, InfoFragment) 값만 던지면 됨
    // 메인 액티비티에서 콜백받음
}
