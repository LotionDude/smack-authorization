package helpers.utils

# Return parameter option_true if the bool == true. Else, return parameter option_false
if_else(bool, option_true, option_false) = result {
    result := {true: option_true, false: option_false}[bool]
}

# If a value is not null, then use its value. Else, assign a default value.
if_not_null_else(value, default_value) = result {
    is_null := value != null

    result := if_else(is_null, default_value, value)
}

# Checks if there are mutual values in set1 and set2
contains_a_value_from(set1, set2) = result {
    result := count(intersection({set1, set2})) > 0
}

# Converts an object to a set. Useful for converting rego objects and arrays.
to_set(arr) = result {
    result := {x | x := arr[_]}
}

# Safe wrapper for the union() function. Converts objects/arrays into sets before merging.
safe_union(sets) = result {
    result := union({to_set(s) | s := sets[_]})
}