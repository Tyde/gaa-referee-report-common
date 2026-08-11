package eu.gaelicgames.referee.data.api

import kotlinx.serialization.Serializable

@Serializable
data class NewApiTokenDEO(
    val name: String,
    val expiresInDays: Int? = null
)

@Serializable
data class ApiTokenCreatedDEO(
    val id: Long,
    val name: String,
    val token: String,
    val expiresAt: String?
)

@Serializable
data class ApiTokenDEO(
    val id: Long,
    val name: String,
    val createdAt: String,
    val expiresAt: String?,
    val revoked: Boolean,
    val lastUsedAt: String?
)

@Serializable
data class RevokeApiTokenDEO(
    val id: Long
)
