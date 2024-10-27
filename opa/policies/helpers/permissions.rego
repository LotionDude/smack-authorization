package helpers.permissions

import data.helpers.utils

import data.helpers.roles

# Find the relevant permission from the request. This returns the permission by action (post/comment/etc.) and target (self/other).
retrieve_permission(opa_advanced_request, permissions) = result {
    is_action_performed_on_self_result := is_action_performed_on_self(opa_advanced_request)
    permission_type := utils.if_else(is_action_performed_on_self_result, "self", "other")

    action := opa_advanced_request.action

    result := permissions[action][permission_type]
}


# Find if the performed action is on a user's own resource or not.
is_action_performed_on_self(opa_advanced_request) = result {
    request_username := opa_advanced_request.user.id
    author_name := opa_advanced_request.author.id

    result := request_username == author_name
}