package authz.post

import rego.v1

import data.helpers
import data.helpers.utils

#--- Setup ---#
default allow = false

permission := helpers.permissions.retrieve_permission(input, data.post.permissions)  # The relevant permission (ex: post / delete / self )
roles := helpers.roles.retrieve_roles(input, permission)                             # The roles associated with the request and permission

allow if {
    utils.contains_a_value_from(roles.user_roles, roles.allow_roles)            # Allow if the user has one of the roles that a permission requires.
    not utils.contains_a_value_from(roles.user_roles, roles.deny_roles)         # Deny if the user has a role that a permission doesn't allow.
    not utils.contains_a_value_from(roles.author_roles, roles.deny_other_roles) # Deny if the author has a role that a permission doesn't allow.
}