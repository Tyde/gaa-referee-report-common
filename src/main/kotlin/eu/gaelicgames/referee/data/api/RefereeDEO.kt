package eu.gaelicgames.referee.data.api

import eu.gaelicgames.referee.data.UserRole
import kotlinx.serialization.Serializable

@Serializable
data class RefereeDEO(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val mail: String,
)
@Serializable
data class NewRefereeDEO(
    val firstName: String,
    val lastName: String,
    val mail: String,
    val isReferee: Boolean //Otherwise its a CCC member
)
@Serializable
data class TokenDEO(
    val token: String
)
@Serializable
data class NewPasswordByTokenDEO(
    val token: String,
    val password: String
)
@Serializable
data class LoginDEO(
    val mail: String,
    val password: String
)
@Serializable
data class RefereeWithRoleDEO(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val mail: String,
    val role: UserRole
)
@Serializable
data class UpdateRefereeDAO(
    val id: Long,
    val firstName: String? = null,
    val lastName: String? = null,
    val mail: String? = null
)
@Serializable
data class UpdateRefereePasswordResponse(
    val id: Long,
    val success: Boolean,
    val message: String? = null
)

@Serializable
data class UpdateRefereePasswordDAO(
    val id: Long,
    val oldPassword: String,
    val newPassword: String
)

@Serializable
data class SetRefereeRole(
    val id: Long,
    val role: UserRole
)

@Serializable
data class ResetRefereePasswordDEO(
    val id: Long
)
