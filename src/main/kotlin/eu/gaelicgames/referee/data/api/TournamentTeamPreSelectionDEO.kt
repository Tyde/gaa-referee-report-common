package eu.gaelicgames.referee.data.api

import kotlinx.serialization.Serializable

@Serializable
data class TournamentTeamPreselectionDEO(
    val tournamentId: Long,
    val teamIds: List<Long>
)

@Serializable
data class GetTournamentTeamPreselectionDEO(
    val tournamentId: Long
)

