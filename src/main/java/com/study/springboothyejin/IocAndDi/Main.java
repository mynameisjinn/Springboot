package com.study.springboothyejin.IocAndDi;

public class Main {

    private final UserService userService;

    public Main(UserService userService) {
        this.userService = userService;
    }

    public void run(){
        userService.createUser();
        userService.updateUser();
        userService.updateUser();
        userService.deleteUser();
    }

    public static void main(String[] args){
        UserService userService = UserServiceImpl.getInstance();
        Main main = new Main(userService);
        main.run();
    }
}
