package net.okjsp.user.model;

/**
 * User: langerhans
 * Date: 2014. 1. 6.
 * Time: 오후 5:04
 * Description : UserRole
 */
public enum UserRole {

    ROLE_USER("사용자"),
    ROLE_USER_NON_CERTIFIED("사용자 (인증안됨)"),
    ROLE_ADMIN("관리자");

    private String text;

    UserRole(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
