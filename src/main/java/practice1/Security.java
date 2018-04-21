package practice1;

import com.google.common.collect.ImmutableList;

public class Security {

    private SecurityChecker securityChecker;

    public Security(SecurityChecker checker) {
        this.securityChecker = checker;
    }

    public boolean hasAccess(User user, Permission permission, ImmutableList<Permission> permissions) {

        boolean isAdmin = securityChecker.isAdmin();
        boolean hasPermission = securityChecker.checkPermission(user, permission);
        boolean containsPermission = permissions != null && permissions.contains(permission);
        return isAdmin || hasPermission || containsPermission;
    }
}
