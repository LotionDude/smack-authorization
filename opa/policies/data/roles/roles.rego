package roles

permissions = {
# -------------------------------------------------- #
    "edit": {
        "self": {
            "allow_roles": {},
            "deny_roles": {}
        },
        "other": {
            "allow_roles": {"admin"},
            "deny_roles": {},
            "deny_other_roles": {"owner", "admin"}
        }
    },
# -------------------------------------------------- #
    "view": {
        "self": {
            "allow_roles": {"admin", "moderator"},
            "deny_roles": {}
        },
        "other": {
            "allow_roles": {"admin", "moderator"},
            "deny_roles": {}
        }
    },
}