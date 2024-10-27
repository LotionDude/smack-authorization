package helpers.roles

import data.helpers.utils

import data.permissions

# Retrieve the roles information associated with a request and permission
retrieve_roles(opa_advanced_request, permission) = result {
    result := {
            # Roles defined in the configuration of a specific permission.
            "allow_roles": retrieve_allow_roles(permission),
            "deny_roles": retrieve_deny_roles(permission),
            "deny_other_roles": retrieve_deny_other_roles(permission),

            # The roles recieved from the request
            "user_roles": retrieve_user_roles(opa_advanced_request),
            "author_roles": retrieve_author_roles(opa_advanced_request)
    }
}

# Retrieve the roles from the user according to the request
retrieve_user_roles(opa_advanced_request) = result {
    result := utils.to_set(opa_advanced_request.user.roles)
}

# Retrieve the roles from the author according to the request
retrieve_author_roles(opa_advanced_request) = result {
    result := utils.to_set(opa_advanced_request.author.roles)
}

# Retrieve the roles allowed to perform an action
retrieve_allow_roles(permission) = result {
    result := utils.safe_union({permission.allow_roles, permissions.default_allow})
}

# Retrieve the roles denied to perform an action
retrieve_deny_roles(permission) = result {
    result := utils.safe_union({permission.deny_roles, permissions.default_deny})
}

# Retrieve the roles the author must have to deny the request
retrieve_deny_other_roles(permission) = result {
    result := utils.to_set(permission.deny_other_roles)
} else {
    result := utils.to_set({})
}