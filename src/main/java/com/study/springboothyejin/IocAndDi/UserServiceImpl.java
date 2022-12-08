package com.study.springboothyejin.IocAndDi;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = null;
    private UserServiceImpl() {}

    public static UserServiceImpl getInstance() {
        if(instance == null){
            instance = new UserServiceImpl();
        }
        return instance;
    }
    // 만들어진 싱글톤 객체는 static 에 저장되어있기 때문에 어디서든 꺼내쓸 수 있음

    @Override
    public void createUser() {
        System.out.println("사용자 등록");
    }

    @Override
    public void getUser() {
        System.out.println("사용자 조회");
    }

    @Override
    public void updateUser() {
        System.out.println("사용자 수정");
    }

    @Override
    public void deleteUser() {
        System.out.println("사용자 삭제");
    }
}
