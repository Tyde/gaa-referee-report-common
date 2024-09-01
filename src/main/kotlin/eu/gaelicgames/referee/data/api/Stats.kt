package eu.gaelicgames.referee.data.api

import kotlinx.serialization.Serializable

@Serializable
data class RuleCountDEO(
    val rule: RuleDEO,
    val count: Int
)

@Serializable
data class GeneralStatsDEO(
    val rulesByCount: List<RuleCountDEO>
)
