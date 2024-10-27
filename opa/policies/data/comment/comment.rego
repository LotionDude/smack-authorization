package comment

permissions = {
# -------------------------------------------------- #
    "create": {
        "self": {
            "allow_roles": {"user"},
            "deny_roles": {"muted"}
        },
        "other": {
            "allow_roles": {"user"},
            "deny_roles": {"muted"}
        }
    },
# -------------------------------------------------- #
    "edit": {
        "self": {
            "allow_roles": {"user"},
            "deny_roles": {"muted"}
        },
        "other": {
            "allow_roles": {"admin"},
            "deny_roles": {},
            "deny_other_roles": {"owner"}
        }
    },
# -------------------------------------------------- #
    "delete": {
        "self": {
            "allow_roles": {"user"},
            "deny_roles": {}
        },
        "other": {
            "allow_roles": {"admin", "moderator"},
            "deny_roles": {}
        }
    },
# -------------------------------------------------- #
    "upvote": {
        "self": {
            "allow_roles": {"user"},
            "deny_roles": {}
        },
        "other": {
            "allow_roles": {"user"},
            "deny_roles": {}
        }
    },
# -------------------------------------------------- #
    "view": {
        "self": {
            "allow_roles": {"user", "bot"},
            "deny_roles": {}
        },
        "other": {
            "allow_roles": {"user", "bot"},
            "deny_roles": {}
        }
    },
}