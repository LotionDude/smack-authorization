package post

import data.helpers.utils

permissions = {
# -------------------------------------------------- #
    "create": {
        "self": {
            "allow_roles": {"user"},
            "deny_roles": {"muted"}
        },
        "other": {
            "allow_roles": {}, # Weird use case to create a post on another user's resource. Shouldn't be possible.
            "deny_roles": {}
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
            "deny_roles": {},
            "deny_other_roles": {"owner"}
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
# -------------------------------------------------- #
    "search": {
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