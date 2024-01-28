package eu.gaelicgames.referee.data.api

import eu.gaelicgames.referee.data.DisciplinaryAction
import eu.gaelicgames.referee.data.DisciplinaryActions
import eu.gaelicgames.referee.data.GameCode
import eu.gaelicgames.referee.data.Rule
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.transactions.transaction

@Serializable
data class RuleDEO(
    val id: Long,
    val code: Long,
    val isCaution: Boolean,
    val isBlack: Boolean,
    val isRed: Boolean,
    val description: String,
    val isDisabled: Boolean
)
@Serializable
data class ModifyRulesDEOState(
    val id: Long,
)
@Serializable
data class RuleIsDeletableDEO(
    val id: Long,
    val isDeletable: Boolean
)

@Serializable
data class NewRuleDEO(
    val code: Long,
    val isCaution: Boolean,
    val isBlack: Boolean,
    val isRed: Boolean,
    val description: String,
    val isDisabled: Boolean
)
