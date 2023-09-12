/*----------------------------------------------------------------------------*/
/* Source File:   GLOBALCONSTANTS.KT                                          */
/* Copyright (c), 2023 The Musketeers                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 May.30/2023  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.simple.validation.common.consts

/**
 * General purpose application constants.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
object GlobalConstants {
    const val USER_CONTROLLER_GET_RETRIEVE_USERS_INFO = "GET api/v1/users -> Retrieving Users"
    const val USER_CONTROLLER_POST_INSERT_USER_INFO = "POST api/v1/users -> Create user."
    const val USER_CONTROLLER_GET_RETRIEVE_USER_INFO = "GET api/v1/users/{userId} -> Retrieve user."
    const val USER_CONTROLLER_PATCH_USER_INFO = "PATCH api/v1/users -> Update user."
    const val USER_CONTROLLER_DELETE_USER_INFO = "DELETE api/v1/users/{userId} -> Remove user."
    const val COLON_SPACE_DELIMITER = ": "

    const val INT_ZERO = 0
    const val INT_ONE = 1
    const val INT_TWO = 2
    const val LONG_ZERO = 0L
    const val LONG_ONE = 1L
    const val LONG_TWO = 2L
}
