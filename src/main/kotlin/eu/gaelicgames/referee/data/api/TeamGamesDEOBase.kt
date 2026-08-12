package eu.gaelicgames.referee.data.api

import kotlinx.serialization.Serializable

@Serializable
data class TeamGamesDEO(
    val selectedTeam: TeamDEO,
    val includedAmalgamations: List<TeamDEO>,
    val games: List<TeamGameDEO>
)
